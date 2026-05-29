package com.nicholasklaene.monarchbridge.auth

import com.nicholasklaene.monarchbridge.exceptions.MonarchMfaRequiredException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Instant

/**
 * RFC 6238 Appendix B test vectors (SHA-1 row).
 * https://datatracker.ietf.org/doc/html/rfc6238#appendix-B
 *
 * The RFC seed for SHA-1 is the ASCII string "12345678901234567890"
 * Base32 encoding of that is "GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQ"
 */
class TotpTest {
    /**
     * RFC 6238 Appendix B test seed: "12345678901234567890" in ASCII.
     * Base32: GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQ
     */
    private val rfcSeedBase32 = "GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQ"

    /**
     * RFC 6238 Appendix B vectors (SHA-1):
     * Time(s)        OTP
     * 59             94287082
     * 1111111109     07081804
     * 1111111111     14050471
     * 1234567890     89005924
     * 2000000000     69279037
     * 20000000000    65353130
     *
     * Note: The RFC uses 8-digit codes. Our implementation is 6-digit.
     * Taking the last 6 digits of the RFC's 8-digit values:
     * 94287082 → 287082   (counter = 59 / 30 = 1)
     * 07081804 → 081804   (counter = 1111111109 / 30 = 37037036)
     * 14050471 → 050471   (counter = 1111111111 / 30 = 37037037)
     * 89005924 → 005924   (counter = 1234567890 / 30 = 41152263)
     * 69279037 → 279037   (counter = 2000000000 / 30 = 66666666)
     * 65353130 → 353130   (counter = 20000000000 / 30 = 666666666)
     *
     * Actually for 6-digit TOTP with the same seed, we generate our own expected values
     * using the same RFC algorithm. The RFC truncates to 8 digits via mod 10^8;
     * 6-digit mode uses mod 10^6 instead.
     *
     * We verify specific known-good values by running against the RFC seed.
     */
    @Test
    fun `TOTP RFC 6238 vector - time 59`() {
        // Counter = 59 / 30 = 1
        // HMAC-SHA1 of key "12345678901234567890" with counter=1
        // Expected 6-digit output computed from RFC HMAC values: 287082
        val result = Totp.generate(rfcSeedBase32, Instant.ofEpochSecond(59))
        assertThat(result).hasSize(6)
        assertThat(result).isEqualTo("287082")
    }

    @Test
    fun `TOTP RFC 6238 vector - time 1111111109`() {
        // Counter = 1111111109 / 30 = 37037036
        val result = Totp.generate(rfcSeedBase32, Instant.ofEpochSecond(1111111109))
        assertThat(result).hasSize(6)
        assertThat(result).isEqualTo("081804")
    }

    @Test
    fun `TOTP RFC 6238 vector - time 1111111111`() {
        // Counter = 1111111111 / 30 = 37037037
        val result = Totp.generate(rfcSeedBase32, Instant.ofEpochSecond(1111111111))
        assertThat(result).hasSize(6)
        assertThat(result).isEqualTo("050471")
    }

    @Test
    fun `TOTP RFC 6238 vector - time 1234567890`() {
        // Counter = 1234567890 / 30 = 41152263
        val result = Totp.generate(rfcSeedBase32, Instant.ofEpochSecond(1234567890))
        assertThat(result).hasSize(6)
        assertThat(result).isEqualTo("005924")
    }

    @Test
    fun `TOTP RFC 6238 vector - time 2000000000`() {
        // Counter = 2000000000 / 30 = 66666666
        val result = Totp.generate(rfcSeedBase32, Instant.ofEpochSecond(2000000000))
        assertThat(result).hasSize(6)
        assertThat(result).isEqualTo("279037")
    }

    @Test
    fun `TOTP output is always 6 digits zero padded`() {
        // Use a time that would naturally produce a small code to verify zero-padding
        // (we cannot guarantee a small code, but we can verify length + digit-only)
        val result = Totp.generate(rfcSeedBase32, Instant.ofEpochSecond(1))
        assertThat(result).hasSize(6)
        assertThat(result).matches("[0-9]{6}")
    }

    @Test
    fun `TOTP lower-case base32 is accepted`() {
        val lower = rfcSeedBase32.lowercase()
        val upper = rfcSeedBase32
        val t = Instant.ofEpochSecond(59)
        assertThat(Totp.generate(lower, t)).isEqualTo(Totp.generate(upper, t))
    }

    @Test
    fun `TOTP base32 with padding is accepted`() {
        val padded = "$rfcSeedBase32=="
        val t = Instant.ofEpochSecond(59)
        assertThat(Totp.generate(padded, t)).isEqualTo(Totp.generate(rfcSeedBase32, t))
    }

    @Test
    fun `TOTP generate uses Instant_now() when no time arg given`() {
        // Just calling without `time` exercises the default-argument path; result must be 6 digits.
        val result = Totp.generate(rfcSeedBase32)
        assertThat(result).hasSize(6).matches("[0-9]{6}")
    }

    @Test
    fun `TOTP rejects invalid Base32 character`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            Totp.generate("INVALID_CHAR_!@#", Instant.ofEpochSecond(59))
        }
    }

    @Test
    fun `MonarchMfaRequiredException default message`() {
        assertThat(MonarchMfaRequiredException().message).contains("MFA")
    }

    @Test
    fun `MonarchMfaRequiredException custom message`() {
        assertThat(MonarchMfaRequiredException("custom").message).isEqualTo("custom")
    }
}
