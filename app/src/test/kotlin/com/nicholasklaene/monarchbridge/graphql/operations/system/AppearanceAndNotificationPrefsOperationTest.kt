package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateAppearanceRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateNotificationPreferencesRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppearanceAndNotificationPrefsOperationTest {
    // -- GetAppearance ----------------------------------------------------

    @Test
    fun `GetAppearance parses theme, accentColor, compactMode`() {
        val data =
            jsonNode(
                """
                {
                  "appearance": {
                    "theme": "dark",
                    "accentColor": "#19D2A5",
                    "compactMode": true
                  }
                }
                """.trimIndent(),
            )
        val out = GetAppearance.parseOutput(data)
        assertThat(out.appearance.theme).isEqualTo("dark")
        assertThat(out.appearance.accentColor).isEqualTo("#19D2A5")
        assertThat(out.appearance.compactMode).isTrue
    }

    @Test
    fun `GetAppearance tolerates missing fields`() {
        val out = GetAppearance.parseOutput(jsonNode("""{}"""))
        assertThat(out.appearance.theme).isNull()
        assertThat(out.appearance.accentColor).isNull()
        assertThat(out.appearance.compactMode).isNull()
    }

    @Test
    fun `GetAppearance variables are empty`() {
        assertThat(GetAppearance.variables(Unit)).isEmpty()
    }

    // -- UpdateAppearance -------------------------------------------------

    @Test
    fun `UpdateAppearance parses appearance from mutation envelope`() {
        val data =
            jsonNode(
                """
                {
                  "updateAppearance": {
                    "appearance": {
                      "theme": "light",
                      "accentColor": "#FF00FF",
                      "compactMode": false
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateAppearance.parseOutput(data)
        assertThat(out.appearance.theme).isEqualTo("light")
        assertThat(out.appearance.accentColor).isEqualTo("#FF00FF")
        assertThat(out.appearance.compactMode).isFalse
    }

    @Test
    fun `UpdateAppearance tolerates empty mutation result`() {
        val out = UpdateAppearance.parseOutput(jsonNode("""{"updateAppearance": {}}"""))
        assertThat(out.appearance.theme).isNull()
    }

    @Test
    fun `UpdateAppearance variables omit null fields`() {
        val vars = UpdateAppearance.variables(UpdateAppearance.Input(theme = "dark"))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("theme", "dark")
        assertThat(input).doesNotContainKeys("accentColor", "compactMode")
    }

    @Test
    fun `UpdateAppearance variables include all fields when set`() {
        val vars =
            UpdateAppearance.variables(
                UpdateAppearance.Input(theme = "dark", accentColor = "#000", compactMode = true),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input["theme"]).isEqualTo("dark")
        assertThat(input["accentColor"]).isEqualTo("#000")
        assertThat(input["compactMode"]).isEqualTo(true)
    }

    @Test
    fun `UpdateAppearance Input from copies request fields`() {
        val input =
            UpdateAppearance.Input.from(
                UpdateAppearanceRequest(theme = "dark", accentColor = "#aaa", compactMode = false),
            )
        assertThat(input.theme).isEqualTo("dark")
        assertThat(input.accentColor).isEqualTo("#aaa")
        assertThat(input.compactMode).isFalse
    }

    // -- GetNotificationPreferences --------------------------------------

    @Test
    fun `GetNotificationPreferences parses preference list`() {
        val data =
            jsonNode(
                """
                {
                  "notificationPreferences": [
                    {
                      "id": "p-1",
                      "group": "transactions",
                      "type": "new_transaction",
                      "title": "New Transaction",
                      "description": "When a new transaction lands",
                      "emailEnabled": true,
                      "pushEnabled": false,
                      "inAppEnabled": true
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetNotificationPreferences.parseOutput(data)
        assertThat(out.preferences).hasSize(1)
        val p = out.preferences[0]
        assertThat(p.id).isEqualTo("p-1")
        assertThat(p.group).isEqualTo("transactions")
        assertThat(p.type).isEqualTo("new_transaction")
        assertThat(p.title).isEqualTo("New Transaction")
        assertThat(p.emailEnabled).isTrue
        assertThat(p.pushEnabled).isFalse
        assertThat(p.inAppEnabled).isTrue
    }

    @Test
    fun `GetNotificationPreferences returns empty list when missing`() {
        val out = GetNotificationPreferences.parseOutput(jsonNode("""{}"""))
        assertThat(out.preferences).isEmpty()
    }

    @Test
    fun `GetNotificationPreferences variables are empty`() {
        assertThat(GetNotificationPreferences.variables(Unit)).isEmpty()
    }

    // -- UpdateNotificationPreferences -----------------------------------

    @Test
    fun `UpdateNotificationPreferences parses preference from mutation envelope`() {
        val data =
            jsonNode(
                """
                {
                  "updateNotificationPreferences": {
                    "notificationPreference": {
                      "id": "p-1",
                      "group": "g",
                      "type": "t",
                      "emailEnabled": false,
                      "pushEnabled": true,
                      "inAppEnabled": true
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateNotificationPreferences.parseOutput(data)
        assertThat(out.preference.id).isEqualTo("p-1")
        assertThat(out.preference.group).isEqualTo("g")
        assertThat(out.preference.emailEnabled).isFalse
        assertThat(out.preference.pushEnabled).isTrue
    }

    @Test
    fun `UpdateNotificationPreferences tolerates empty mutation result`() {
        val out =
            UpdateNotificationPreferences.parseOutput(jsonNode("""{"updateNotificationPreferences": {}}"""))
        assertThat(out.preference.id).isEqualTo("")
    }

    @Test
    fun `UpdateNotificationPreferences variables include id and only set bool flags`() {
        val vars =
            UpdateNotificationPreferences.variables(
                UpdateNotificationPreferences.Input(id = "p-1", emailEnabled = true),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input["id"]).isEqualTo("p-1")
        assertThat(input["emailEnabled"]).isEqualTo(true)
        assertThat(input).doesNotContainKeys("pushEnabled", "inAppEnabled")
    }

    @Test
    fun `UpdateNotificationPreferences variables include all flags when set`() {
        val vars =
            UpdateNotificationPreferences.variables(
                UpdateNotificationPreferences.Input(id = "p-1", emailEnabled = true, pushEnabled = false, inAppEnabled = true),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input["pushEnabled"]).isEqualTo(false)
        assertThat(input["inAppEnabled"]).isEqualTo(true)
    }

    @Test
    fun `UpdateNotificationPreferences Input from copies request fields`() {
        val input =
            UpdateNotificationPreferences.Input.from(
                UpdateNotificationPreferencesRequest(
                    id = "p-1",
                    emailEnabled = false,
                    pushEnabled = true,
                    inAppEnabled = null,
                ),
            )
        assertThat(input.id).isEqualTo("p-1")
        assertThat(input.emailEnabled).isFalse
        assertThat(input.pushEnabled).isTrue
        assertThat(input.inAppEnabled).isNull()
    }
}
