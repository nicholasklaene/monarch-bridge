package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.GoalsApi
import com.nicholasklaene.monarchbridge.generated.model.ContributeToGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.ContributeToGoalResponse
import com.nicholasklaene.monarchbridge.generated.model.CreateGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateGoalResponse
import com.nicholasklaene.monarchbridge.generated.model.GetGoalContributionHistoryResponse
import com.nicholasklaene.monarchbridge.generated.model.GetGoalProjectionResponse
import com.nicholasklaene.monarchbridge.generated.model.GetGoalsCurrentMonthTotalsResponse
import com.nicholasklaene.monarchbridge.generated.model.HardDeleteGoalResponse
import com.nicholasklaene.monarchbridge.generated.model.LinkTransactionToGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.LinkTransactionToGoalResponse
import com.nicholasklaene.monarchbridge.generated.model.ListGoalEventsResponse
import com.nicholasklaene.monarchbridge.generated.model.ListGoalsResponse
import com.nicholasklaene.monarchbridge.generated.model.MarkGoalCompleteResponse
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponse
import com.nicholasklaene.monarchbridge.generated.model.SetGoalBudgetAmountRequest
import com.nicholasklaene.monarchbridge.generated.model.SpendFromGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.SpendFromGoalResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateGoalsPrioritiesRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateGoalsPrioritiesResponse
import com.nicholasklaene.monarchbridge.generated.model.WithdrawFromGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.WithdrawFromGoalResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.goals.ArchiveGoal
import com.nicholasklaene.monarchbridge.graphql.operations.goals.ContributeToGoal
import com.nicholasklaene.monarchbridge.graphql.operations.goals.CreateGoal
import com.nicholasklaene.monarchbridge.graphql.operations.goals.DeleteGoal
import com.nicholasklaene.monarchbridge.graphql.operations.goals.DeleteGoalV2
import com.nicholasklaene.monarchbridge.graphql.operations.goals.GetGoal
import com.nicholasklaene.monarchbridge.graphql.operations.goals.GetGoalContributionHistory
import com.nicholasklaene.monarchbridge.graphql.operations.goals.GetGoalEvents
import com.nicholasklaene.monarchbridge.graphql.operations.goals.GetGoalProjection
import com.nicholasklaene.monarchbridge.graphql.operations.goals.GetGoals
import com.nicholasklaene.monarchbridge.graphql.operations.goals.GetGoalsCurrentMonthTotals
import com.nicholasklaene.monarchbridge.graphql.operations.goals.LinkTransactionToGoal
import com.nicholasklaene.monarchbridge.graphql.operations.goals.MarkGoalComplete
import com.nicholasklaene.monarchbridge.graphql.operations.goals.MarkGoalIncomplete
import com.nicholasklaene.monarchbridge.graphql.operations.goals.SetGoalBudgetAmount
import com.nicholasklaene.monarchbridge.graphql.operations.goals.SpendFromGoal
import com.nicholasklaene.monarchbridge.graphql.operations.goals.UnarchiveGoal
import com.nicholasklaene.monarchbridge.graphql.operations.goals.UnlinkTransactionGoalRecords
import com.nicholasklaene.monarchbridge.graphql.operations.goals.UpdateGoal
import com.nicholasklaene.monarchbridge.graphql.operations.goals.UpdateGoalsPriorities
import com.nicholasklaene.monarchbridge.graphql.operations.goals.WithdrawFromGoal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

/**
 * Savings goals (v2). All HTTP wiring comes from the spec-generated [GoalsApi]; this class
 * dispatches each method to the matching GraphQL operation and wraps the typed payload in
 * the matching spec-generated `*Response` envelope.
 */
@RestController
@Suppress("TooManyFunctions")
class GoalController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    GoalsApi {
    override fun listGoals(): ResponseEntity<ListGoalsResponse> = ResponseEntity.ok(ListGoalsResponse(data = exec(GetGoals, Unit)))

    override fun getGoal(id: String): ResponseEntity<CreateGoalResponse> =
        ResponseEntity.ok(CreateGoalResponse(data = exec(GetGoal, GetGoal.Input(id))))

    override fun createGoal(createGoalRequest: CreateGoalRequest): ResponseEntity<CreateGoalResponse> =
        ResponseEntity.ok(CreateGoalResponse(data = exec(CreateGoal, CreateGoal.Input.from(createGoalRequest))))

    override fun updateGoal(
        id: String,
        updateGoalRequest: UpdateGoalRequest,
    ): ResponseEntity<CreateGoalResponse> =
        ResponseEntity.ok(CreateGoalResponse(data = exec(UpdateGoal, UpdateGoal.Input.from(id, updateGoalRequest))))

    override fun contributeToGoal(
        id: String,
        contributeToGoalRequest: ContributeToGoalRequest,
    ): ResponseEntity<ContributeToGoalResponse> =
        ResponseEntity.ok(
            ContributeToGoalResponse(
                data = exec(ContributeToGoal, ContributeToGoal.Input.from(id, contributeToGoalRequest)),
            ),
        )

    override fun archiveGoal(id: String): ResponseEntity<CreateGoalResponse> =
        ResponseEntity.ok(CreateGoalResponse(data = exec(ArchiveGoal, ArchiveGoal.Input(id))))

    override fun unarchiveGoal(id: String): ResponseEntity<CreateGoalResponse> =
        ResponseEntity.ok(CreateGoalResponse(data = exec(UnarchiveGoal, UnarchiveGoal.Input(id))))

