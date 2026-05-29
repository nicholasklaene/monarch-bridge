package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.MergeRecurringStreamsResponseData
import com.nicholasklaene.monarchbridge.generated.model.RecurringStreamRef
import com.nicholasklaene.monarchbridge.generated.model.SkipRecurringInstanceResponseData
import com.nicholasklaene.monarchbridge.generated.model.SkippedRecurringInstance
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(RecurringController::class)
@Import(GlobalExceptionHandler::class)
class RecurringControllerV7Test {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `mergeRecurringStreams returns the surviving stream id`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            MergeRecurringStreamsResponseData(
                stream = RecurringStreamRef(id = "s-survivor", name = "Netflix combined"),
            ),
        )
        mvc
            .perform(
                post("/v1/recurring/streams/merge")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"primaryStreamId":"s1","mergedStreamIds":["s2","s3"],"newName":"Netflix combined"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.stream.id").value("s-survivor"))
            .andExpect(jsonPath("$.data.stream.name").value("Netflix combined"))
    }

    @Test
    fun `mergeRecurringStreams returns 400 when required fields missing`() {
        // primaryStreamId + mergedStreamIds are required in the spec.
        mvc
            .perform(
                post("/v1/recurring/streams/merge")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `mergeRecurringStreams returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(
                post("/v1/recurring/streams/merge")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"primaryStreamId":"s1","mergedStreamIds":["s2"]}"""),
            ).andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `skipRecurringInstance confirms skipped streamId and date`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            SkipRecurringInstanceResponseData(
                instance = SkippedRecurringInstance(streamId = "s1", skippedDate = "2026-06-15"),
            ),
        )
        mvc
            .perform(
                post("/v1/recurring/s1/skip")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"skipDate":"2026-06-15"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.instance.streamId").value("s1"))
            .andExpect(jsonPath("$.data.instance.skippedDate").value("2026-06-15"))
    }

    @Test
    fun `skipRecurringInstance returns 400 when skipDate missing`() {
        // skipDate is required; spec must reject empty body.
        mvc
            .perform(
                post("/v1/recurring/s1/skip")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `skipRecurringInstance returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(
                post("/v1/recurring/s1/skip")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"skipDate":"2026-06-15"}"""),
            ).andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
