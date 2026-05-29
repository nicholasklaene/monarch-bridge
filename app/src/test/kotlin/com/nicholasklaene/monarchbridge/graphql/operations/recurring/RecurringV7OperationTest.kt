package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkAsRecurringRequest
import com.nicholasklaene.monarchbridge.generated.model.MergeRecurringStreamsRequest
import com.nicholasklaene.monarchbridge.generated.model.SkipRecurringInstanceRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class RecurringV7OperationTest {
    // -- MergeRecurringStreams --------------------------------------------

    @Test
    fun `MergeRecurringStreams parses the surviving stream`() {
        val data =
            jsonNode("""{"mergeRecurringStreams":{"stream":{"id":"s1","name":"Netflix"}}}""")
        val out = MergeRecurringStreams.parseOutput(data)
        assertThat(out.stream.id).isEqualTo("s1")
        assertThat(out.stream.name).isEqualTo("Netflix")
    }

    @Test
    fun `MergeRecurringStreams handles surviving stream with no name`() {
        // Monarch sometimes returns the stream without a friendly name (just id).
        // We want a non-null id but null-safe name access.
        val data = jsonNode("""{"mergeRecurringStreams":{"stream":{"id":"s2"}}}""")
        val out = MergeRecurringStreams.parseOutput(data)
        assertThat(out.stream.id).isEqualTo("s2")
        assertThat(out.stream.name).isNull()
    }

    @Test
    fun `MergeRecurringStreams variables wrap required fields and only set newName when provided`() {
        val withName =
            MergeRecurringStreams.variables(
                MergeRecurringStreams.Input(
                    primaryStreamId = "s1",
                    mergedStreamIds = listOf("s2", "s3"),
                    newName = "Combined",
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val input = withName["input"] as Map<String, Any?>
        assertThat(input["primaryStreamId"]).isEqualTo("s1")
        assertThat(input["mergedStreamIds"]).isEqualTo(listOf("s2", "s3"))
        assertThat(input["newName"]).isEqualTo("Combined")

        // Required-only path: omit newName entirely (don't send "newName": null).
        val withoutName =
            MergeRecurringStreams.variables(
                MergeRecurringStreams.Input(primaryStreamId = "s1", mergedStreamIds = listOf("s2")),
            )

        @Suppress("UNCHECKED_CAST")
        val minInput = withoutName["input"] as Map<String, Any?>
        assertThat(minInput).containsEntry("primaryStreamId", "s1")
        assertThat(minInput).doesNotContainKey("newName")
    }

    @Test
    fun `MergeRecurringStreams Input from copies every request field`() {
        val req =
            MergeRecurringStreamsRequest(
                primaryStreamId = "p",
                mergedStreamIds = listOf("a", "b"),
                newName = "Merged",
            )
        val input = MergeRecurringStreams.Input.from(req)
        assertThat(input.primaryStreamId).isEqualTo("p")
        assertThat(input.mergedStreamIds).containsExactly("a", "b")
        assertThat(input.newName).isEqualTo("Merged")
    }

    // -- SkipRecurringInstance --------------------------------------------

    @Test
    fun `SkipRecurringInstance parses the skipped occurrence`() {
        val data =
            jsonNode("""{"skipRecurringInstance":{"instance":{"streamId":"s1","skippedDate":"2026-06-15"}}}""")
        val out = SkipRecurringInstance.parseOutput(data)
        assertThat(out.instance.streamId).isEqualTo("s1")
        assertThat(out.instance.skippedDate).isEqualTo("2026-06-15")
    }

    @Test
    fun `SkipRecurringInstance defaults streamId to empty and skippedDate to null when payload bare`() {
        val out = SkipRecurringInstance.parseOutput(jsonNode("""{"skipRecurringInstance":{"instance":{}}}"""))
        assertThat(out.instance.streamId).isEmpty()
        assertThat(out.instance.skippedDate).isNull()
    }

    @Test
    fun `SkipRecurringInstance variables stringify the LocalDate`() {
        val vars =
            SkipRecurringInstance.variables(
                SkipRecurringInstance.Input(streamId = "s1", skipDate = LocalDate.parse("2026-06-15")),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input["streamId"]).isEqualTo("s1")
        assertThat(input["skipDate"]).isEqualTo("2026-06-15")
    }

    @Test
    fun `SkipRecurringInstance Input from injects path streamId and copies body skipDate`() {
        val input =
            SkipRecurringInstance.Input.from(
                streamId = "s-7",
                req = SkipRecurringInstanceRequest(skipDate = LocalDate.parse("2026-07-01")),
            )
        assertThat(input.streamId).isEqualTo("s-7")
        assertThat(input.skipDate).isEqualTo(LocalDate.parse("2026-07-01"))
    }

    // -- MarkAsRecurring --------------------------------------------------

    @Test
    fun `MarkAsRecurring parses success flag and the new stream ref`() {
        val data =
            jsonNode("""{"markAsRecurring":{"success":true,"stream":{"id":"s-new","frequency":"monthly"}}}""")
        val out = MarkAsRecurring.parseOutput(data)
        assertThat(out.success).isTrue
        assertThat(out.stream.id).isEqualTo("s-new")
        // Name field carries frequency for this op (Monarch returns it as the discriminator).
        assertThat(out.stream.name).isEqualTo("monthly")
    }

    @Test
    fun `MarkAsRecurring defaults success false and empty id when payload bare`() {
        val out = MarkAsRecurring.parseOutput(jsonNode("""{"markAsRecurring":{}}"""))
        assertThat(out.success).isFalse
        assertThat(out.stream.id).isEmpty()
        assertThat(out.stream.name).isNull()
    }

    @Test
    fun `MarkAsRecurring variables wrap transactionId and frequency under input`() {
        val vars =
            MarkAsRecurring.variables(
                MarkAsRecurring.Input(transactionId = "t1", frequency = "monthly"),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input["transactionId"]).isEqualTo("t1")
        assertThat(input["frequency"]).isEqualTo("monthly")
    }

    @Test
    fun `MarkAsRecurring Input from extracts frequency enum value as wire string`() {
        val input =
            MarkAsRecurring.Input.from(
                transactionId = "t-7",
                req = MarkAsRecurringRequest(frequency = MarkAsRecurringRequest.Frequency.QUARTERLY),
            )
        assertThat(input.transactionId).isEqualTo("t-7")
        // The generated enum's `.value` is the Monarch wire format, not the enum name.
        assertThat(input.frequency).isEqualTo("quarterly")
    }
}
