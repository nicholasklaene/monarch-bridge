package com.nicholasklaene.monarchbridge

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

/**
 * Smoke test — Spring context starts. Replaced in Stage 4 with proper controller + service tests.
 */
@SpringBootTest
class ApplicationTest {
    @Test
    fun `context loads`() {
        // Spring's @SpringBootTest will fail this test if any bean wiring is broken.
    }
}
