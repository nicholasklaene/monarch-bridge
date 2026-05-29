package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.UpdateMerchantRecurrenceRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateMerchantRecurrenceResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Update a merchant's recurring-transaction settings (frequency, base date, amount,
 * active flag). `name` is required by Monarch — pass the merchant's existing display
 * name if you only want to change recurrence fields.
 *
 * Output is the spec-generated inner `data` payload.
 */
object UpdateMerchantRecurrence : MonarchOperation<UpdateMerchantRecurrence.Input, UpdateMerchantRecurrenceResponseData> {
    override val operationName: String = "Common_UpdateMerchant"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val merchantId: String,
        val name: String,
        val isRecurring: Boolean? = null,
        val frequency: String? = null,
        val baseDate: String? = null,
        val amount: Double? = null,
        val isActive: Boolean? = null,
    ) {
        companion object {
            fun from(
                merchantId: String,
                req: UpdateMerchantRecurrenceRequest,
            ): Input =
                Input(
                    merchantId = merchantId,
                    name = req.name,
                    isRecurring = req.isRecurring,
                    frequency = req.frequency,
                    baseDate = req.baseDate,
                    amount = req.amount,
                    isActive = req.isActive,
                )
        }
    }

    @Suppress("CyclomaticComplexMethod") // 5 optional patch fields, each requires a guarded put.
    override fun variables(input: Input): Map<String, Any?> {
        val recurrence =
            buildMap<String, Any?> {
                if (input.isRecurring != null) put("isRecurring", input.isRecurring)
                if (input.frequency != null) put("frequency", input.frequency)
                if (input.baseDate != null) put("baseDate", input.baseDate)
                if (input.amount != null) put("amount", input.amount)
                if (input.isActive != null) put("isActive", input.isActive)
            }
        val inner =
            buildMap<String, Any?> {
                put("merchantId", input.merchantId)
                put("name", input.name)
                if (recurrence.isNotEmpty()) put("recurringTransactionStream", recurrence)
            }
        return mapOf("input" to inner)
    }

    override fun parseOutput(data: JsonNode): UpdateMerchantRecurrenceResponseData {
        val m = data.path("updateMerchant").path("merchant")
        if (m.isMissingNode || m.isNull) return UpdateMerchantRecurrenceResponseData(merchant = null)
        @Suppress("UNCHECKED_CAST")
        return UpdateMerchantRecurrenceResponseData(
            merchant = ObjectMapper().convertValue(m, Map::class.java) as Map<String, Any>,
        )
    }
}
