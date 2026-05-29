package com.nicholasklaene.monarchbridge.auth

import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.config.MonarchProperties
import com.nicholasklaene.monarchbridge.exceptions.MonarchMfaRequiredException
import com.nicholasklaene.monarchbridge.exceptions.MonarchRequestFailedException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.time.Instant

/**
 * Handles Monarch Money authentication: login, MFA, and TOTP-based auto-MFA.
 *
 * NOT invoked autonomously — only called by [com.nicholasklaene.monarchbridge.MonarchBootstrapMain].
 *
 * All payload-shape assumptions are annotated with // VERIFY-AT-BOOTSTRAP and reconciled
 * against a real Monarch response on first interactive bootstrap.
 */
@Component
class MonarchAuth(
    private val properties: MonarchProperties,
    private val objectMapper: ObjectMapper,
) {
    companion object {
        private val log = KotlinLogging.logger {}

        private const val LOGIN_PATH = "/auth/login/"
        private const val MFA_STATUS = 403
        private const val HTTP_OK = 200
    }

    /**
     * Performs initial login with email + password.
     *
     * Returns a [MonarchSession] on success.
     * Throws [MonarchMfaRequiredException] if Monarch responds with HTTP 403 (MFA required).
     *
     * Payload sent: `{username, password, supports_mfa: true, trusted_device: true}`
     * // VERIFY-AT-BOOTSTRAP: confirm field names match Monarch's /auth/login/ contract.
     * // VERIFY-AT-BOOTSTRAP: confirm HTTP 403 is the correct MFA-required signal (not 200+error_code).
     */
    fun login(
        email: String,
        password: String,
    ): MonarchSession {
        val body =
            mapOf(
                "username" to email, // VERIFY-AT-BOOTSTRAP: field name is "username" (not "email")
                "password" to password,
                "supports_mfa" to true, // VERIFY-AT-BOOTSTRAP: required for trusted-device long-lived token
                "trusted_device" to true, // VERIFY-AT-BOOTSTRAP: required to get tokenExpiration=null
            )
        return doLogin(body, email)
    }

    /**
     * Performs login with TOTP code (for interactive MFA after [MonarchMfaRequiredException]).
     *
     * Payload sent: `{username, password, totp, supports_mfa: true, trusted_device: true}`
     * // VERIFY-AT-BOOTSTRAP: confirm "totp" is the correct field name.
     * // VERIFY-AT-BOOTSTRAP: confirm this hits the same /auth/login/ endpoint (not /auth/totp/).
     */
    fun loginWithMfa(
        email: String,
        password: String,
        mfaCode: String,
    ): MonarchSession {
        val body =
            mapOf(
                "username" to email,
                "password" to password,
                "totp" to mfaCode, // VERIFY-AT-BOOTSTRAP: field name matches upstream _multi_factor_authenticate
                "supports_mfa" to true,
                "trusted_device" to true,
            )
        return doLogin(body, email)
    }

    /**
     * Generates a TOTP code from [totpSecret] (base32) and calls [loginWithMfa].
     *
     * Uses RFC 6238 via [Totp].
     */
    fun loginWithMfaSecret(
        email: String,
        password: String,
        totpSecret: String,
    ): MonarchSession {
        val code = Totp.generate(totpSecret)
        log.info { "Generated TOTP code for MFA login (email=$email)" }
        return loginWithMfa(email, password, code)
    }

    @Suppress("LongMethod", "CyclomaticComplexMethod", "ThrowsCount")
    private fun doLogin(
        body: Map<String, Any>,
        email: String,
    ): MonarchSession {
        val restClient =
            RestClient
                .builder()
                .baseUrl(properties.baseUrl)
                .defaultHeader("Content-Type", "application/json")
                .build()

        val responseBytes =
            restClient
                .post()
                .uri(LOGIN_PATH)
                .body(objectMapper.writeValueAsBytes(body))
                .exchange { _, response ->
                    val status = response.statusCode.value()
                    when {
                        status == MFA_STATUS -> {
                            // VERIFY-AT-BOOTSTRAP: 403 is the MFA-required signal per upstream _login_user line 3578
                            throw MonarchMfaRequiredException(
                                "Monarch requires MFA — provide --mfa-secret or enter TOTP code",
                            )
                        }

                        status != HTTP_OK -> {
                            val errBody = response.body.readAllBytes().decodeToString()
                            // VERIFY-AT-BOOTSTRAP: error response shape {detail, error_code}
                            throw MonarchRequestFailedException(
                                status,
                                errBody,
                                "Monarch login failed with HTTP $status",
                            )
                        }

                        else -> {
                            response.body.readAllBytes()
                        }
                    }
                }

        val tree = objectMapper.readTree(responseBytes)
        // VERIFY-AT-BOOTSTRAP: response has top-level "token" field (not nested)
        val token =
            tree.path("token").asText(null)
                ?: throw MonarchRequestFailedException(
                    HTTP_OK,
                    tree.toString(),
                    "Monarch login response missing 'token' field",
                )

        // VERIFY-AT-BOOTSTRAP: long-lived sessions have tokenExpiration == null
        val tokenExpiration = tree.path("tokenExpiration")
        if (!tokenExpiration.isNull && !tokenExpiration.isMissingNode) {
            log.warn { "Monarch returned a non-null tokenExpiration - token may be short-lived. Consider re-login." }
        }

        log.info { "Monarch login successful (email=$email)" }
        return MonarchSession(token = token, email = email, lastVerifiedAt = Instant.now())
    }
}
