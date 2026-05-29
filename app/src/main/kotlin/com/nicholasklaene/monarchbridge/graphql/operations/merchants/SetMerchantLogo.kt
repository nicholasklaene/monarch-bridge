package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetMerchantResponseData
import com.nicholasklaene.monarchbridge.generated.model.SetMerchantLogoRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Point a merchant at an existing Cloudinary asset by public id. Monarch's
 * `setMerchantLogo` mutation does NOT accept a binary upload — the asset must already
 * exist on the Cloudinary side. Pass `cloudinaryPublicId = null` to clear the logo.
 */
object SetMerchantLogo : MonarchOperation<SetMerchantLogo.Input, GetMerchantResponseData> {
    override val operationName: String = "Common_SetMerchantLogo"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val merchantId: String,
        val cloudinaryPublicId: String? = null,
    ) {
        companion object {
            fun from(
                merchantId: String,
                req: SetMerchantLogoRequest,
            ): Input = Input(merchantId = merchantId, cloudinaryPublicId = req.cloudinaryPublicId)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "merchantId" to input.merchantId,
                    "cloudinaryPublicId" to input.cloudinaryPublicId,
                ),
        )

    override fun parseOutput(data: JsonNode): GetMerchantResponseData =
        GetMerchantResponseData(merchant = MerchantMappers.parseMerchant(data.path("setMerchantLogo").path("merchant")))
}
