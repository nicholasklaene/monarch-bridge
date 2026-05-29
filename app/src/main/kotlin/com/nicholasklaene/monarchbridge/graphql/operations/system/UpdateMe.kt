package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateMeRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateMeResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/** Patch the current user's profile (email, name, birthday, timezone). */
object UpdateMe : MonarchOperation<UpdateMe.Input, UpdateMeResponseData> {
    override val operationName: String = "Common_UpdateMe"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val email: String?,
        val name: String?,
        val birthday: LocalDate?,
        val timezone: String?,
    ) {
        companion object {
            fun from(req: UpdateMeRequest): Input =
                Input(
                    email = req.email,
                    name = req.name,
                    birthday = req.birthday,
                    timezone = req.timezone,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val map = mutableMapOf<String, Any?>()
        input.email?.let { map["email"] = it }
        input.name?.let { map["name"] = it }
        input.birthday?.let { map["birthday"] = it.toString() }
        input.timezone?.let { map["timezone"] = it }
        return mapOf("input" to map)
    }

    override fun parseOutput(data: JsonNode): UpdateMeResponseData {
        val me = data.path("updateMe").path("me")
        return UpdateMeResponseData(
            id = me.path("id").asText(""),
            email = me.path("email").asTextOrNull(),
            name = me.path("name").asTextOrNull(),
            displayName = me.path("displayName").asTextOrNull(),
            timezone = me.path("timezone").asTextOrNull(),
            birthday = me.path("birthday").asTextOrNull(),
        )
    }
}
