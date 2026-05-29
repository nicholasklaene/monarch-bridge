package com.nicholasklaene.monarchbridge.graphql.operations.longtail

/**
 * Long-tail wrapper for the `Common_LegacyGoalsMigrationQuery` GraphQL operation.
 *
 * Returns the raw upstream `data` payload as `Map<String, Any?>`. Variables passed
 * by the caller are forwarded verbatim. See [LongTailOperation] for shared plumbing.
 */
object LegacyGoalsMigrationQuery : LongTailOperation("Common_LegacyGoalsMigrationQuery")
