package com.nicholasklaene.monarchbridge.graphql.operations.rules

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRuleRequest
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleAmountCriterion
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleAmountRange
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleSplitAction
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleSplitInfo
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleStringCriterion
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class RuleOperationTest {
    // -- GetTransactionRules ----------------------------------------------

    @Test
    fun `GetTransactionRules parses rich rule with criteria, refs, and split action`() {
        val data =
            jsonNode(
                """
                {
                  "transactionRules": [
                    {
                      "id": "r-1",
                      "order": 0,
                      "merchantCriteriaUseOriginalStatement": false,
                      "merchantCriteria": [
                        {"operator": "contains", "value": "Starbucks"}
                      ],
                      "originalStatementCriteria": [
                        {"operator": "starts_with", "value": "SBX"}
                      ],
                      "merchantNameCriteria": null,
                      "amountCriteria": {
                        "operator": "between",
                        "isExpense": true,
                        "value": null,
                        "valueRange": {"lower": -50.0, "upper": -1.0}
                      },
                      "categoryIds": ["c-1", "c-2"],
                      "accountIds": ["a-1"],
                      "criteriaOwnerIsJoint": false,
                      "criteriaOwnerUserIds": ["u-1"],
                      "criteriaBusinessEntityIds": ["be-1"],
                      "criteriaBusinessEntityIsUnassigned": false,
                      "setMerchantAction": {"id": "m-99", "name": "Coffee Shops"},
                      "setCategoryAction": {"id": "c-99", "name": "Coffee"},
                      "addTagsAction": [
                        {"id": "tg-1", "name": "personal"},
                        {"id": "tg-2", "name": "treat"}
                      ],
                      "linkGoalAction": {"id": "g-1", "name": "Coffee Spending"},
                      "linkSavingsGoalAction": null,
                      "needsReviewByUserAction": {"id": "u-1", "displayName": "Sam"},
                      "unassignNeedsReviewByUserAction": false,
                      "sendNotificationAction": true,
                      "setHideFromReportsAction": false,
                      "setLinkToPaydownBudgetAction": false,
                      "reviewStatusAction": "approved",
                      "actionSetOwnerIsJoint": false,
                      "actionSetOwner": {"id": "u-2", "displayName": "Pat"},
                      "actionSetBusinessEntity": {"id": "be-2", "name": "Acme Co"},
                      "actionSetBusinessEntityIsUnassigned": false,
                      "recentApplicationCount": 12,
                      "lastAppliedAt": "2026-05-20T10:00:00Z",
                      "splitTransactionsAction": {
                        "amountType": "PERCENTAGE",
                        "splitsInfo": [
                          {
                            "categoryId": "c-a",
                            "merchantName": "Half A",
                            "amount": 50.0,
                            "tags": ["t-a"],
                            "hideFromReports": false,
                            "reviewStatus": "approved",
                            "ownerIsJoint": false
                          },
                          {
                            "categoryId": "c-b",
                            "amount": 50.0
                          }
                        ]
                      }
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetTransactionRules.parseOutput(data)
        assertThat(out.rules).hasSize(1)
        val r = out.rules.first()
        assertThat(r.id).isEqualTo("r-1")
        assertThat(r.order).isEqualTo(0)
        assertThat(r.merchantCriteriaUseOriginalStatement).isFalse()
        assertThat(r.merchantCriteria).hasSize(1)
        assertThat(r.merchantCriteria!!.first().`operator`).isEqualTo("contains")
        assertThat(r.merchantCriteria.first().value).isEqualTo("Starbucks")
        assertThat(r.originalStatementCriteria!!.first().`operator`).isEqualTo("starts_with")
        assertThat(r.merchantNameCriteria).isNull()

        assertThat(r.amountCriteria?.`operator`).isEqualTo("between")
        assertThat(r.amountCriteria?.isExpense).isTrue()
        assertThat(r.amountCriteria?.value).isNull()
        assertThat(r.amountCriteria?.valueRange?.lower).isEqualTo(-50.0)
        assertThat(r.amountCriteria?.valueRange?.upper).isEqualTo(-1.0)

        assertThat(r.categoryIds).containsExactly("c-1", "c-2")
        assertThat(r.accountIds).containsExactly("a-1")
        assertThat(r.criteriaOwnerIsJoint).isFalse()
        assertThat(r.criteriaOwnerUserIds).containsExactly("u-1")
        assertThat(r.criteriaBusinessEntityIds).containsExactly("be-1")
        assertThat(r.criteriaBusinessEntityIsUnassigned).isFalse()

        assertThat(r.setMerchantAction?.id).isEqualTo("m-99")
        assertThat(r.setMerchantAction?.name).isEqualTo("Coffee Shops")
        assertThat(r.setCategoryAction?.id).isEqualTo("c-99")
        assertThat(r.addTagsAction).hasSize(2)
        assertThat(r.addTagsAction!![0].name).isEqualTo("personal")
        assertThat(r.linkGoalAction?.id).isEqualTo("g-1")
        assertThat(r.linkSavingsGoalAction).isNull()
        assertThat(r.needsReviewByUserAction?.id).isEqualTo("u-1")
        // parseUserRef maps `displayName` onto `name`.
        assertThat(r.needsReviewByUserAction?.name).isEqualTo("Sam")
        assertThat(r.unassignNeedsReviewByUserAction).isFalse()
        assertThat(r.sendNotificationAction).isTrue()
        assertThat(r.setHideFromReportsAction).isFalse()
        assertThat(r.setLinkToPaydownBudgetAction).isFalse()
        assertThat(r.reviewStatusAction).isEqualTo("approved")
        assertThat(r.actionSetOwnerIsJoint).isFalse()
        assertThat(r.actionSetOwner?.id).isEqualTo("u-2")
        assertThat(r.actionSetOwner?.name).isEqualTo("Pat")
        assertThat(r.actionSetBusinessEntity?.id).isEqualTo("be-2")
        assertThat(r.actionSetBusinessEntityIsUnassigned).isFalse()
        assertThat(r.recentApplicationCount).isEqualTo(12)
        assertThat(r.lastAppliedAt).isEqualTo("2026-05-20T10:00:00Z")

        assertThat(r.splitTransactionsAction?.amountType).isEqualTo("PERCENTAGE")
        assertThat(r.splitTransactionsAction?.splitsInfo).hasSize(2)
        val s0 = r.splitTransactionsAction!!.splitsInfo!![0]
        assertThat(s0.categoryId).isEqualTo("c-a")
        assertThat(s0.merchantName).isEqualTo("Half A")
        assertThat(s0.amount).isEqualTo(50.0)
        assertThat(s0.tags).containsExactly("t-a")
        assertThat(s0.hideFromReports).isFalse()
        assertThat(s0.reviewStatus).isEqualTo("approved")
        assertThat(s0.ownerIsJoint).isFalse()
        val s1 = r.splitTransactionsAction.splitsInfo[1]
        assertThat(s1.merchantName).isNull()
        assertThat(s1.tags).isNull()
    }

    @Test
    fun `GetTransactionRules tolerates bare rule with only id`() {
        val data = jsonNode("""{"transactionRules": [{"id": "r-bare"}]}""")
        val out = GetTransactionRules.parseOutput(data)
        assertThat(out.rules).hasSize(1)
        val r = out.rules.first()
        assertThat(r.id).isEqualTo("r-bare")
        assertThat(r.order).isNull()
        assertThat(r.merchantCriteria).isNull()
        assertThat(r.amountCriteria).isNull()
        assertThat(r.categoryIds).isNull()
        assertThat(r.setMerchantAction).isNull()
        assertThat(r.addTagsAction).isNull()
        assertThat(r.splitTransactionsAction).isNull()
    }

    @Test
    fun `GetTransactionRules returns empty list when transactionRules missing`() {
        // path() returns a MissingNode which .map yields an empty list — confirm that contract.
        val out = GetTransactionRules.parseOutput(jsonNode("""{}"""))
        assertThat(out.rules).isEmpty()
    }

    @Test
    fun `GetTransactionRules variables are empty`() {
        assertThat(GetTransactionRules.variables(Unit)).isEmpty()
    }

    // -- CreateTransactionRule -------------------------------------------

    @Test
    fun `CreateTransactionRule parseOutput surfaces created true regardless of returned payload`() {
        val outEmpty = CreateTransactionRule.parseOutput(jsonNode("""{}"""))
        assertThat(outEmpty.created).isTrue()

        val outWithData =
            CreateTransactionRule.parseOutput(
                jsonNode("""{"createTransactionRuleV2": {"transactionRule": {"id": "r-1"}}}"""),
            )
        assertThat(outWithData.created).isTrue()
    }

    @Test
    fun `CreateTransactionRule Input from wraps the request as is`() {
        val req = CreateTransactionRuleRequest(setCategoryAction = "c-1")
        val input = CreateTransactionRule.Input.from(req)
        assertThat(input.rule).isSameAs(req)
    }

    @Test
    fun `CreateTransactionRule variables wrap input map under input key with no id injected`() {
        val req =
            CreateTransactionRuleRequest(
                merchantCriteria =
                    listOf(TransactionRuleStringCriterion(`operator` = "contains", value = "Costco")),
                setCategoryAction = "c-groceries",
                addTagsAction = listOf("t-grocery"),
            )
        val vars = CreateTransactionRule.variables(CreateTransactionRule.Input(rule = req))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        // No `id` for create.
        assertThat(input).doesNotContainKey("id")
        assertThat(input["setCategoryAction"]).isEqualTo("c-groceries")
        assertThat(input["addTagsAction"]).isEqualTo(listOf("t-grocery"))

        @Suppress("UNCHECKED_CAST")
        val merchant = input["merchantCriteria"] as List<Map<String, Any?>>
        assertThat(merchant).hasSize(1)
        assertThat(merchant[0]["operator"]).isEqualTo("contains")
        assertThat(merchant[0]["value"]).isEqualTo("Costco")
    }

    // -- UpdateTransactionRule -------------------------------------------

    @Test
    fun `UpdateTransactionRule parseOutput surfaces updated true regardless of returned payload`() {
        assertThat(UpdateTransactionRule.parseOutput(jsonNode("""{}"""))).matches { it.updated }
        assertThat(
            UpdateTransactionRule.parseOutput(
                jsonNode("""{"updateTransactionRuleV2": {"transactionRule": {"id": "r-1"}}}"""),
            ),
        ).matches { it.updated }
    }

    @Test
    fun `UpdateTransactionRule Input from injects id and copies rule`() {
        val req = CreateTransactionRuleRequest(setCategoryAction = "c-1")
        val input = UpdateTransactionRule.Input.from("r-99", req)
        assertThat(input.id).isEqualTo("r-99")
        assertThat(input.rule).isSameAs(req)
    }

    @Test
    fun `UpdateTransactionRule variables include id inside input map alongside rule fields`() {
        val req =
            CreateTransactionRuleRequest(
                setCategoryAction = "c-1",
                accountIds = listOf("a-1", "a-2"),
                sendNotificationAction = true,
            )
        val vars =
            UpdateTransactionRule.variables(UpdateTransactionRule.Input(id = "r-7", rule = req))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input["id"]).isEqualTo("r-7")
        assertThat(input["setCategoryAction"]).isEqualTo("c-1")
        assertThat(input["accountIds"]).isEqualTo(listOf("a-1", "a-2"))
        assertThat(input["sendNotificationAction"]).isEqualTo(true)
        // Null fields must be omitted to avoid clobbering on Monarch's side.
        assertThat(input).doesNotContainKeys(
            "merchantCriteria",
            "originalStatementCriteria",
            "amountCriteria",
            "addTagsAction",
            "splitTransactionsAction",
        )
    }

    @Test
    fun `UpdateTransactionRule variables map amount criteria and value range into nested map`() {
        val req =
            CreateTransactionRuleRequest(
                amountCriteria =
                    TransactionRuleAmountCriterion(
                        `operator` = "between",
                        isExpense = true,
                        valueRange = TransactionRuleAmountRange(lower = -10.0, upper = -1.0),
                    ),
            )
        val vars =
            UpdateTransactionRule.variables(UpdateTransactionRule.Input(id = "r-1", rule = req))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>

        @Suppress("UNCHECKED_CAST")
        val amountCriteria = input["amountCriteria"] as Map<String, Any?>
        assertThat(amountCriteria["operator"]).isEqualTo("between")
        assertThat(amountCriteria["isExpense"]).isEqualTo(true)
        assertThat(amountCriteria).doesNotContainKey("value") // null value field is dropped

        @Suppress("UNCHECKED_CAST")
        val range = amountCriteria["valueRange"] as Map<String, Any?>
        assertThat(range["lower"]).isEqualTo(-10.0)
        assertThat(range["upper"]).isEqualTo(-1.0)
    }

    @Test
    fun `UpdateTransactionRule variables map split action with splitsInfo entries`() {
        val req =
            CreateTransactionRuleRequest(
                splitTransactionsAction =
                    TransactionRuleSplitAction(
                        amountType = "ABSOLUTE",
                        splitsInfo =
                            listOf(
                                TransactionRuleSplitInfo(
                                    categoryId = "c-1",
                                    merchantName = "Part 1",
                                    amount = 30.0,
                                    tags = listOf("t-1"),
                                    hideFromReports = false,
                                ),
                                TransactionRuleSplitInfo(amount = 70.0),
                            ),
                    ),
            )
        val vars =
            UpdateTransactionRule.variables(UpdateTransactionRule.Input(id = "r-9", rule = req))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>

        @Suppress("UNCHECKED_CAST")
        val splitAction = input["splitTransactionsAction"] as Map<String, Any?>
        assertThat(splitAction["amountType"]).isEqualTo("ABSOLUTE")

        @Suppress("UNCHECKED_CAST")
        val splitsInfo = splitAction["splitsInfo"] as List<Map<String, Any?>>
        assertThat(splitsInfo).hasSize(2)
        assertThat(splitsInfo[0]["categoryId"]).isEqualTo("c-1")
        assertThat(splitsInfo[0]["merchantName"]).isEqualTo("Part 1")
        assertThat(splitsInfo[0]["amount"]).isEqualTo(30.0)
        assertThat(splitsInfo[0]["tags"]).isEqualTo(listOf("t-1"))
        // The second split only has amount; everything else is omitted.
        assertThat(splitsInfo[1]).containsOnlyKeys("amount")
    }

    // -- DeleteTransactionRule -------------------------------------------

    @Test
    fun `DeleteTransactionRule parses deleted flag from deleteTransactionRule deleted`() {
        val data = jsonNode("""{"deleteTransactionRule": {"deleted": true}}""")
        val out = DeleteTransactionRule.parseOutput(data)
        assertThat(out.deleted).isTrue()
    }

    @Test
    fun `DeleteTransactionRule defaults to deleted false when payload absent or false`() {
        val explicitFalse =
            DeleteTransactionRule.parseOutput(jsonNode("""{"deleteTransactionRule": {"deleted": false}}"""))
        assertThat(explicitFalse.deleted).isFalse()

        val missingFlag = DeleteTransactionRule.parseOutput(jsonNode("""{"deleteTransactionRule": {}}"""))
        assertThat(missingFlag.deleted).isFalse()

        val missingMutation = DeleteTransactionRule.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.deleted).isFalse()
    }

    @Test
    fun `DeleteTransactionRule variables flatten ruleId onto id`() {
        val vars = DeleteTransactionRule.variables(DeleteTransactionRule.Input(ruleId = "r-1"))
        assertThat(vars).containsEntry("id", "r-1")
    }

    // -- PreviewTransactionRule ------------------------------------------

    @Test
    fun `PreviewTransactionRule parses totalCount and every preview match field`() {
        val data =
            jsonNode(
                """
                {
                  "transactionRulePreview": {
                    "totalCount": 2,
                    "results": [
                      {
                        "newName": "Coffee (auto)",
                        "newSplitTransactions": [{"foo": "bar"}],
                        "newCategory": {"id": "c-99", "name": "Coffee"},
                        "newOwnerIsJoint": false,
                        "newHideFromReports": false,
                        "newTags": [{"id": "t-1", "name": "treat"}],
                        "newGoal": {"id": "g-1", "name": "Fun"},
                        "newBusinessEntity": {"id": "be-1", "name": "Acme Co"},
                        "newBusinessEntityIsUnassigned": false,
                        "transaction": {
                          "id": "tx-1",
                          "date": "2026-05-20",
                          "amount": -4.5,
                          "merchant": {"id": "m-1", "name": "Starbucks"},
                          "category": {"id": "c-1", "name": "Coffee Shops"}
                        }
                      },
                      {
                        "newName": null,
                        "transaction": {
                          "id": "tx-2",
                          "date": "2026-05-21",
                          "amount": -3.5
                        }
                      }
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = PreviewTransactionRule.parseOutput(data)
        assertThat(out.totalCount).isEqualTo(2)
        assertThat(out.results).hasSize(2)
        val r0 = out.results.first()
        assertThat(r0.newName).isEqualTo("Coffee (auto)")
        assertThat(r0.newCategory?.id).isEqualTo("c-99")
        assertThat(r0.newCategory?.name).isEqualTo("Coffee")
        assertThat(r0.newOwnerIsJoint).isFalse()
        assertThat(r0.newHideFromReports).isFalse()
        assertThat(r0.newTags).hasSize(1)
        assertThat(r0.newTags!!.first().name).isEqualTo("treat")
        assertThat(r0.newGoal?.id).isEqualTo("g-1")
        assertThat(r0.newBusinessEntity?.id).isEqualTo("be-1")
        assertThat(r0.newBusinessEntityIsUnassigned).isFalse()
        assertThat(r0.newSplitTransactions).hasSize(1)
        assertThat(r0.newSplitTransactions!!.first()["foo"]).isEqualTo("bar")
        assertThat(r0.transaction?.id).isEqualTo("tx-1")
        assertThat(r0.transaction?.amount).isEqualTo(-4.5)
        assertThat(r0.transaction?.date).isEqualTo(LocalDate.parse("2026-05-20"))
        assertThat(r0.transaction?.merchant?.name).isEqualTo("Starbucks")
        assertThat(r0.transaction?.category?.name).isEqualTo("Coffee Shops")

        val r1 = out.results[1]
        assertThat(r1.newName).isNull()
        assertThat(r1.newCategory).isNull()
        assertThat(r1.transaction?.id).isEqualTo("tx-2")
    }

    @Test
    fun `PreviewTransactionRule returns zero totalCount and empty results when preview missing`() {
        val empty = PreviewTransactionRule.parseOutput(jsonNode("""{}"""))
        assertThat(empty.totalCount).isEqualTo(0)
        assertThat(empty.results).isEmpty()

        val emptyResults =
            PreviewTransactionRule.parseOutput(
                jsonNode("""{"transactionRulePreview": {"totalCount": 0, "results": []}}"""),
            )
        assertThat(emptyResults.totalCount).isEqualTo(0)
        assertThat(emptyResults.results).isEmpty()
    }

    @Test
    fun `PreviewTransactionRule variables wrap rule under rule key and only include offset when set`() {
        val req =
            CreateTransactionRuleRequest(
                merchantNameCriteria =
                    listOf(TransactionRuleStringCriterion(`operator` = "equals", value = "Costco")),
            )
        val withOffset = PreviewTransactionRule.variables(PreviewTransactionRule.Input(rule = req, offset = 30))
        assertThat(withOffset["offset"]).isEqualTo(30)

        @Suppress("UNCHECKED_CAST")
        val ruleMap = withOffset["rule"] as Map<String, Any?>

        @Suppress("UNCHECKED_CAST")
        val criteria = ruleMap["merchantNameCriteria"] as List<Map<String, Any?>>
        assertThat(criteria.first()["operator"]).isEqualTo("equals")
        assertThat(criteria.first()["value"]).isEqualTo("Costco")

        val noOffset = PreviewTransactionRule.variables(PreviewTransactionRule.Input(rule = req))
        assertThat(noOffset).doesNotContainKey("offset")
        assertThat(noOffset).containsKey("rule")
    }

    @Test
    fun `PreviewTransactionRule Input from forwards req and offset`() {
        val req = CreateTransactionRuleRequest(setCategoryAction = "c-1")
        val withOffset = PreviewTransactionRule.Input.from(req, 60)
        assertThat(withOffset.offset).isEqualTo(60)
        assertThat(withOffset.rule).isSameAs(req)

        val noOffset = PreviewTransactionRule.Input.from(req, null)
        assertThat(noOffset.offset).isNull()
    }
}
