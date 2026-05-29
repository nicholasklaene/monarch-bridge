package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryGroupRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateCategoryGroupBudgetVariabilityRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateCategoryGroupRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CategoryOperationTest {
    @Test
    fun `GetCategories parses each Category and its group`() {
        val data =
            jsonNode(
                """
                {
                  "categories": [
                    {"id":"c1","name":"Groceries","icon":"🍎","order":1,"systemCategory":"food",
                     "isSystemCategory":true,
                     "group":{"id":"g1","name":"Food","type":"expense"}},
                    {"id":"c2","name":"Coffee Shops","icon":"☕","order":2,"systemCategory":null,
                     "isSystemCategory":false,
                     "group":{"id":"g1","name":"Food","type":"expense"}}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetCategories.parseOutput(data)
        assertThat(out.categories).hasSize(2)
        val first = out.categories.first()
        assertThat(first.id).isEqualTo("c1")
        assertThat(first.name).isEqualTo("Groceries")
        assertThat(first.icon).isEqualTo("🍎")
        assertThat(first.order).isEqualTo(1)
        assertThat(first.systemCategory).isEqualTo("food")
        assertThat(first.isSystemCategory).isTrue
        assertThat(first.group?.id).isEqualTo("g1")
        assertThat(first.group?.name).isEqualTo("Food")
        assertThat(first.group?.type).isEqualTo("expense")
        assertThat(out.categories[1].systemCategory).isNull()
        assertThat(out.categories[1].isSystemCategory).isFalse
    }

    @Test
    fun `GetCategories returns empty list when categories array is empty`() {
        val data = jsonNode("""{"categories": []}""")
        val out = GetCategories.parseOutput(data)
        assertThat(out.categories).isEmpty()
    }

    @Test
    fun `GetCategories handles category without a group`() {
        val data =
            jsonNode(
                """
                {
                  "categories": [
                    {"id":"c9","name":"Misc","icon":"❓","order":99,"isSystemCategory":false}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetCategories.parseOutput(data)
        assertThat(out.categories).hasSize(1)
        assertThat(out.categories.first().id).isEqualTo("c9")
        assertThat(out.categories.first().name).isEqualTo("Misc")
        assertThat(out.categories.first().group).isNull()
    }

    @Test
    fun `CreateCategory parses the new category from nested response`() {
        val data =
            jsonNode(
                """
                {
                  "createCategory": {
                    "category": {
                      "id":"new-c","name":"Hobbies","icon":"🎨","order":5,
                      "systemCategory":null,"isSystemCategory":false,
                      "group":{"id":"g3","name":"Lifestyle","type":"expense"}
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = CreateCategory.parseOutput(data)
        assertThat(out.category.id).isEqualTo("new-c")
        assertThat(out.category.name).isEqualTo("Hobbies")
        assertThat(out.category.icon).isEqualTo("🎨")
        assertThat(out.category.order).isEqualTo(5)
        assertThat(out.category.group?.name).isEqualTo("Lifestyle")
        assertThat(out.category.group?.type).isEqualTo("expense")
    }

    @Test
    fun `CreateCategory falls back to defaults when fields missing`() {
        val data =
            jsonNode(
                """
                {"createCategory": {"category": {"id":"x"}}}
                """.trimIndent(),
            )
        val out = CreateCategory.parseOutput(data)
        assertThat(out.category.id).isEqualTo("x")
        assertThat(out.category.name).isEmpty()
        assertThat(out.category.order).isEqualTo(0)
        assertThat(out.category.isSystemCategory).isFalse
        assertThat(out.category.group).isNull()
    }

    @Test
    fun `DeleteCategory parses deleted true`() {
        val data = jsonNode("""{"deleteCategory": {"deleted": true}}""")
        val out = DeleteCategory.parseOutput(data)
        assertThat(out.deleted).isTrue
    }

    @Test
    fun `DeleteCategory parses deleted false`() {
        val data = jsonNode("""{"deleteCategory": {"deleted": false}}""")
        val out = DeleteCategory.parseOutput(data)
        assertThat(out.deleted).isFalse
    }

    @Test
    fun `DeleteCategory defaults to false when field absent`() {
        val data = jsonNode("""{"deleteCategory": {}}""")
        val out = DeleteCategory.parseOutput(data)
        assertThat(out.deleted).isFalse
    }

    @Test
    fun `GetCategoryGroups parses each group`() {
        val data =
            jsonNode(
                """
                {
                  "categoryGroups": [
                    {"id":"g1","name":"Food","type":"expense"},
                    {"id":"g2","name":"Salary","type":"income"},
                    {"id":"g3","name":"Transfers","type":null}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetCategoryGroups.parseOutput(data)
        assertThat(out.categoryGroups).hasSize(3)
        assertThat(out.categoryGroups[0].id).isEqualTo("g1")
        assertThat(out.categoryGroups[0].name).isEqualTo("Food")
        assertThat(out.categoryGroups[0].type).isEqualTo("expense")
        assertThat(out.categoryGroups[1].type).isEqualTo("income")
        assertThat(out.categoryGroups[2].type).isNull()
    }

    @Test
    fun `GetCategoryGroups returns empty list when array empty`() {
        val data = jsonNode("""{"categoryGroups": []}""")
        val out = GetCategoryGroups.parseOutput(data)
        assertThat(out.categoryGroups).isEmpty()
    }

    // -- CreateCategoryGroup ----------------------------------------------

    @Test
    fun `CreateCategoryGroup parses every CategoryGroupFields fragment field`() {
        val data =
            jsonNode(
                """
                {
                  "createCategoryGroup": {
                    "categoryGroup": {
                      "id": "g-new",
                      "name": "Investing",
                      "order": 5,
                      "type": "expense",
                      "color": "#00FF00",
                      "groupLevelBudgetingEnabled": true,
                      "budgetVariability": "flexible",
                      "rolloverPeriod": {
                        "id": "rp-1",
                        "startMonth": "2026-01-01",
                        "endMonth": "2026-12-31",
                        "startingBalance": 100.0
                      }
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = CreateCategoryGroup.parseOutput(data)
        assertThat(out.categoryGroup.id).isEqualTo("g-new")
        assertThat(out.categoryGroup.name).isEqualTo("Investing")
        assertThat(out.categoryGroup.order).isEqualTo(5)
        assertThat(out.categoryGroup.type).isEqualTo("expense")
        assertThat(out.categoryGroup.color).isEqualTo("#00FF00")
        assertThat(out.categoryGroup.groupLevelBudgetingEnabled).isTrue()
        assertThat(out.categoryGroup.budgetVariability).isEqualTo("flexible")
        assertThat(out.categoryGroup.rolloverPeriod?.id).isEqualTo("rp-1")
        assertThat(out.categoryGroup.rolloverPeriod?.startMonth).isEqualTo("2026-01-01")
        assertThat(out.categoryGroup.rolloverPeriod?.endMonth).isEqualTo("2026-12-31")
        assertThat(out.categoryGroup.rolloverPeriod?.startingBalance).isEqualTo(100.0)
    }

    @Test
    fun `CreateCategoryGroup defaults id and name to empty and rolloverPeriod to null when payload bare`() {
        val out = CreateCategoryGroup.parseOutput(jsonNode("""{"createCategoryGroup": {"categoryGroup": {}}}"""))
        assertThat(out.categoryGroup.id).isEmpty()
        assertThat(out.categoryGroup.name).isEmpty()
        assertThat(out.categoryGroup.rolloverPeriod).isNull()
    }

    @Test
    fun `CreateCategoryGroup variables wrap required and only non-null optionals in input`() {
        val minimal =
            CreateCategoryGroup.variables(
                CreateCategoryGroup.Input(name = "Food", type = "expense"),
            )

        @Suppress("UNCHECKED_CAST")
        val minInput = minimal["input"] as Map<String, Any?>
        assertThat(minInput["name"]).isEqualTo("Food")
        assertThat(minInput["type"]).isEqualTo("expense")
        assertThat(minInput).doesNotContainKeys(
            "color",
            "icon",
            "budgetVariability",
            "groupLevelBudgetingEnabled",
            "orderBefore",
            "rolloverEnabled",
            "rolloverType",
            "rolloverStartMonth",
            "rolloverStartingBalance",
        )

        val full =
            CreateCategoryGroup.variables(
                CreateCategoryGroup.Input(
                    name = "Investing",
                    type = "expense",
                    color = "#FF0000",
                    icon = "trending",
                    budgetVariability = "flexible",
                    groupLevelBudgetingEnabled = true,
                    orderBefore = "g-2",
                    rolloverEnabled = true,
                    rolloverType = "unlimited",
                    rolloverStartMonth = "2026-01-01",
                    rolloverStartingBalance = 250.0,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val fullInput = full["input"] as Map<String, Any?>
        assertThat(fullInput["color"]).isEqualTo("#FF0000")
        assertThat(fullInput["icon"]).isEqualTo("trending")
        assertThat(fullInput["budgetVariability"]).isEqualTo("flexible")
        assertThat(fullInput["groupLevelBudgetingEnabled"]).isEqualTo(true)
        assertThat(fullInput["orderBefore"]).isEqualTo("g-2")
        assertThat(fullInput["rolloverEnabled"]).isEqualTo(true)
        assertThat(fullInput["rolloverType"]).isEqualTo("unlimited")
        assertThat(fullInput["rolloverStartMonth"]).isEqualTo("2026-01-01")
        assertThat(fullInput["rolloverStartingBalance"]).isEqualTo(250.0)
    }

    @Test
    fun `CreateCategoryGroup Input from copies every request field`() {
        val req =
            CreateCategoryGroupRequest(
                name = "Health",
                type = "expense",
                color = "#0000FF",
                icon = "heart",
                budgetVariability = "fixed",
                groupLevelBudgetingEnabled = false,
                orderBefore = "g-3",
                rolloverEnabled = false,
                rolloverType = null,
                rolloverStartMonth = null,
                rolloverStartingBalance = null,
            )
        val input = CreateCategoryGroup.Input.from(req)
        assertThat(input.name).isEqualTo("Health")
        assertThat(input.type).isEqualTo("expense")
        assertThat(input.color).isEqualTo("#0000FF")
        assertThat(input.icon).isEqualTo("heart")
        assertThat(input.budgetVariability).isEqualTo("fixed")
        assertThat(input.groupLevelBudgetingEnabled).isFalse()
        assertThat(input.orderBefore).isEqualTo("g-3")
        assertThat(input.rolloverEnabled).isFalse()
        assertThat(input.rolloverType).isNull()
    }

    // -- UpdateCategoryGroup ----------------------------------------------

    @Test
    fun `UpdateCategoryGroup parses updated group from updateCategoryGroup categoryGroup`() {
        val data =
            jsonNode(
                """
                {
                  "updateCategoryGroup": {
                    "categoryGroup": {
                      "id": "g-1",
                      "name": "Renamed",
                      "order": 1,
                      "type": "expense",
                      "color": "#123456",
                      "groupLevelBudgetingEnabled": false,
                      "budgetVariability": "fixed",
                      "rolloverPeriod": null
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateCategoryGroup.parseOutput(data)
        assertThat(out.categoryGroup.id).isEqualTo("g-1")
        assertThat(out.categoryGroup.name).isEqualTo("Renamed")
        assertThat(out.categoryGroup.color).isEqualTo("#123456")
        assertThat(out.categoryGroup.budgetVariability).isEqualTo("fixed")
        assertThat(out.categoryGroup.rolloverPeriod).isNull()
    }

    @Test
    fun `UpdateCategoryGroup defaults id and name to empty when subtree absent`() {
        val out = UpdateCategoryGroup.parseOutput(jsonNode("""{"updateCategoryGroup": {}}"""))
        assertThat(out.categoryGroup.id).isEmpty()
        assertThat(out.categoryGroup.name).isEmpty()
    }

    @Test
    fun `UpdateCategoryGroup variables always carry id and only the patched fields`() {
        val idOnly = UpdateCategoryGroup.variables(UpdateCategoryGroup.Input(id = "g-1"))

        @Suppress("UNCHECKED_CAST")
        val idOnlyInput = idOnly["input"] as Map<String, Any?>
        assertThat(idOnlyInput).containsEntry("id", "g-1")
        assertThat(idOnlyInput).doesNotContainKeys(
            "name",
            "color",
            "icon",
            "budgetVariability",
            "groupLevelBudgetingEnabled",
            "rolloverEnabled",
            "rolloverType",
            "rolloverStartMonth",
            "rolloverStartingBalance",
        )

        val full =
            UpdateCategoryGroup.variables(
                UpdateCategoryGroup.Input(
                    id = "g-1",
                    name = "Renamed",
                    color = "#222",
                    icon = "tag",
                    budgetVariability = "fixed",
                    groupLevelBudgetingEnabled = true,
                    rolloverEnabled = false,
                    rolloverType = "unlimited",
                    rolloverStartMonth = "2026-01-01",
                    rolloverStartingBalance = 0.0,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val fullInput = full["input"] as Map<String, Any?>
        assertThat(fullInput["id"]).isEqualTo("g-1")
        assertThat(fullInput["name"]).isEqualTo("Renamed")
        assertThat(fullInput["color"]).isEqualTo("#222")
        assertThat(fullInput["budgetVariability"]).isEqualTo("fixed")
        assertThat(fullInput["rolloverEnabled"]).isEqualTo(false)
        assertThat(fullInput["rolloverStartingBalance"]).isEqualTo(0.0)
    }

    @Test
    fun `UpdateCategoryGroup Input from injects id and copies request fields`() {
        val req =
            UpdateCategoryGroupRequest(
                name = "Renamed",
                color = "#444",
                budgetVariability = "flexible",
                rolloverEnabled = true,
            )
        val input = UpdateCategoryGroup.Input.from("g-7", req)
        assertThat(input.id).isEqualTo("g-7")
        assertThat(input.name).isEqualTo("Renamed")
        assertThat(input.color).isEqualTo("#444")
        assertThat(input.budgetVariability).isEqualTo("flexible")
        assertThat(input.rolloverEnabled).isTrue()
        assertThat(input.icon).isNull()
    }

    // -- DeleteCategoryGroup ----------------------------------------------

    @Test
    fun `DeleteCategoryGroup surfaces deleteCategoryGroup deleted true`() {
        val data = jsonNode("""{"deleteCategoryGroup": {"deleted": true}}""")
        val out = DeleteCategoryGroup.parseOutput(data)
        assertThat(out.deleted).isTrue()
    }

    @Test
    fun `DeleteCategoryGroup defaults to deleted false when missing or explicit false`() {
        val explicitFalse =
            DeleteCategoryGroup.parseOutput(jsonNode("""{"deleteCategoryGroup": {"deleted": false}}"""))
        assertThat(explicitFalse.deleted).isFalse()

        val missingFlag = DeleteCategoryGroup.parseOutput(jsonNode("""{"deleteCategoryGroup": {}}"""))
        assertThat(missingFlag.deleted).isFalse()

        val missingMutation = DeleteCategoryGroup.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.deleted).isFalse()
    }

    @Test
    fun `DeleteCategoryGroup variables include groupId as id and moveToGroupId verbatim`() {
        val withMove =
            DeleteCategoryGroup.variables(DeleteCategoryGroup.Input(groupId = "g-1", moveToGroupId = "g-2"))
        assertThat(withMove).containsEntry("id", "g-1")
        assertThat(withMove).containsEntry("moveToGroupId", "g-2")

        val withoutMove = DeleteCategoryGroup.variables(DeleteCategoryGroup.Input(groupId = "g-3"))
        assertThat(withoutMove).containsEntry("id", "g-3")
        assertThat(withoutMove).containsEntry("moveToGroupId", null)
    }

    // -- UpdateCategoryGroupBudgetVariability -----------------------------

    @Test
    fun `UpdateCategoryGroupBudgetVariability parses id, budgetVariability, updatedAt`() {
        val data =
            jsonNode(
                """
                {
                  "updateCategoryGroup": {
                    "categoryGroup": {
                      "id": "g-1",
                      "budgetVariability": "flexible",
                      "updatedAt": "2026-05-25T10:00:00Z"
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateCategoryGroupBudgetVariability.parseOutput(data)
        assertThat(out.categoryGroup.id).isEqualTo("g-1")
        assertThat(out.categoryGroup.budgetVariability).isEqualTo("flexible")
        assertThat(out.categoryGroup.updatedAt).isEqualTo("2026-05-25T10:00:00Z")
    }

    @Test
    fun `UpdateCategoryGroupBudgetVariability defaults id to empty and nullable fields to null`() {
        val out =
            UpdateCategoryGroupBudgetVariability.parseOutput(
                jsonNode("""{"updateCategoryGroup": {"categoryGroup": {}}}"""),
            )
        assertThat(out.categoryGroup.id).isEqualTo("")
        assertThat(out.categoryGroup.budgetVariability).isNull()
        assertThat(out.categoryGroup.updatedAt).isNull()
    }

    @Test
    fun `UpdateCategoryGroupBudgetVariability variables wrap id and budgetVariability in input`() {
        val vars =
            UpdateCategoryGroupBudgetVariability.variables(
                UpdateCategoryGroupBudgetVariability.Input(id = "g-1", budgetVariability = "fixed"),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input["id"]).isEqualTo("g-1")
        assertThat(input["budgetVariability"]).isEqualTo("fixed")
    }

    @Test
    fun `UpdateCategoryGroupBudgetVariability Input from injects id and copies budgetVariability`() {
        val req = UpdateCategoryGroupBudgetVariabilityRequest(budgetVariability = "non_monthly")
        val input = UpdateCategoryGroupBudgetVariability.Input.from("g-1", req)
        assertThat(input.id).isEqualTo("g-1")
        assertThat(input.budgetVariability).isEqualTo("non_monthly")
    }

    // -- CreateCategory variables + Input.from ------------------------------

    @Test
    fun `CreateCategory Input from copies set fields and defaults the optionals`() {
        val populated =
            CreateCategoryRequest(
                group = "g-1",
                name = "Home repair",
                icon = "🔧",
                rolloverEnabled = true,
                rolloverType = "annual",
                rolloverStartMonth = "2026-01-01",
            )
        val in1 = CreateCategory.Input.from(populated)
        assertThat(in1.group).isEqualTo("g-1")
        assertThat(in1.name).isEqualTo("Home repair")
        assertThat(in1.icon).isEqualTo("🔧")
        assertThat(in1.rolloverEnabled).isTrue
        assertThat(in1.rolloverType).isEqualTo("annual")
        assertThat(in1.rolloverStartMonth).isEqualTo("2026-01-01")

        val sparse = CreateCategoryRequest(group = "g-2", name = "Misc")
        val in2 = CreateCategory.Input.from(sparse)
        assertThat(in2.icon).isEqualTo("❓")
        assertThat(in2.rolloverEnabled).isFalse
        assertThat(in2.rolloverType).isEqualTo("monthly")
        // rolloverStartMonth defaults to first-of-current-month — just verify the format.
        assertThat(in2.rolloverStartMonth).matches("\\d{4}-\\d{2}-01")
    }

    @Test
    fun `CreateCategory variables nest every field under input`() {
        val vars =
            CreateCategory.variables(
                CreateCategory.Input(
                    group = "g-1",
                    name = "Home repair",
                    icon = "🔧",
                    rolloverEnabled = true,
                    rolloverType = "monthly",
                    rolloverStartMonth = "2026-05-01",
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["group"]).isEqualTo("g-1")
        assertThat(inner["name"]).isEqualTo("Home repair")
        assertThat(inner["icon"]).isEqualTo("🔧")
        assertThat(inner["rolloverEnabled"]).isEqualTo(true)
        assertThat(inner["rolloverType"]).isEqualTo("monthly")
        assertThat(inner["rolloverStartMonth"]).isEqualTo("2026-05-01")
    }

    // -- DeleteCategory variables -------------------------------------------

    @Test
    fun `DeleteCategory variables forward id and optional moveToCategoryId`() {
        val withMove = DeleteCategory.variables(DeleteCategory.Input(categoryId = "c-1", moveToCategoryId = "c-2"))
        assertThat(withMove["id"]).isEqualTo("c-1")
        assertThat(withMove["moveToCategoryId"]).isEqualTo("c-2")

        val noMove = DeleteCategory.variables(DeleteCategory.Input(categoryId = "c-1"))
        assertThat(noMove["id"]).isEqualTo("c-1")
        assertThat(noMove["moveToCategoryId"]).isNull()
    }

    // -- GetCategoryDeletionInfo ------------------------------------------------

    @Test
    fun `GetCategoryDeletionInfo parses category snapshot`() {
        val data =
            jsonNode(
                """
                {"category": {"id": "c-1", "name": "Groceries", "icon": "🛒", "isSystemCategory": false}}
                """.trimIndent(),
            )
        val out = GetCategoryDeletionInfo.parseOutput(data)
        assertThat(out.category).isNotNull
        assertThat(out.category!!.id).isEqualTo("c-1")
        assertThat(out.category.name).isEqualTo("Groceries")
        assertThat(out.category.icon).isEqualTo("🛒")
        assertThat(out.category.isSystemCategory).isFalse
    }

    @Test
    fun `GetCategoryDeletionInfo returns null category when missing or explicitly null`() {
        val missing = GetCategoryDeletionInfo.parseOutput(jsonNode("""{}"""))
        assertThat(missing.category).isNull()
        val explicitNull = GetCategoryDeletionInfo.parseOutput(jsonNode("""{"category": null}"""))
        assertThat(explicitNull.category).isNull()
    }

    @Test
    fun `GetCategoryDeletionInfo variables forward id at top level`() {
        val vars = GetCategoryDeletionInfo.variables(GetCategoryDeletionInfo.Input(id = "c-9"))
        assertThat(vars).containsExactlyEntriesOf(mapOf("id" to "c-9"))
    }

    // -- GetCategoryEdit ------------------------------------------------

    @Test
    fun `GetCategoryEdit parses every editable category and rollover field`() {
        val data =
            jsonNode(
                """
                {
                  "category": {
                    "id": "c-1",
                    "order": 3,
                    "name": "Groceries",
                    "icon": "🛒",
                    "systemCategory": "food",
                    "systemCategoryDisplayName": "Food & Dining",
                    "budgetVariability": "fixed",
                    "excludeFromBudget": false,
                    "isSystemCategory": true,
                    "isDisabled": false,
                    "isProtected": false,
                    "group": {"id": "g-1", "type": "expense", "groupLevelBudgetingEnabled": true},
                    "rolloverPeriod": {
                      "id": "rp-1",
                      "startMonth": "2026-05-01",
                      "startingBalance": 150.0,
                      "type": "monthly",
                      "frequency": "monthly",
                      "targetAmount": 500.0
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = GetCategoryEdit.parseOutput(data)
        assertThat(out.category).isNotNull
        val c = out.category!!
        assertThat(c.id).isEqualTo("c-1")
        assertThat(c.order).isEqualTo(3)
        assertThat(c.systemCategory).isEqualTo("food")
        assertThat(c.systemCategoryDisplayName).isEqualTo("Food & Dining")
        assertThat(c.budgetVariability).isEqualTo("fixed")
        assertThat(c.excludeFromBudget).isFalse
        assertThat(c.isSystemCategory).isTrue
        assertThat(c.groupId).isEqualTo("g-1")
        assertThat(c.groupLevelBudgetingEnabled).isTrue
        assertThat(c.rolloverPeriodId).isEqualTo("rp-1")
        assertThat(c.rolloverStartMonth).isEqualTo(java.time.LocalDate.of(2026, 5, 1))
        assertThat(c.rolloverStartingBalance).isEqualTo(150.0)
        assertThat(c.rolloverType).isEqualTo("monthly")
        assertThat(c.rolloverFrequency).isEqualTo("monthly")
        assertThat(c.rolloverTargetAmount).isEqualTo(500.0)
    }

    @Test
    fun `GetCategoryEdit handles category without rollover period`() {
        val data =
            jsonNode(
                """{"category": {"id": "c-2", "name": "Coffee", "icon": "☕"}}""",
            )
        val out = GetCategoryEdit.parseOutput(data)
        assertThat(out.category).isNotNull
        assertThat(out.category!!.id).isEqualTo("c-2")
        assertThat(out.category.rolloverPeriodId).isNull()
        assertThat(out.category.rolloverStartMonth).isNull()
    }

    @Test
    fun `GetCategoryEdit returns null category when missing`() {
        val out = GetCategoryEdit.parseOutput(jsonNode("""{}"""))
        assertThat(out.category).isNull()
    }

    @Test
    fun `GetCategoryEdit variables forward id at top level`() {
        val vars = GetCategoryEdit.variables(GetCategoryEdit.Input(id = "c-9"))
        assertThat(vars).containsExactlyEntriesOf(mapOf("id" to "c-9"))
    }

    // -- GetCategoryGroupDetails ------------------------------------------------

    @Test
    fun `GetCategoryGroupDetails parses group fields, rollover, and child categories`() {
        val data =
            jsonNode(
                """
                {
                  "categoryGroup": {
                    "id": "g-1",
                    "name": "Food",
                    "order": 2,
                    "type": "expense",
                    "color": "#FFAA00",
                    "groupLevelBudgetingEnabled": true,
                    "budgetVariability": "fixed",
                    "rolloverPeriod": {
                      "id": "rp-1",
                      "startMonth": "2026-05-01",
                      "endMonth": "2026-12-01",
                      "startingBalance": 0.0
                    },
                    "categories": [
                      {
                        "id": "c-1",
                        "name": "Groceries",
                        "icon": "🛒",
                        "rolloverPeriod": {"id": "rpc-1", "startMonth": "2026-05-01", "startingBalance": 50.0}
                      }
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetCategoryGroupDetails.parseOutput(data)
        assertThat(out.categoryGroup).isNotNull
        val g = out.categoryGroup!!
        assertThat(g.id).isEqualTo("g-1")
        assertThat(g.name).isEqualTo("Food")
        assertThat(g.order).isEqualTo(2)
        assertThat(g.color).isEqualTo("#FFAA00")
        assertThat(g.groupLevelBudgetingEnabled).isTrue
        assertThat(g.rolloverPeriodId).isEqualTo("rp-1")
        assertThat(g.rolloverStartMonth).isEqualTo(java.time.LocalDate.of(2026, 5, 1))
        assertThat(g.rolloverEndMonth).isEqualTo(java.time.LocalDate.of(2026, 12, 1))
        assertThat(g.categories).isNotNull
        assertThat(g.categories!!).hasSize(1)
        assertThat(g.categories[0].id).isEqualTo("c-1")
        assertThat(g.categories[0].rolloverPeriodId).isEqualTo("rpc-1")
        assertThat(g.categories[0].rolloverStartingBalance).isEqualTo(50.0)
    }

    @Test
    fun `GetCategoryGroupDetails returns null categoryGroup when missing`() {
        val out = GetCategoryGroupDetails.parseOutput(jsonNode("""{}"""))
        assertThat(out.categoryGroup).isNull()
    }

    @Test
    fun `GetCategoryGroupDetails variables forward id and optional includeDisabledSystemCategories`() {
        val withFlag =
            GetCategoryGroupDetails.variables(
                GetCategoryGroupDetails.Input(id = "g-1", includeDisabledSystemCategories = true),
            )
        assertThat(withFlag["id"]).isEqualTo("g-1")
        assertThat(withFlag["includeDisabledSystemCategories"]).isEqualTo(true)

        val withoutFlag =
            GetCategoryGroupDetails.variables(
                GetCategoryGroupDetails.Input(id = "g-2", includeDisabledSystemCategories = null),
            )
        assertThat(withoutFlag["id"]).isEqualTo("g-2")
        assertThat(withoutFlag["includeDisabledSystemCategories"]).isNull()
    }

    @Test
    fun `GetTaxCategories parses each TaxCategoryWithSystem`() {
        val data =
            jsonNode(
                """
                {
                  "categories": [
                    {"id":"c1","name":"Home Office","icon":"H","systemCategory":"homeOffice"},
                    {"id":"c2","name":"Mileage","icon":null,"systemCategory":"mileage"}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetTaxCategories.parseOutput(data)
        assertThat(out.categories).hasSize(2)
        assertThat(out.categories[0].id).isEqualTo("c1")
        assertThat(out.categories[0].systemCategory).isEqualTo("homeOffice")
        assertThat(out.categories[1].icon).isNull()
    }

    @Test
    fun `GetTaxCategories variables are empty`() {
        assertThat(GetTaxCategories.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetTaxCategoryAggregates parses category sum and count`() {
        val data =
            jsonNode(
                """
                {
                  "aggregates": [
                    {"groupBy":{"category":{"id":"c1","name":"Home Office","icon":null,"systemCategory":"homeOffice"}},
                     "summary":{"sum":-1250.0,"count":12}},
                    {"groupBy":{"category":{"id":"c2","name":"Mileage","icon":null,"systemCategory":"mileage"}},
                     "summary":{"sum":-820.5,"count":7}}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetTaxCategoryAggregates.parseOutput(data)
        assertThat(out.rows).hasSize(2)
        assertThat(out.rows[0].category.id).isEqualTo("c1")
        assertThat(out.rows[0].sum).isEqualTo(-1250.0)
        assertThat(out.rows[0].count).isEqualTo(12)
        assertThat(out.rows[1].category.systemCategory).isEqualTo("mileage")
    }

    @Test
    fun `GetTaxCategoryAggregates skips aggregate rows missing category`() {
        val data =
            jsonNode(
                """
                {
                  "aggregates": [
                    {"groupBy":{"category":null},"summary":{"sum":-1.0,"count":1}},
                    {"groupBy":{"category":{"id":"c9","name":"x","icon":null,"systemCategory":null}},
                     "summary":{"sum":-2.0,"count":2}}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetTaxCategoryAggregates.parseOutput(data)
        assertThat(out.rows).hasSize(1)
        assertThat(out.rows[0].category.id).isEqualTo("c9")
    }

    @Test
    fun `GetTaxCategoryAggregates variables include only set date bounds`() {
        val both =
            GetTaxCategoryAggregates.variables(
                GetTaxCategoryAggregates.Input(
                    startDate = java.time.LocalDate.parse("2026-01-01"),
                    endDate = java.time.LocalDate.parse("2026-12-31"),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val filters = both["filters"] as Map<String, Any?>
        assertThat(filters["startDate"]).isEqualTo("2026-01-01")
        assertThat(filters["endDate"]).isEqualTo("2026-12-31")

        val nullDates = GetTaxCategoryAggregates.variables(GetTaxCategoryAggregates.Input(null, null))

        @Suppress("UNCHECKED_CAST")
        val emptyFilters = nullDates["filters"] as Map<String, Any?>
        assertThat(emptyFilters).isEmpty()
    }

    @Test
    fun `GetTaxScheduleCategoryMappings parses mappings with lineItemInfo and category`() {
        val data =
            jsonNode(
                """
                {
                  "taxScheduleCategoryMappings": [
                    {"id":"m1","lineItem":"OFFICE_EXPENSE","schedule":"SCHEDULE_C","taxYear":2026,
                     "category":{"id":"c1","name":"Home Office","icon":"H"},
                     "lineItemInfo":{"key":"OFFICE_EXPENSE","lineNumber":"18","description":"Office expense","lineType":"EXPENSE","sortOrder":18}},
                    {"id":"m2","lineItem":"MEALS","schedule":"SCHEDULE_C","taxYear":2026,
                     "category":null,
                     "lineItemInfo":null}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetTaxScheduleCategoryMappings.parseOutput(data)
        assertThat(out.mappings).hasSize(2)
        assertThat(out.mappings[0].lineItem).isEqualTo("OFFICE_EXPENSE")
        assertThat(out.mappings[0].lineItemInfo!!.lineNumber).isEqualTo("18")
        assertThat(out.mappings[0].category!!.name).isEqualTo("Home Office")
        assertThat(out.mappings[1].category).isNull()
        assertThat(out.mappings[1].lineItemInfo).isNull()
    }

    @Test
    fun `GetTaxScheduleCategoryMappings variables forward schedule and taxYear`() {
        val v =
            GetTaxScheduleCategoryMappings.variables(
                GetTaxScheduleCategoryMappings.Input(schedule = "SCHEDULE_C", taxYear = 2026),
            )
        assertThat(v["schedule"]).isEqualTo("SCHEDULE_C")
        assertThat(v["taxYear"]).isEqualTo(2026)
    }
}