    override fun hardDeleteGoal(id: String): ResponseEntity<HardDeleteGoalResponse> =
        ResponseEntity.ok(HardDeleteGoalResponse(data = exec(DeleteGoal, DeleteGoal.Input(id))))

    override fun listGoalEvents(id: String): ResponseEntity<ListGoalEventsResponse> =
        ResponseEntity.ok(ListGoalEventsResponse(data = exec(GetGoalEvents, GetGoalEvents.Input(id))))

    override fun getGoalsCurrentMonthTotals(
        startMonth: LocalDate?,
        endMonth: LocalDate?,
    ): ResponseEntity<GetGoalsCurrentMonthTotalsResponse> {
        val defaultMonth = LocalDate.now().withDayOfMonth(1).toString()
        return ResponseEntity.ok(
            GetGoalsCurrentMonthTotalsResponse(
                data =
                    exec(
                        GetGoalsCurrentMonthTotals,
                        GetGoalsCurrentMonthTotals.Input(
                            startMonth = startMonth?.toString() ?: defaultMonth,
                            endMonth = endMonth?.toString() ?: defaultMonth,
                        ),
                    ),
            ),
        )
    }

    override fun updateGoalsPriorities(
        updateGoalsPrioritiesRequest: UpdateGoalsPrioritiesRequest,
    ): ResponseEntity<UpdateGoalsPrioritiesResponse> =
        ResponseEntity.ok(
            UpdateGoalsPrioritiesResponse(
                data = exec(UpdateGoalsPriorities, UpdateGoalsPriorities.Input.from(updateGoalsPrioritiesRequest)),
            ),
        )

    override fun setGoalBudgetAmount(
        id: String,
        setGoalBudgetAmountRequest: SetGoalBudgetAmountRequest,
    ): ResponseEntity<MarkTransactionStreamAsNotRecurringResponse> =
        ResponseEntity.ok(
            MarkTransactionStreamAsNotRecurringResponse(
                data = exec(SetGoalBudgetAmount, SetGoalBudgetAmount.Input.from(id, setGoalBudgetAmountRequest)),
            ),
        )

    /** Stamp `completedAt=now` on a goal. */
    override fun markGoalComplete(id: String): ResponseEntity<MarkGoalCompleteResponse> =
        ResponseEntity.ok(
            MarkGoalCompleteResponse(data = exec(MarkGoalComplete, MarkGoalComplete.Input(id))),
        )

    /** Clear `completedAt`. */
    override fun markGoalIncomplete(id: String): ResponseEntity<MarkGoalCompleteResponse> =
        ResponseEntity.ok(
            MarkGoalCompleteResponse(data = exec(MarkGoalIncomplete, MarkGoalIncomplete.Input(id))),
        )

    /** Hard-delete a goal via the v2 mutation. */
    override fun deleteGoalV2(id: String): ResponseEntity<MarkTransactionStreamAsNotRecurringResponse> =
        ResponseEntity.ok(
            MarkTransactionStreamAsNotRecurringResponse(data = exec(DeleteGoalV2, DeleteGoalV2.Input(id))),
        )

    /** Record a spend event against a goal. */
    override fun spendFromGoal(
        id: String,
        spendFromGoalRequest: SpendFromGoalRequest,
    ): ResponseEntity<SpendFromGoalResponse> =
        ResponseEntity.ok(
            SpendFromGoalResponse(data = exec(SpendFromGoal, SpendFromGoal.Input.from(id, spendFromGoalRequest))),
        )

    /** Withdraw money from a goal back to a source account. */
    override fun withdrawFromGoal(
        id: String,
        withdrawFromGoalRequest: WithdrawFromGoalRequest,
    ): ResponseEntity<WithdrawFromGoalResponse> =
        ResponseEntity.ok(
            WithdrawFromGoalResponse(data = exec(WithdrawFromGoal, WithdrawFromGoal.Input.from(id, withdrawFromGoalRequest))),
        )

    /** Tie a transaction to a goal so it is credited to that goal's balance. */
    override fun linkTransactionToGoal(
        id: String,
        linkTransactionToGoalRequest: LinkTransactionToGoalRequest,
    ): ResponseEntity<LinkTransactionToGoalResponse> =
        ResponseEntity.ok(
            LinkTransactionToGoalResponse(
                data = exec(LinkTransactionToGoal, LinkTransactionToGoal.Input.from(id, linkTransactionToGoalRequest)),
            ),
        )

    /** Drop all goal-reconciliation records for one transaction. */
    override fun unlinkTransactionGoalRecords(id: String): ResponseEntity<MarkTransactionStreamAsNotRecurringResponse> =
        ResponseEntity.ok(
            MarkTransactionStreamAsNotRecurringResponse(
                data = exec(UnlinkTransactionGoalRecords, UnlinkTransactionGoalRecords.Input(id)),
            ),
        )

    /** Ledger of explicit contributions logged against one goal. */
    override fun getGoalContributionHistory(id: String): ResponseEntity<GetGoalContributionHistoryResponse> =
        ResponseEntity.ok(
            GetGoalContributionHistoryResponse(
                data = exec(GetGoalContributionHistory, GetGoalContributionHistory.Input(goalId = id)),
            ),
        )

    /** Forward projection of a goal's balance at the current planned contribution rate. */
    override fun getGoalProjection(id: String): ResponseEntity<GetGoalProjectionResponse> =
        ResponseEntity.ok(
            GetGoalProjectionResponse(
                data = exec(GetGoalProjection, GetGoalProjection.Input(goalId = id)),
            ),
        )
}
