package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.CreateTagResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListTagsResponseData
import com.nicholasklaene.monarchbridge.generated.model.Tag
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TagController::class)
@Import(GlobalExceptionHandler::class)
class TagControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `listTags wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListTagsResponseData(
                tags =
                    listOf(
                        Tag(id = "t1", name = "Business", color = "#19D2A5"),
                        Tag(id = "t2", name = "Travel", color = "#FF0000"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/tags"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.tags[0].id").value("t1"))
            .andExpect(jsonPath("$.data.tags[0].name").value("Business"))
            .andExpect(jsonPath("$.data.tags[0].color").value("#19D2A5"))
            .andExpect(jsonPath("$.data.tags[1].id").value("t2"))
    }

    @Test
    fun `listTags returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/tags"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `createTag wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreateTagResponseData(
                tag = Tag(id = "t99", name = "Business", color = "#19D2A5"),
            ),
        )
        mvc
            .perform(
                post("/v1/tags")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"Business","color":"#19D2A5"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.tag.id").value("t99"))
            .andExpect(jsonPath("$.data.tag.name").value("Business"))
            .andExpect(jsonPath("$.data.tag.color").value("#19D2A5"))
    }

    @Test
    fun `createTag returns 400 when color pattern fails`() {
        mvc
            .perform(
                post("/v1/tags")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"Business","color":"not-a-hex"}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }
}
