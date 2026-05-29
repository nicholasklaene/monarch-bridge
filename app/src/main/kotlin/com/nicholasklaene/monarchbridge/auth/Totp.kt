package com.nicholasklaene.monarchbridge.auth

import java.time.Instant
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

/**
 * RFC 6238 TOTP generator (HOTP with time counter).
 *
 * Uses HmacSHA1 per RFC 6238 §4. Time step is 30 seconds. Output is 6 digits.
 * Test vectors: RFC 6238 Appendix B (SHA-1 row).
 */
object Totp {
    private const val DIGITS = 6
    private const val STEP_SECONDS = 30L
    private const val HMAC_ALGO = "HmacSHA1"
    private const val MODULUS = 1_000_000 // 10^6

    // Bit-manipulation constants for HOTP dynamic truncation (RFC 4226 §5.4)
    private const val BYTE_MASK = 0xFF
    private const val SIGN_MASK = 0x7F
    private const val NIBBLE_MASK = 0x0F
    private const val COUNTER_BYTES = 8
    private const val BASE32_BITS = 5
    private const val BITS_PER_BYTE = 8
    private const val SHIFT_24 = 24
    private const val SHIFT_16 = 16
    private const val SHIFT_8 = 8

    // 4-byte dynamic truncation: bytes at offset+0 through offset+3
    private const val TRUNC_BYTE_3 = 3

    /**
     * Generates a 6-digit TOTP code for the given base32-encoded secret at [time].
     *
     * @param secretBase32 Base32-encoded TOTP seed (padding optional).
     * @param time         Point in time to generate the code for (defaults to now).
     * @return 6-digit zero-padded string.
     */
    fun generate(
        secretBase32: String,
        time: Instant = Instant.now(),
    ): String {
        val counter = time.epochSecond / STEP_SECONDS
        val code = hotp(decodeBase32(secretBase32), counter)
        return code.toString().padStart(DIGITS, '0')
    }

    /**
     * HOTP (RFC 4226): HMAC-SHA1 of the 8-byte big-endian counter, then dynamic truncation.
     */
    private fun hotp(
        key: ByteArray,
        counter: Long,
    ): Int {
        val counterBytes = ByteArray(COUNTER_BYTES)
        var c = counter
        for (i in (COUNTER_BYTES - 1) downTo 0) {
            counterBytes[i] = (c and BYTE_MASK.toLong()).toByte()
            c = c ushr BITS_PER_BYTE
        }
        val mac = Mac.getInstance(HMAC_ALGO)
        mac.init(SecretKeySpec(key, HMAC_ALGO))
        val hmac = mac.doFinal(counterBytes)

        val offset = hmac[hmac.size - 1].toInt() and NIBBLE_MASK
        val byte0 = (hmac[offset].toInt() and SIGN_MASK) shl SHIFT_24
        val byte1 = (hmac[offset + 1].toInt() and BYTE_MASK) shl SHIFT_16
        val byte2 = (hmac[offset + 2].toInt() and BYTE_MASK) shl SHIFT_8
        val byte3 = hmac[offset + TRUNC_BYTE_3].toInt() and BYTE_MASK
        val binCode = byte0 or byte1 or byte2 or byte3
        return binCode % MODULUS
    }

    /**
     * Minimal Base32 decoder (RFC 4648 §6). Handles upper/lower-case; strips '=' padding.
     * No external dependency required.
     */
    private fun decodeBase32(input: String): ByteArray {
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567"
        val clean = input.uppercase().trimEnd('=').replace(" ", "")
        var bits = 0L
        var bitsAccumulated = 0
        val output = mutableListOf<Byte>()
        for (ch in clean) {
            val value = alphabet.indexOf(ch)
            require(value >= 0) { "Invalid Base32 character: $ch" }
            bits = (bits shl BASE32_BITS) or value.toLong()
            bitsAccumulated += BASE32_BITS
            if (bitsAccumulated >= BITS_PER_BYTE) {
                bitsAccumulated -= BITS_PER_BYTE
                output.add(((bits shr bitsAccumulated) and BYTE_MASK.toLong()).toByte())
            }
        }
        return output.toByteArray()
    }
}
