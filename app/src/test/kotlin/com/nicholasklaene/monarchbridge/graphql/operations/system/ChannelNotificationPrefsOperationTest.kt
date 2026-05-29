package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.SetEmailNotificationPrefsRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChannelNotificationPrefsOperationTest {
    // -- GetEmailNotificationPrefs ----------------------------------------

    @Test
    fun `GetEmailNotificationPrefs parses every toggle`() {
        val data =
            jsonNode(
                """
                {"emailNotificationPreferences":{
                  "weeklyRecap":true,"budgetAlerts":false,"billReminders":true,
                  "goalUpdates":false,"marketingTips":true
                }}
                """.trimIndent(),
            )
        val out = GetEmailNotificationPrefs.parseOutput(data)
        assertThat(out.prefs.weeklyRecap).isTrue
        assertThat(out.prefs.budgetAlerts).isFalse
        assertThat(out.prefs.billReminders).isTrue
        assertThat(out.prefs.goalUpdates).isFalse
        assertThat(out.prefs.marketingTips).isTrue
    }

    @Test
    fun `GetEmailNotificationPrefs leaves every toggle null when never set`() {
        val out = GetEmailNotificationPrefs.parseOutput(jsonNode("""{"emailNotificationPreferences":{}}"""))
        assertThat(out.prefs.weeklyRecap).isNull()
        assertThat(out.prefs.budgetAlerts).isNull()
        assertThat(out.prefs.billReminders).isNull()
    }

    @Test
    fun `GetEmailNotificationPrefs variables are empty`() {
        assertThat(GetEmailNotificationPrefs.variables(Unit)).isEmpty()
    }

    // -- SetEmailNotificationPrefs ----------------------------------------

    @Test
    fun `SetEmailNotificationPrefs parses updated toggles from mutation envelope`() {
        val data =
            jsonNode(
                """
                {"setEmailNotificationPreferences":{"preferences":
                  {"weeklyRecap":false,"budgetAlerts":true,"billReminders":false,
                   "goalUpdates":true,"marketingTips":false}}}
                """.trimIndent(),
            )
        val out = SetEmailNotificationPrefs.parseOutput(data)
        assertThat(out.prefs.weeklyRecap).isFalse
        assertThat(out.prefs.budgetAlerts).isTrue
        assertThat(out.prefs.marketingTips).isFalse
    }

    @Test
    fun `SetEmailNotificationPrefs variables drop unset fields so PATCH stays sparse`() {
        val vars =
            SetEmailNotificationPrefs.variables(
                SetEmailNotificationPrefs.Input(weeklyRecap = true),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("weeklyRecap", true)
        assertThat(input).doesNotContainKeys("budgetAlerts", "billReminders", "goalUpdates", "marketingTips")
    }

    @Test
    fun `SetEmailNotificationPrefs variables include all flags when set`() {
        val vars =
            SetEmailNotificationPrefs.variables(
                SetEmailNotificationPrefs.Input(
                    weeklyRecap = true,
                    budgetAlerts = false,
                    billReminders = true,
                    goalUpdates = false,
                    marketingTips = true,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input)
            .containsEntry("weeklyRecap", true)
            .containsEntry("budgetAlerts", false)
            .containsEntry("billReminders", true)
            .containsEntry("goalUpdates", false)
            .containsEntry("marketingTips", true)
    }

    @Test
    fun `SetEmailNotificationPrefs Input from copies request fields`() {
        val input =
            SetEmailNotificationPrefs.Input.from(
                SetEmailNotificationPrefsRequest(weeklyRecap = true, marketingTips = false),
            )
        assertThat(input.weeklyRecap).isTrue
        assertThat(input.marketingTips).isFalse
        assertThat(input.budgetAlerts).isNull()
    }

    // -- GetPushNotificationPrefs -----------------------------------------

    @Test
    fun `GetPushNotificationPrefs parses every toggle`() {
        val data =
            jsonNode(
                """
                {"pushNotificationPreferences":{
                  "weeklyRecap":false,"budgetAlerts":true,"billReminders":false,
                  "goalUpdates":true,"marketingTips":false
                }}
                """.trimIndent(),
            )
        val out = GetPushNotificationPrefs.parseOutput(data)
        assertThat(out.prefs.weeklyRecap).isFalse
        assertThat(out.prefs.budgetAlerts).isTrue
        assertThat(out.prefs.goalUpdates).isTrue
    }

    @Test
    fun `GetPushNotificationPrefs tolerates missing payload`() {
        val out = GetPushNotificationPrefs.parseOutput(jsonNode("""{}"""))
        assertThat(out.prefs.weeklyRecap).isNull()
    }

    @Test
    fun `GetPushNotificationPrefs variables are empty`() {
        assertThat(GetPushNotificationPrefs.variables(Unit)).isEmpty()
    }

    // -- SetPushNotificationPrefs -----------------------------------------

    @Test
    fun `SetPushNotificationPrefs parses updated toggles from mutation envelope`() {
        val data =
            jsonNode(
                """
                {"setPushNotificationPreferences":{"preferences":
                  {"weeklyRecap":true,"budgetAlerts":false,"billReminders":true,
                   "goalUpdates":false,"marketingTips":true}}}
                """.trimIndent(),
            )
        val out = SetPushNotificationPrefs.parseOutput(data)
        assertThat(out.prefs.weeklyRecap).isTrue
        assertThat(out.prefs.budgetAlerts).isFalse
    }

    @Test
    fun `SetPushNotificationPrefs variables drop unset fields`() {
        val vars =
            SetPushNotificationPrefs.variables(SetPushNotificationPrefs.Input(billReminders = false))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("billReminders", false)
        assertThat(input).doesNotContainKeys("weeklyRecap", "budgetAlerts", "goalUpdates", "marketingTips")
    }

    @Test
    fun `SetPushNotificationPrefs Input from copies request fields`() {
        val input =
            SetPushNotificationPrefs.Input.from(
                SetEmailNotificationPrefsRequest(billReminders = false, goalUpdates = true),
            )
        assertThat(input.billReminders).isFalse
        assertThat(input.goalUpdates).isTrue
        assertThat(input.weeklyRecap).isNull()
    }
}
