package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NotificationsOperationTest {
    @Test
    fun `GetNotifications parses pageInfo and edges`() {
        val out =
            GetNotifications.parseOutput(
                jsonNode(
                    """
                    {"activityEvents": {
                      "pageInfo": {"hasNextPage": true, "endCursor": "abc"},
                      "edges": [
                        {"node": {"id": "n-1", "createdAt": "2026-05-26T00:00:00Z",
                                   "readAt": null, "title": "Hello", "body": "Body",
                                   "action": "open", "actionLabel": "Open",
                                   "eventPriority": "high", "isPinned": false,
                                   "logo": "u", "dismissedAt": null,
                                   "eventType": "system", "secondaryUrl": null}},
                        {"node": {"id": "n-2"}}
                      ]
                    }}
                    """.trimIndent(),
                ),
            )
        assertThat(out.hasNextPage).isTrue()
        assertThat(out.endCursor).isEqualTo("abc")
        assertThat(out.edges).hasSize(2)
        assertThat(out.edges[0].title).isEqualTo("Hello")
        assertThat(out.edges[1].id).isEqualTo("n-2")
        assertThat(out.edges[1].title).isNull()
    }

    @Test
    fun `GetNotifications variables map`() {
        val vars = GetNotifications.variables(GetNotifications.Input(first = 20, afterCursor = "c"))
        assertThat(vars).containsEntry("first", 20).containsEntry("afterCursor", "c")
    }

    @Test
    fun `MarkNotificationAsRead parses node`() {
        val out =
            MarkNotificationAsRead.parseOutput(
                jsonNode("""{"markActivityAsRead": {"node": {"id": "n-1", "readAt": "2026-05-26T00:00:00Z"}}}"""),
            )
        assertThat(out.id).isEqualTo("n-1")
        assertThat(out.readAt).isEqualTo("2026-05-26T00:00:00Z")
    }

    @Test
    fun `DismissNotification parses node`() {
        val out =
            DismissNotification.parseOutput(
                jsonNode("""{"dismissActivity": {"node": {"id": "n-1", "dismissedAt": "2026-05-26T00:00:00Z"}}}"""),
            )
        assertThat(out.id).isEqualTo("n-1")
        assertThat(out.dismissedAt).isEqualTo("2026-05-26T00:00:00Z")
    }

    @Test
    fun `MarkAllNotificationsAsRead parses echoed edges`() {
        val out =
            MarkAllNotificationsAsRead.parseOutput(
                jsonNode(
                    """
                    {"markAllActivityAsRead": {"activityEvents": {"edges": [
                      {"node": {"id": "n-1", "readAt": "x"}},
                      {"node": {"id": "n-2", "readAt": "y"}}
                    ]}}}
                    """.trimIndent(),
                ),
            )
        assertThat(out.edges).hasSize(2)
        assertThat(out.edges[0].id).isEqualTo("n-1")
    }

    @Test
    fun `ClearAllNotifications returns success boolean`() {
        val out = ClearAllNotifications.parseOutput(jsonNode("""{"clearAllActivities": {"success": true}}"""))
        assertThat(out.success).isTrue()
    }

    @Test
    fun `operation names match`() {
        assertThat(GetNotifications.operationName).isEqualTo("Common_GetNotificationCenter")
        assertThat(MarkNotificationAsRead.operationName).isEqualTo("Common_MarkActivityAsRead")
        assertThat(DismissNotification.operationName).isEqualTo("Common_DismissActivity")
        assertThat(MarkAllNotificationsAsRead.operationName).isEqualTo("Common_MarkAllActivityAsRead")
        assertThat(ClearAllNotifications.operationName).isEqualTo("Common_ClearAllActivities")
    }
}
