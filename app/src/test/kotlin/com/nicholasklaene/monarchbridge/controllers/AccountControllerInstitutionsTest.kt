package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.generated.model.CredentialInstitutionRow
import com.nicholasklaene.monarchbridge.generated.model.GetCredentialInstitutionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetInstitutionByPlaidIdResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTopInstitutionGroupsResponseData
import com.nicholasklaene.monarchbridge.generated.model.InstitutionDetail
import com.nicholasklaene.monarchbridge.generated.model.LinkedCredential
import com.nicholasklaene.monarchbridge.generated.model.ListLinkedCredentialsResponseData
import com.nicholasklaene.monarchbridge.generated.model.TopInstitutionGroup
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * R6 institutions endpoints on [AccountController]:
 *  GET /v1/credentials                        listLinkedCredentials
 *  GET /v1/credentials/institutions           getCredentialInstitutions
 *  GET /v1/institutions/by-plaid/{plaidId}    getInstitutionByPlaidId
 *  GET /v1/institutions/top-groups            getTopInstitutionGroups
 */
@WebMvcTest(AccountController::class)
@Import(GlobalExceptionHandler::class)
class AccountControllerInstitutionsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `listLinkedCredentials wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListLinkedCredentialsResponseData(
                credentials =
                    listOf(
                        LinkedCredential(
                            id = "cred-1",
                            institutionId = "inst-1",
                            institutionName = "Chase",
                            institutionLogo = "https://x/chase.png",
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/credentials"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.credentials[0].id").value("cred-1"))
            .andExpect(jsonPath("$.data.credentials[0].institutionName").value("Chase"))
    }

    @Test
    fun `getCredentialInstitutions wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCredentialInstitutionsResponseData(
                credentials =
                    listOf(
                        CredentialInstitutionRow(
                            credentialId = "cred-1",
                            institutionId = "inst-1",
                            name = "Chase",
                            plaidInstitutionId = "ins_3",
                            preferredDataProvider = "PLAID",
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/credentials/institutions"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.credentials[0].credentialId").value("cred-1"))
            .andExpect(jsonPath("$.data.credentials[0].preferredDataProvider").value("PLAID"))
    }

    @Test
    fun `getInstitutionByPlaidId wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetInstitutionByPlaidIdResponseData(
                institution =
                    InstitutionDetail(
                        id = "inst-1",
                        name = "Chase",
                        plaidStatus = "HEALTHY",
                        status = "ACTIVE",
                    ),
            ),
        )
        mvc
            .perform(get("/v1/institutions/by-plaid/ins_3"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.institution.id").value("inst-1"))
            .andExpect(jsonPath("$.data.institution.plaidStatus").value("HEALTHY"))
    }

    @Test
    fun `getTopInstitutionGroups wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTopInstitutionGroupsResponseData(
                groups =
                    listOf(
                        TopInstitutionGroup(
                            type = "bank",
                            title = "Banks",
                            shortTitle = "Bank",
                            accountsConnectedCount = 2,
                            institutions = emptyList(),
                        ),
                    ),
                credentialsCount = 5,
                equityAccountsCount = 3,
            ),
        )
        mvc
            .perform(get("/v1/institutions/top-groups"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.credentialsCount").value(5))
            .andExpect(jsonPath("$.data.groups[0].type").value("bank"))
            .andExpect(jsonPath("$.data.groups[0].title").value("Banks"))
    }

    @Test
    fun `getTopInstitutionGroups passes through dataProvider param`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTopInstitutionGroupsResponseData(
                groups = emptyList(),
                credentialsCount = 0,
                equityAccountsCount = 0,
            ),
        )
        mvc
            .perform(get("/v1/institutions/top-groups").param("dataProvider", "FINICITY"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.groups").isArray)
    }
}
