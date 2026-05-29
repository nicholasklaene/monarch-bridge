package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionSplitTemplatesResponseData
import com.nicholasklaene.monarchbridge.generated.model.SplitTemplate
import com.nicholasklaene.monarchbridge.generated.model.SplitTemplateEntry
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Saved split templates - reusable percent-based split definitions. */
object GetTransactionSplitTemplates : MonarchOperation<Unit, GetTransactionSplitTemplatesResponseData> {
    override val operationName: String = "Web_GetTransactionSplitTemplates"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetTransactionSplitTemplatesResponseData =
        GetTransactionSplitTemplatesResponseData(
            templates =
                data.path("transactionSplitTemplates").map { t ->
                    SplitTemplate(
                        id = t.path("id").asText(""),
                        name = t.path("name").asText(""),
                        splits =
                            t.path("splits").map { s ->
                                SplitTemplateEntry(
                                    categoryId = s.path("categoryId").asText(""),
                                    categoryName = s.path("categoryName").asTextOrNull(),
                                    percent = s.path("percent").asDoubleOrNull(),
                                )
                            },
                    )
                },
        )
}
