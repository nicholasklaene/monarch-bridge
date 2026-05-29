package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdPreferencesRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HouseholdPreferencesOperationTest {
    @Test
    fun `GetHouseholdPreferences parses key flags`() {
        val out =
            GetHouseholdPreferences.parseOutput(
                jsonNode(
                    """
                    {"householdPreferences": {
                      "id": "p-1",
                      "newTransactionsNeedReview": true,
                      "aiAssistantEnabled": false,
                      "investmentTransactionsEnabled": true,
                      "eligibleForFinancialInsights": true
                    }}
                    """.trimIndent(),
                ),
            )
        assertThat(out.id).isEqualTo("p-1")
        assertThat(out.newTransactionsNeedReview).isTrue()
        assertThat(out.aiAssistantEnabled).isFalse()
        assertThat(out.investmentTransactionsEnabled).isTrue()
        assertThat(out.collaborationToolsEnabled).isNull()
    }

    @Test
    fun `UpdateHouseholdPreferences only forwards non-null fields`() {
        val input =
            UpdateHouseholdPreferences.Input.from(
                UpdateHouseholdPreferencesRequest(
                    newTransactionsNeedReview = true,
                    aiAssistantEnabled = false,
                ),
            )
        val vars = UpdateHouseholdPreferences.variables(input)

        @Suppress("UNCHECKED_CAST")
        val inputMap = vars["input"] as Map<String, Any?>
        assertThat(inputMap).containsEntry("newTransactionsNeedReview", true)
        assertThat(inputMap).containsEntry("aiAssistantEnabled", false)
        assertThat(inputMap).doesNotContainKey("llmEnrichmentEnabled")
    }

    @Test
    fun `UpdateHouseholdPreferences parses the response householdPreferences node`() {
        val out =
            UpdateHouseholdPreferences.parseOutput(
                jsonNode(
                    """
                    {"updateHouseholdPreferences": {"householdPreferences": {
                      "id": "p-1", "newTransactionsNeedReview": false, "aiAssistantEnabled": true
                    }}}
                    """.trimIndent(),
                ),
            )
        assertThat(out.id).isEqualTo("p-1")
        assertThat(out.newTransactionsNeedReview).isFalse()
        assertThat(out.aiAssistantEnabled).isTrue()
    }

    @Test
    fun `operation names match`() {
        assertThat(GetHouseholdPreferences.operationName).isEqualTo("Common_GetHouseholdPreferences")
        assertThat(UpdateHouseholdPreferences.operationName).isEqualTo("Common_UpdateHouseholdPreferences")
    }
}
