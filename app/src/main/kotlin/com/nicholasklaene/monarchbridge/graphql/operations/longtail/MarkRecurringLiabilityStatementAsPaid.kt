package com.nicholasklaene.monarchbridge.graphql.operations.longtail

/**
 * Long-tail wrapper for the `Common_MarkRecurringLiabilityStatementAsPaid` GraphQL operation.
 *
 * Returns the raw upstream `data` payload as `Map<String, Any?>`. Variables passed
 * by the caller are forwarded verbatim. See [LongTailOperation] for shared plumbing.
 */
object MarkRecurringLiabilityStatementAsPaid : LongTailOperation("Common_MarkRecurringLiabilityStatementAsPaid")
