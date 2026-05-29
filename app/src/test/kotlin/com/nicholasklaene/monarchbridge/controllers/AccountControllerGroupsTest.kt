package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.AccountGroup
import com.nicholasklaene.monarchbridge.generated.model.AccountGroupOrderEntry
import com.nicholasklaene.monarchbridge.generated.model.GetAccountGroupsResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountGroupOrderResponseData
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(AccountController::class)
@Import(GlobalExceptionHandler::class)
class AccountControllerGroupsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getAccountGroups returns id, name, order, accountIds for each group`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetAccountGroupsResponseData(
                groups =
                    listOf(
                        AccountGroup(id = "g1", name = "Banking", order = 1, isCollapsed = false, accountIds = listOf("a1", "a2")),
                        AccountGroup(id = "g2", name = "Brokerage", order = 2, isCollapsed = true, accountIds = listOf("a3")),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/account-groups"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.groups[0].id").value("g1"))
            .andExpect(jsonPath("$.data.groups[0].name").value("Banking"))
            .andExpect(jsonPath("$.data.groups[0].order").value(1))
            .andExpect(jsonPath("$.data.groups[0].isCollapsed").value(false))
            .andExpect(jsonPath("$.data.groups[0].accountIds[0]").value("a1"))
            .andExpect(jsonPath("$.data.groups[1].isCollapsed").value(true))
    }

    @Test
    fun `getAccountGroups returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/account-groups"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `updateAccountGroupOrder echoes back the new id-order pairs`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateAccountGroupOrderResponseData(
                groups =
                    listOf(
                        AccountGroupOrderEntry(id = "g3", order = 0),
                        AccountGroupOrderEntry(id = "g1", order = 1),
                        AccountGroupOrderEntry(id = "g2", order = 2),
                    ),
            ),
        )
        mvc
            .perform(
                put("/v1/account-groups/order")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"groupIds":["g3","g1","g2"]}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.groups[0].id").value("g3"))
            .andExpect(jsonPath("$.data.groups[0].order").value(0))
            .andExpect(jsonPath("$.data.groups[2].id").value("g2"))
    }

    @Test
    fun `updateAccountGroupOrder returns 400 when groupIds missing from body`() {
        // groupIds is required in the spec — the generator's validator must reject an empty body.
        mvc
            .perform(
                put("/v1/account-groups/order")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `updateAccountGroupOrder returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(
                put("/v1/account-groups/order")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"groupIds":["g1"]}"""),
            ).andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
