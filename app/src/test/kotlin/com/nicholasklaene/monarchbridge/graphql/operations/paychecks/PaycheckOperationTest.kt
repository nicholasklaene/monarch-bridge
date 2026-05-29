package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.loadFixture
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckRequest
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDeductionInput
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDepositInput
import com.nicholasklaene.monarchbridge.generated.model.UpdatePaycheckEmployerRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdatePaycheckRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PaycheckOperationTest {
    @Test
    fun `GetPaychecks parses paycheck list including nested employer, deductions, and deposits`() {
        val data = loadFixture("paychecks/full")
        val out = GetPaychecks.parseOutput(data)
        assertThat(out.paychecks).hasSize(1)
        val p = out.paychecks.first()
        assertThat(p.id).isEqualTo("pc-1")
        assertThat(p.grossAmount).isEqualTo(5000.0)
        assertThat(p.payDate).isEqualTo("2026-05-15")
        assertThat(p.employer?.id).isEqualTo("emp-1")
        assertThat(p.employerName).isEqualTo("Acme Inc.")
        assertThat(p.payrollProvider).isEqualTo("gusto")
        assertThat(p.isMagicImported).isFalse
        assertThat(p.owner?.name).isEqualTo("Sam")
        assertThat(p.createdBy?.name).isEqualTo("Sam")
        assertThat(p.deductions).hasSize(2)
        assertThat(p.deductions!![0].deductionType).isEqualTo("federal_income_tax")
        assertThat(p.deductions[1].customDeductionName).isEqualTo("Gym")
        assertThat(p.deposits).hasSize(1)
        assertThat(
            p.deposits!!
                .first()
                .transaction
                ?.id,
        ).isEqualTo("txn-1")
        assertThat(
            p.deposits
                .first()
                .transaction
                ?.account
                ?.displayName,
        ).isEqualTo("Checking")
    }

    @Test
    fun `GetPaychecks returns empty list when no paychecks`() {
        val out = GetPaychecks.parseOutput(jsonNode("""{"paychecks": []}"""))
        assertThat(out.paychecks).isEmpty()
    }

    @Test
    fun `GetPaychecks handles paycheck with null employer and empty deductions, deposits`() {
        val data =
            jsonNode(
                """
                {"paychecks": [
                  {"id": "pc-x", "grossAmount": 1000.0, "payDate": "2026-04-30",
                   "employer": null, "employerName": "Legacy LLC",
                   "deductions": [], "deposits": []}
                ]}
                """.trimIndent(),
            )
        val out = GetPaychecks.parseOutput(data)
        assertThat(out.paychecks).hasSize(1)
        assertThat(out.paychecks.first().employer).isNull()
        assertThat(out.paychecks.first().employerName).isEqualTo("Legacy LLC")
        assertThat(out.paychecks.first().deductions).isEmpty()
        assertThat(out.paychecks.first().deposits).isEmpty()
    }

    @Test
    fun `GetPaycheck parses single paycheck under paycheck root`() {
        val data =
            jsonNode(
                """
                {"paycheck": {"id": "pc-9", "grossAmount": 2000.0, "payDate": "2026-05-01",
                  "deductions": [], "deposits": []}}
                """.trimIndent(),
            )
        val out = GetPaycheck.parseOutput(data)
        assertThat(out.paycheck.id).isEqualTo("pc-9")
        assertThat(out.paycheck.grossAmount).isEqualTo(2000.0)
    }

    @Test
    fun `GetPaychecksSummary parses aggregate stats and per-type breakdown`() {
        val data =
            jsonNode(
                """
                {
                  "paychecksSummary": {
                    "count": 12,
                    "totalGross": 60000.0,
                    "totalDeductions": 18000.0,
                    "totalNet": 42000.0,
                    "deductionRate": 0.3,
                    "deductionsByType": [
                      {"deductionType": "federal_income_tax", "totalAmount": 9000.0},
                      {"deductionType": "traditional_401k", "totalAmount": 4000.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetPaychecksSummary.parseOutput(data)
        assertThat(out.summary.count).isEqualTo(12)
        assertThat(out.summary.totalGross).isEqualTo(60000.0)
        assertThat(out.summary.totalDeductions).isEqualTo(18000.0)
        assertThat(out.summary.totalNet).isEqualTo(42000.0)
        assertThat(out.summary.deductionRate).isEqualTo(0.3)
        assertThat(out.summary.deductionsByType).hasSize(2)
        assertThat(out.summary.deductionsByType!![0].deductionType).isEqualTo("federal_income_tax")
        assertThat(out.summary.deductionsByType[1].totalAmount).isEqualTo(4000.0)
    }

    @Test
    fun `GetPaychecksSummary handles empty window with zeroes and null deductionRate`() {
        val data =
            jsonNode(
                """
                {"paychecksSummary": {"count": 0, "totalGross": 0, "totalDeductions": 0,
                  "totalNet": 0, "deductionRate": null, "deductionsByType": []}}
                """.trimIndent(),
            )
        val out = GetPaychecksSummary.parseOutput(data)
        assertThat(out.summary.count).isZero
        assertThat(out.summary.deductionRate).isNull()
        assertThat(out.summary.deductionsByType).isEmpty()
    }

    @Test
    fun `GetPaycheckEmployers parses employers and surfaces totalCount`() {
        val data =
            jsonNode(
                """
                {
                  "paycheckEmployers": [
                    {"id": "e1", "name": "Acme", "paycheckCount": 12, "createdAt": "2026-01-01T00:00:00Z"},
                    {"id": "e2", "name": "Globex", "paycheckCount": 3, "createdAt": "2026-02-01T00:00:00Z"}
                  ],
                  "paycheckEmployerCount": 2
                }
                """.trimIndent(),
            )
        val out = GetPaycheckEmployers.parseOutput(data)
        assertThat(out.employers).hasSize(2)
        assertThat(out.employers[0].name).isEqualTo("Acme")
        assertThat(out.employers[1].paycheckCount).isEqualTo(3)
        assertThat(out.totalCount).isEqualTo(2)
    }

    @Test
    fun `CreatePaycheck Input from request maps every field`() {
        val req =
            CreatePaycheckRequest(
                employerId = "emp-1",
                grossAmount = 5000.0,
                payDate = "2026-05-15",
                payPeriodStart = "2026-05-01",
                payPeriodEnd = "2026-05-15",
                payrollProvider = "gusto",
                ownerId = "u-1",
                deductions = listOf(PaycheckDeductionInput(deductionType = "federal_income_tax", amount = 800.0)),
                deposits = listOf(PaycheckDepositInput(transactionId = "txn-1")),
            )
        val input = CreatePaycheck.Input.from(req)
        assertThat(input.employerId).isEqualTo("emp-1")
        assertThat(input.deductions).hasSize(1)
        assertThat(input.deposits?.first()?.transactionId).isEqualTo("txn-1")
    }

    @Test
    fun `CreatePaycheck variables builds nested input map, omits absent optional fields`() {
        val input = CreatePaycheck.Input(employerId = "e1", grossAmount = 100.0, payDate = "2026-05-15")

        @Suppress("UNCHECKED_CAST")
        val vars = CreatePaycheck.variables(input)["input"] as Map<String, Any?>
        assertThat(vars).containsEntry("employerId", "e1")
        assertThat(vars).containsEntry("grossAmount", 100.0)
        assertThat(vars).containsEntry("payDate", "2026-05-15")
        assertThat(vars).doesNotContainKey("payrollProvider")
        assertThat(vars).doesNotContainKey("deductions")
    }

    @Test
    fun `CreatePaycheck variables forwards deductions and deposits as list of maps`() {
        val input =
            CreatePaycheck.Input(
                employerId = "e1",
                grossAmount = 100.0,
                payDate = "2026-05-15",
                deductions =
                    listOf(
                        PaycheckDeductionInput(deductionType = "custom", customDeductionName = "Gym", amount = 50.0),
                    ),
                deposits = listOf(PaycheckDepositInput(transactionId = "txn-1")),
            )

        @Suppress("UNCHECKED_CAST")
        val vars = CreatePaycheck.variables(input)["input"] as Map<String, Any?>

        @Suppress("UNCHECKED_CAST")
        val deductions = vars["deductions"] as List<Map<String, Any?>>
        assertThat(deductions).hasSize(1)
        assertThat(deductions[0]).containsEntry("deductionType", "custom")
        assertThat(deductions[0]).containsEntry("customDeductionName", "Gym")
        @Suppress("UNCHECKED_CAST")
        val deposits = vars["deposits"] as List<Map<String, Any?>>
        assertThat(deposits[0]).containsEntry("transactionId", "txn-1")
    }

    @Test
    fun `CreatePaycheck parseOutput pulls paycheck from nested mutation root`() {
        val data =
            jsonNode(
                """
                {"createPaycheck": {"paycheck":
                  {"id": "new-pc", "grossAmount": 100.0, "payDate": "2026-05-15",
                   "deductions": [], "deposits": []}
                }}
                """.trimIndent(),
            )
        val out = CreatePaycheck.parseOutput(data)
        assertThat(out.paycheck.id).isEqualTo("new-pc")
    }

    @Test
    fun `UpdatePaycheck variables sends id plus only the set fields`() {
        val req = UpdatePaycheckRequest(grossAmount = 6000.0, payDate = "2026-05-31")
        val input = UpdatePaycheck.Input.from("pc-1", req)

        @Suppress("UNCHECKED_CAST")
        val vars = UpdatePaycheck.variables(input)["input"] as Map<String, Any?>
        assertThat(vars).containsEntry("id", "pc-1")
        assertThat(vars).containsEntry("grossAmount", 6000.0)
        assertThat(vars).containsEntry("payDate", "2026-05-31")
        assertThat(vars).doesNotContainKey("employerId")
        assertThat(vars).doesNotContainKey("deductions")
    }

    @Test
    fun `UpdatePaycheck parseOutput pulls paycheck from updatePaycheck root`() {
        val data =
            jsonNode(
                """
                {"updatePaycheck": {"paycheck":
                  {"id": "pc-1", "grossAmount": 6000.0, "payDate": "2026-05-31",
                   "deductions": [], "deposits": []}
                }}
                """.trimIndent(),
            )
        val out = UpdatePaycheck.parseOutput(data)
        assertThat(out.paycheck.id).isEqualTo("pc-1")
        assertThat(out.paycheck.grossAmount).isEqualTo(6000.0)
    }

    @Test
    fun `DeletePaycheck variables nest id under input`() {
        @Suppress("UNCHECKED_CAST")
        val vars = DeletePaycheck.variables(DeletePaycheck.Input("pc-1"))["input"] as Map<String, Any?>
        assertThat(vars).containsEntry("id", "pc-1")
    }

    @Test
    fun `DeletePaycheck parseOutput surfaces success as deleted`() {
        assertThat(DeletePaycheck.parseOutput(jsonNode("""{"deletePaycheck": {"success": true}}""")).deleted).isTrue
        assertThat(DeletePaycheck.parseOutput(jsonNode("""{"deletePaycheck": {"success": false}}""")).deleted).isFalse
        assertThat(DeletePaycheck.parseOutput(jsonNode("""{"deletePaycheck": {}}""")).deleted).isFalse
    }

    @Test
    fun `CreatePaycheckEmployer variables nest name and parseOutput pulls employer`() {
        @Suppress("UNCHECKED_CAST")
        val vars = CreatePaycheckEmployer.variables(CreatePaycheckEmployer.Input("Acme"))["input"] as Map<String, Any?>
        assertThat(vars).containsEntry("name", "Acme")

        val out =
            CreatePaycheckEmployer.parseOutput(
                jsonNode(
                    """
                    {"createPaycheckEmployer": {"employer":
                      {"id": "e1", "name": "Acme", "paycheckCount": 0, "createdAt": "2026-05-01T00:00:00Z"}
                    }}
                    """.trimIndent(),
                ),
            )
        assertThat(out.employer.id).isEqualTo("e1")
        assertThat(out.employer.name).isEqualTo("Acme")
    }

    @Test
    fun `UpdatePaycheckEmployer variables send id plus name and parseOutput pulls employer`() {
        val input = UpdatePaycheckEmployer.Input.from("e1", UpdatePaycheckEmployerRequest(name = "Acme Corp"))

        @Suppress("UNCHECKED_CAST")
        val vars = UpdatePaycheckEmployer.variables(input)["input"] as Map<String, Any?>
        assertThat(vars).containsEntry("id", "e1")
        assertThat(vars).containsEntry("name", "Acme Corp")

        val out =
            UpdatePaycheckEmployer.parseOutput(
                jsonNode("""{"updatePaycheckEmployer": {"employer": {"id": "e1", "name": "Acme Corp"}}}"""),
            )
        assertThat(out.employer.name).isEqualTo("Acme Corp")
    }

    @Test
    fun `DeletePaycheckEmployer variables flat id and parseOutput surfaces success`() {
        assertThat(DeletePaycheckEmployer.variables(DeletePaycheckEmployer.Input("e1"))).containsEntry("id", "e1")
        assertThat(
            DeletePaycheckEmployer.parseOutput(jsonNode("""{"deletePaycheckEmployer": {"success": true}}""")).deleted,
        ).isTrue
    }

    // -- GetPaychecks variables ---------------------------------------------

    @Test
    fun `GetPaychecks variables pass through every filter`() {
        val vars =
            GetPaychecks.variables(
                GetPaychecks.Input(
                    startDate = "2026-01-01",
                    endDate = "2026-05-31",
                    ownerId = "u-1",
                    employerId = "e-1",
                ),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-01-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-31")
        assertThat(vars["ownerId"]).isEqualTo("u-1")
        assertThat(vars["employerId"]).isEqualTo("e-1")

        val empty = GetPaychecks.variables(GetPaychecks.Input())
        assertThat(empty["startDate"]).isNull()
        assertThat(empty["endDate"]).isNull()
        assertThat(empty["ownerId"]).isNull()
        assertThat(empty["employerId"]).isNull()
    }

    // -- GetPaycheck variables ----------------------------------------------

    @Test
    fun `GetPaycheck variables forward id at top level`() {
        val vars = GetPaycheck.variables(GetPaycheck.Input(id = "pc-9"))
        assertThat(vars["id"]).isEqualTo("pc-9")
    }

    // -- GetPaychecksSummary variables --------------------------------------

    @Test
    fun `GetPaychecksSummary variables pass through every aggregation filter`() {
        val vars =
            GetPaychecksSummary.variables(
                GetPaychecksSummary.Input(
                    startDate = "2026-01-01",
                    endDate = "2026-05-31",
                    ownerIds = listOf("u-1", "u-2"),
                    employerId = "e-1",
                ),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-01-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-31")
        assertThat(vars["ownerIds"]).isEqualTo(listOf("u-1", "u-2"))
        assertThat(vars["employerId"]).isEqualTo("e-1")

        val empty = GetPaychecksSummary.variables(GetPaychecksSummary.Input())
        assertThat(empty["startDate"]).isNull()
        assertThat(empty["ownerIds"]).isNull()
    }

    // -- GetPaycheckEmployers variables -------------------------------------

    @Test
    fun `GetPaycheckEmployers variables forward search and paging`() {
        val vars =
            GetPaycheckEmployers.variables(
                GetPaycheckEmployers.Input(search = "Acme", limit = 25, offset = 50),
            )
        assertThat(vars["search"]).isEqualTo("Acme")
        assertThat(vars["limit"]).isEqualTo(25)
        assertThat(vars["offset"]).isEqualTo(50)

        val empty = GetPaycheckEmployers.variables(GetPaycheckEmployers.Input())
        assertThat(empty["search"]).isNull()
        assertThat(empty["limit"]).isNull()
        assertThat(empty["offset"]).isNull()
    }
}
