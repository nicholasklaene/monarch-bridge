package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetZestimateRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ZestimateOperationTest {
    @Test
    fun `parses zillow zestimate matches`() {
        val out =
            GetZestimate.parseOutput(
                jsonNode(
                    """
                    {"zestimates": [
                      {"zpid": "z1", "addressStreet": "1 Main St", "addressCity": "Seattle",
                       "addressStateAbbr": "WA", "addressPostalCode": "98101", "zestimate": 750000.5},
                      {"zpid": "z2", "addressStreet": null, "addressCity": null,
                       "addressStateAbbr": null, "addressPostalCode": null, "zestimate": null}
                    ]}
                    """.trimIndent(),
                ),
            )
        assertThat(out.zestimates).hasSize(2)
        assertThat(out.zestimates[0].zestimate).isEqualTo(750000.5)
        assertThat(out.zestimates[0].addressCity).isEqualTo("Seattle")
        assertThat(out.zestimates[1].zestimate).isNull()
    }

    @Test
    fun `empty zestimates array returns empty list`() {
        val out = GetZestimate.parseOutput(jsonNode("""{"zestimates": []}"""))
        assertThat(out.zestimates).isEmpty()
    }

    @Test
    fun `Input from request forwards address`() {
        val input = GetZestimate.Input.from(GetZestimateRequest(address = "1 Main St"))
        assertThat(input.address).isEqualTo("1 Main St")
        assertThat(GetZestimate.variables(input)).containsEntry("address", "1 Main St")
    }

    @Test
    fun `operation name`() {
        assertThat(GetZestimate.operationName).isEqualTo("Web_GetZestimate")
    }
}
