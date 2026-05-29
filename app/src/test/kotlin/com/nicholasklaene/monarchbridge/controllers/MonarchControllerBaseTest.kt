package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExecThrows
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

/**
 * Direct unit test for [MonarchControllerBase] — bypasses Spring MVC so the contract is
 * tested in isolation.
 *
 * The base provides one helper, `exec(op, input)`:
 *   1. Gate on session: call `sessionService.requireCurrent()`. If it throws, abort.
 *   2. Dispatch: `client.execute(op, input)` and return whatever the operation's
 *      `parseOutput` returned (the typed inner-data payload).
 *
 * Tested via a tiny anonymous subclass that exposes a passthrough `runExec`.
 */
class MonarchControllerBaseTest {
    private val sessionService = mock(MonarchSessionService::class.java)
    private val client = mock(MonarchClient::class.java)
    private val controller =
        object : MonarchControllerBase(sessionService, client) {
            fun <I, O> runExec(
                op: MonarchOperation<I, O>,
                input: I,
            ): O = exec(op, input)
        }

    @Test
    fun `exec gates on session then dispatches to client`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        val fakeOp = mock(MonarchOperation::class.java) as MonarchOperation<Unit, String>
        stubExec(client, "result")

        val out = controller.runExec(fakeOp, Unit)

        assertThat(out).isEqualTo("result")
        verify(sessionService).requireCurrent()
    }

    @Test
    fun `exec aborts before dispatch when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        val fakeOp = mock(MonarchOperation::class.java) as MonarchOperation<Unit, String>

        assertThatThrownBy { controller.runExec(fakeOp, Unit) }
            .isInstanceOf(MonarchSessionMissingException::class.java)
        verify(client, never()).execute(fakeOp, Unit)
    }

    @Test
    fun `exec surfaces client failures unchanged`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        val fakeOp = mock(MonarchOperation::class.java) as MonarchOperation<Unit, String>
        stubExecThrows(client, IllegalStateException("upstream boom"))

        assertThatThrownBy { controller.runExec(fakeOp, Unit) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("upstream boom")
    }
}
