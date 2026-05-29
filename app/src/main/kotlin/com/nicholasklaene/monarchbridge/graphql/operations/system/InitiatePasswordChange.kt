package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.InitiatePasswordChangeResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Kick off Monarch's password-change flow. No body required - Monarch emails a reset link
 * to the account's verified email. The response echoes back the `requestId` + `email`
 * for client-side confirmation.
 */
object InitiatePasswordChange : MonarchOperation<Unit, InitiatePasswordChangeResponseData> {
    override val operationName: String = "Common_InitiatePasswordChange"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): InitiatePasswordChangeResponseData {
        val node = data.path("initiatePasswordChange")
        return InitiatePasswordChangeResponseData(
            requestId = node.path("requestId").asTextOrNull(),
            email = node.path("email").asTextOrNull(),
            expiresAt = node.path("expiresAt").asTextOrNull(),
        )
    }
}
