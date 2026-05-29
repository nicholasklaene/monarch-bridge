package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.RulesApi
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRuleRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRuleResponse
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponse
import com.nicholasklaene.monarchbridge.generated.model.ListTransactionRulesResponse
import com.nicholasklaene.monarchbridge.generated.model.PreviewTransactionRuleResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionRuleResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.rules.CreateTransactionRule
import com.nicholasklaene.monarchbridge.graphql.operations.rules.DeleteTransactionRule
import com.nicholasklaene.monarchbridge.graphql.operations.rules.GetTransactionRules
import com.nicholasklaene.monarchbridge.graphql.operations.rules.PreviewTransactionRule
import com.nicholasklaene.monarchbridge.graphql.operations.rules.UpdateTransactionRule
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Transaction-rule (auto-categorization) CRUD + dry-run preview. HTTP wiring from
 * spec-generated [RulesApi]. See `agents/context/AGENTS.md` for the rule shape walkthrough.
 *
 * Note: `deleteTransactionRule` returns `DeleteAccountResponse` because the spec
 * generator dedupes responses with identical `{deleted: Boolean}` shape under the
 * first-seen name. Same pattern as `deleteTransaction`.
 */
@RestController
class RuleController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    RulesApi {
    override fun listTransactionRules(): ResponseEntity<ListTransactionRulesResponse> =
        ResponseEntity.ok(ListTransactionRulesResponse(data = exec(GetTransactionRules, Unit)))

    override fun createTransactionRule(
        createTransactionRuleRequest: CreateTransactionRuleRequest,
    ): ResponseEntity<CreateTransactionRuleResponse> =
        ResponseEntity.ok(
            CreateTransactionRuleResponse(
                data = exec(CreateTransactionRule, CreateTransactionRule.Input.from(createTransactionRuleRequest)),
            ),
        )

    override fun updateTransactionRule(
        id: String,
        createTransactionRuleRequest: CreateTransactionRuleRequest,
    ): ResponseEntity<UpdateTransactionRuleResponse> =
        ResponseEntity.ok(
            UpdateTransactionRuleResponse(
                data = exec(UpdateTransactionRule, UpdateTransactionRule.Input.from(id, createTransactionRuleRequest)),
            ),
        )

    override fun deleteTransactionRule(id: String): ResponseEntity<DeleteAccountResponse> =
        ResponseEntity.ok(DeleteAccountResponse(data = exec(DeleteTransactionRule, DeleteTransactionRule.Input(id))))

    override fun previewTransactionRule(
        createTransactionRuleRequest: CreateTransactionRuleRequest,
        offset: Int?,
    ): ResponseEntity<PreviewTransactionRuleResponse> =
        ResponseEntity.ok(
            PreviewTransactionRuleResponse(
                data = exec(PreviewTransactionRule, PreviewTransactionRule.Input.from(createTransactionRuleRequest, offset)),
            ),
        )
}
