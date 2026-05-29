package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.BudgetsApi
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetMonthResponse
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetStatusResponse
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetTimelineResponse
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetsResponse
import com.nicholasklaene.monarchbridge.generated.model.ResetBudgetRequest
import com.nicholasklaene.monarchbridge.generated.model.ResetBudgetResponse
import com.nicholasklaene.monarchbridge.generated.model.SetBudgetAmountRequest
import com.nicholasklaene.monarchbridge.generated.model.SetBudgetAmountResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateBudgetSettingsRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateBudgetSettingsResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateFlexRolloverSettingsRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateFlexRolloverSettingsResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateFlexibleBudgetRequest
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.budgets.GetBudgetMonth
import com.nicholasklaene.monarchbridge.graphql.operations.budgets.GetBudgetStatus
import com.nicholasklaene.monarchbridge.graphql.operations.budgets.GetBudgetTimeline
import com.nicholasklaene.monarchbridge.graphql.operations.budgets.GetBudgets
import com.nicholasklaene.monarchbridge.graphql.operations.budgets.ResetBudget
import com.nicholasklaene.monarchbridge.graphql.operations.budgets.SetBudgetAmount
import com.nicholasklaene.monarchbridge.graphql.operations.budgets.UpdateBudgetSettings
import com.nicholasklaene.monarchbridge.graphql.operations.budgets.UpdateFlexRolloverSettings
import com.nicholasklaene.monarchbridge.graphql.operations.budgets.UpdateFlexibleBudget
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

/**
 * Monthly budgets + Flex bucket. All HTTP wiring comes from the spec-generated
 * [BudgetsApi]; this class dispatches to operations and wraps each payload in the
 * matching spec-generated `*Response` envelope.
 *
 * Note: `updateFlexibleBudget` returns `SetBudgetAmountResponse` — the spec-generator
 * dedupes responses with identical `{id, budgetAmount}` shape under the first-seen name.
 */
@RestController
class BudgetController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    BudgetsApi {
    override fun getBudgets(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetBudgetsResponse> =
        ResponseEntity.ok(
            GetBudgetsResponse(
                data =
                    exec(
                        GetBudgets,
                        GetBudgets.Input(
                            // Default: last month → next month (Monarch's convention for budget-page views).
                            startDate = (start ?: LocalDate.now().withDayOfMonth(1).minusMonths(1)).toString(),
                            endDate = (end ?: LocalDate.now().withDayOfMonth(1).plusMonths(1)).toString(),
                        ),
                    ),
            ),
        )

    override fun setBudgetAmount(setBudgetAmountRequest: SetBudgetAmountRequest): ResponseEntity<SetBudgetAmountResponse> =
        ResponseEntity.ok(SetBudgetAmountResponse(data = exec(SetBudgetAmount, SetBudgetAmount.Input.from(setBudgetAmountRequest))))

    override fun resetBudget(resetBudgetRequest: ResetBudgetRequest): ResponseEntity<ResetBudgetResponse> =
        ResponseEntity.ok(ResetBudgetResponse(data = exec(ResetBudget, ResetBudget.Input.from(resetBudgetRequest))))

    override fun updateFlexibleBudget(updateFlexibleBudgetRequest: UpdateFlexibleBudgetRequest): ResponseEntity<SetBudgetAmountResponse> =
        ResponseEntity.ok(
            SetBudgetAmountResponse(
                data = exec(UpdateFlexibleBudget, UpdateFlexibleBudget.Input.from(updateFlexibleBudgetRequest)),
            ),
        )

    override fun updateFlexRolloverSettings(
        updateFlexRolloverSettingsRequest: UpdateFlexRolloverSettingsRequest,
    ): ResponseEntity<UpdateFlexRolloverSettingsResponse> =
        ResponseEntity.ok(
            UpdateFlexRolloverSettingsResponse(
                data = exec(UpdateFlexRolloverSettings, UpdateFlexRolloverSettings.Input.from(updateFlexRolloverSettingsRequest)),
            ),
        )

    /** Budget status flags (has-budget, has-transactions, bootstrap-path). */
    override fun getBudgetStatus(): ResponseEntity<GetBudgetStatusResponse> =
        ResponseEntity.ok(GetBudgetStatusResponse(data = exec(GetBudgetStatus, Unit)))

    /** Slim single-month budget data (per-category amounts only, no group tree). */
    override fun getBudgetMonth(month: LocalDate): ResponseEntity<GetBudgetMonthResponse> =
        ResponseEntity.ok(GetBudgetMonthResponse(data = exec(GetBudgetMonth, GetBudgetMonth.Input(month))))

    /** Household-wide budget settings: active budget system + future-month cascade default. */
    override fun updateBudgetSettings(
        updateBudgetSettingsRequest: UpdateBudgetSettingsRequest,
    ): ResponseEntity<UpdateBudgetSettingsResponse> =
        ResponseEntity.ok(
            UpdateBudgetSettingsResponse(
                data = exec(UpdateBudgetSettings, UpdateBudgetSettings.Input.from(updateBudgetSettingsRequest)),
            ),
        )

    /** Forward-looking budget vs. actual series for `monthCount` months starting at `startMonth`. */
    override fun getBudgetTimeline(
        startMonth: LocalDate,
        monthCount: Int,
    ): ResponseEntity<GetBudgetTimelineResponse> =
        ResponseEntity.ok(
            GetBudgetTimelineResponse(
                data = exec(GetBudgetTimeline, GetBudgetTimeline.Input(startMonth = startMonth, monthCount = monthCount)),
            ),
        )
}
