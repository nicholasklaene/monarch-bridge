package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.TaxApi
import com.nicholasklaene.monarchbridge.generated.model.GetTaxBracketEstimatesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTaxCategoriesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTaxCategoryAggregatesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTaxScheduleCategoryMappingsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTaxYearOverviewResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.categories.GetTaxBracketEstimates
import com.nicholasklaene.monarchbridge.graphql.operations.categories.GetTaxCategories
import com.nicholasklaene.monarchbridge.graphql.operations.categories.GetTaxCategoryAggregates
import com.nicholasklaene.monarchbridge.graphql.operations.categories.GetTaxScheduleCategoryMappings
import com.nicholasklaene.monarchbridge.graphql.operations.categories.GetTaxYearOverview
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

/**
 * Tax-prep flow: category catalog, per-category aggregates, schedule -> category mappings,
 * year overview totals, and federal bracket estimates. HTTP wiring from spec-generated
 * [TaxApi]; Operation classes live in `graphql.operations.categories/`.
 */
@RestController
class TaxController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    TaxApi {
    override fun getTaxCategories(): ResponseEntity<GetTaxCategoriesResponse> =
        ResponseEntity.ok(GetTaxCategoriesResponse(data = exec(GetTaxCategories, Unit)))

    override fun getTaxCategoryAggregates(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetTaxCategoryAggregatesResponse> =
        ResponseEntity.ok(
            GetTaxCategoryAggregatesResponse(
                data =
                    exec(
                        GetTaxCategoryAggregates,
                        GetTaxCategoryAggregates.Input(startDate = start, endDate = end),
                    ),
            ),
        )

    override fun getTaxScheduleCategoryMappings(
        schedule: String,
        taxYear: Int,
    ): ResponseEntity<GetTaxScheduleCategoryMappingsResponse> =
        ResponseEntity.ok(
            GetTaxScheduleCategoryMappingsResponse(
                data =
                    exec(
                        GetTaxScheduleCategoryMappings,
                        GetTaxScheduleCategoryMappings.Input(schedule = schedule, taxYear = taxYear),
                    ),
            ),
        )

    /** Top-level tax overview for one calendar year (totals + per-schedule summaries). */
    override fun getTaxYearOverview(taxYear: Int): ResponseEntity<GetTaxYearOverviewResponse> =
        ResponseEntity.ok(
            GetTaxYearOverviewResponse(
                data = exec(GetTaxYearOverview, GetTaxYearOverview.Input(taxYear = taxYear)),
            ),
        )

    /** Federal bracket estimates for a filing status (default: household saved status). */
    override fun getTaxBracketEstimates(
        taxYear: Int,
        filingStatus: String?,
    ): ResponseEntity<GetTaxBracketEstimatesResponse> =
        ResponseEntity.ok(
            GetTaxBracketEstimatesResponse(
                data =
                    exec(
                        GetTaxBracketEstimates,
                        GetTaxBracketEstimates.Input(taxYear = taxYear, filingStatus = filingStatus),
                    ),
            ),
        )
}
