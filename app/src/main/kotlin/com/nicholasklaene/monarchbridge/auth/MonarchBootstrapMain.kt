package com.nicholasklaene.monarchbridge.auth

import com.nicholasklaene.monarchbridge.Application
import com.nicholasklaene.monarchbridge.exceptions.MonarchMfaRequiredException
import org.springframework.boot.WebApplicationType
import org.springframework.boot.builder.SpringApplicationBuilder
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * One-time interactive Monarch Money authentication CLI.
 *
 * Usage:
 *   ./gradlew :app:bootstrapMonarch
 *   ./gradlew :app:bootstrapMonarch --args="--mfa-secret=BASE32SECRET"
 *
 * Reads email + password interactively (System.console() preferred; BufferedReader fallback for IDEs).
 * On success, writes the session JSON to the path configured in `monarch.session-path`.
 */
object MonarchBootstrapMain {
    @JvmStatic
    @Suppress("LongMethod", "TooGenericExceptionCaught")
    fun main(args: Array<String>) {
        if ("--help" in args || "-h" in args) {
            printHelp()
            return
        }

        val mfaSecret = args.firstOrNull { it.startsWith("--mfa-secret=") }?.substringAfter("=")

        val ctx =
            SpringApplicationBuilder(Application::class.java)
                .web(WebApplicationType.NONE)
                .run(*args.filter { !it.startsWith("--mfa-secret=") }.toTypedArray())

        try {
            val monarchAuth = ctx.getBean(MonarchAuth::class.java)
            val monarchSession = ctx.getBean(MonarchSessionService::class.java)

            val email = prompt("Email: ")
            val password = promptPassword("Password: ")

            val session =
                if (mfaSecret != null) {
                    println("Using --mfa-secret for automatic TOTP generation.")
                    monarchAuth.loginWithMfaSecret(email, password, mfaSecret)
                } else {
                    loginInteractive(monarchAuth, email, password)
                }

            monarchSession.save(session)
            val path = monarchSession.resolvePath()
            println("Session saved to $path")
            println("Start the service with: ./gradlew :app:bootRun")
        } finally {
            ctx.close()
        }
    }

    @Suppress("SwallowedException")
    private fun loginInteractive(
        monarchAuth: MonarchAuth,
        email: String,
        password: String,
    ) = try {
        monarchAuth.login(email, password)
    } catch (ex: MonarchMfaRequiredException) {
        println("Monarch requires MFA. Check your authenticator app.")
        val code = prompt("TOTP code: ")
        monarchAuth.loginWithMfa(email, password, code)
    }

    private fun printHelp() {
        println(
            """
            MonarchBootstrapMain — one-time Monarch Money auth setup.

            Usage:
              ./gradlew :app:bootstrapMonarch
              ./gradlew :app:bootstrapMonarch --args="--mfa-secret=<BASE32_SEED>"

            Options:
              --mfa-secret=<seed>   Base32 TOTP seed for automatic MFA (no prompt).
              --help                Show this message.

            The session JSON will be written to the path in monarch.session-path
            (default: ~/.config/monarch-bridge/.mm-session.json).
            """.trimIndent(),
        )
    }

    private fun prompt(label: String): String {
        val console = System.console()
        return if (console != null) {
            console.readLine(label)?.trim() ?: error("No input received for '$label'")
        } else {
            print(label)
            BufferedReader(InputStreamReader(System.`in`)).readLine()?.trim()
                ?: error("No input received for '$label'")
        }
    }

    private fun promptPassword(label: String): String {
        val console = System.console()
        return if (console != null) {
            String(console.readPassword(label) ?: error("No password received"))
        } else {
            // IDE/non-tty fallback — password echoed (acceptable for dev-time CLI)
            prompt(label)
        }
    }
}
