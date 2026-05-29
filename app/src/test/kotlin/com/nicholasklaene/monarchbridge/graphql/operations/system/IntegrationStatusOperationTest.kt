package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IntegrationStatusOperationTest {
    @Test
    fun `GetIntegrationStatus parses every row including health flags and error metadata`() {
        val data =
            jsonNode(
                """
                {
                  "integrationStatus": [
                    {"credentialId":"c1","institutionName":"Chase","provider":"plaid",
                     "status":"connected","lastSyncedAt":"2026-05-26T08:00:00Z",
                     "errorCode":null,"errorMessage":null,"needsReauth":false},
                    {"credentialId":"c2","institutionName":"Fidelity","provider":"mx",
                     "status":"error","lastSyncedAt":"2026-05-20T08:00:00Z",
                     "errorCode":"INVALID_CREDENTIALS","errorMessage":"Password expired",
                     "needsReauth":true},
                    {"credentialId":"c3","institutionName":"Manual entry","provider":"manual",
                     "status":"disconnected","lastSyncedAt":null,
                     "errorCode":null,"errorMessage":null,"needsReauth":null}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetIntegrationStatus.parseOutput(data)
        assertThat(out.integrations).hasSize(3)
        // Healthy connection.
        assertThat(out.integrations[0].status).isEqualTo("connected")
        assertThat(out.integrations[0].needsReauth).isFalse
        assertThat(out.integrations[0].errorCode).isNull()
        // Errored connection — this is what the "Connection issues" banner surfaces.
        assertThat(out.integrations[1].status).isEqualTo("error")
        assertThat(out.integrations[1].errorCode).isEqualTo("INVALID_CREDENTIALS")
        assertThat(out.integrations[1].errorMessage).isEqualTo("Password expired")
        assertThat(out.integrations[1].needsReauth).isTrue
        // Manual = no provider connection at all; flags are nullable.
        assertThat(out.integrations[2].provider).isEqualTo("manual")
        assertThat(out.integrations[2].needsReauth).isNull()
        assertThat(out.integrations[2].lastSyncedAt).isNull()
    }

    @Test
    fun `GetIntegrationStatus returns empty list for accounts with no credentials yet`() {
        val out = GetIntegrationStatus.parseOutput(jsonNode("""{"integrationStatus":[]}"""))
        assertThat(out.integrations).isEmpty()
    }

    @Test
    fun `GetIntegrationStatus defaults credentialId to empty when row missing it`() {
        // Useful when a row is malformed — we want a non-null id (empty), not a crash.
        val out = GetIntegrationStatus.parseOutput(jsonNode("""{"integrationStatus":[{}]}"""))
        assertThat(out.integrations).hasSize(1)
        assertThat(out.integrations.first().credentialId).isEmpty()
        assertThat(out.integrations.first().status).isNull()
    }

    @Test
    fun `GetIntegrationStatus variables are empty`() {
        assertThat(GetIntegrationStatus.variables(Unit)).isEmpty()
    }
}
