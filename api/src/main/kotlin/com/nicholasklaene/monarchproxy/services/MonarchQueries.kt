package com.nicholasklaene.monarchproxy.services

/**
 * GraphQL operation strings ported verbatim from upstream monarchmoneycommunity.
 *
 * Each const val concatenates the operation body with its required fragments at compile time.
 *
 * Source: bradleyseanf/monarchmoneycommunity@dev monarchmoney/monarchmoney.py
 * Upstream HEAD commit: befdadc7163f90053be5820346f3095b78c7a857
 * Ported on 2026-05-09
 */
@Suppress("MaxLineLength", "LargeClass")
object MonarchQueries {
    /**
     * GET_ACCOUNTS — fetches all linked accounts + household preferences.
     *
     * Upstream: get_accounts (line 188), operation: GetAccounts
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     */
    const val GET_ACCOUNTS =
        """
query GetAccounts {
  accounts {
    ...AccountFields
    __typename
  }
  householdPreferences {
    id
    accountGroupOrder
    __typename
  }
}
""" + MonarchFragments.ACCOUNT_FIELDS

    /**
     * GET_TRANSACTIONS — fetches paginated transactions with filters.
     *
     * Upstream: get_transactions (line 1480), operation: GetTransactionsList
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     */
    const val GET_TRANSACTIONS =
        """
query GetTransactionsList(${'$'}offset: Int, ${'$'}limit: Int, ${'$'}filters: TransactionFilterInput, ${'$'}orderBy: TransactionOrdering) {
  allTransactions(filters: ${'$'}filters) {
    totalCount
    results(offset: ${'$'}offset, limit: ${'$'}limit, orderBy: ${'$'}orderBy) {
      id
      ...TransactionOverviewFields
      __typename
    }
    __typename
  }
  transactionRules {
    id
    __typename
  }
}
""" + MonarchFragments.TRANSACTION_OVERVIEW_FIELDS

    /**
     * GET_ACCOUNT_HISTORY — fetches balance snapshots + account details for a single account.
     *
     * Upstream: get_account_history (line 860), operation: AccountDetails_getAccount
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     *
     * KNOWN DATA-COMPLETENESS GAP (Reviewer 2 — Stage 6 of plan):
     * Upstream's `AccountDetails_getAccount` embeds a SLIMMER `TransactionOverviewFields`
     * (different attachment shape, includes `dataProviderDescription` + `category.group`).
     * We currently reuse the fat `TRANSACTION_OVERVIEW_FIELDS` from `GET_TRANSACTIONS`.
     * The server tolerates the extra fields — no crashes — but `dataProviderDescription`
     * + `category.group` will not populate from this query. Defer to the
     * `monarch-fixture-capture` ticket: capture a real response, then split into a
     * `TRANSACTION_OVERVIEW_FIELDS_SLIM` fragment for this query.
     */
    const val GET_ACCOUNT_HISTORY =
        """
query AccountDetails_getAccount(${'$'}id: UUID!, ${'$'}filters: TransactionFilterInput) {
  account(id: ${'$'}id) {
    id
    ...AccountFields
    ...EditAccountFormFields
    isLiability
    credential {
      id
      hasSyncInProgress
      canBeForceRefreshed
      disconnectedFromDataProviderAt
      dataProvider
      institution {
        id
        plaidInstitutionId
        url
        ...InstitutionStatusFields
        __typename
      }
      __typename
    }
    institution {
      id
      plaidInstitutionId
      url
      ...InstitutionStatusFields
      __typename
    }
    __typename
  }
  transactions: allTransactions(filters: ${'$'}filters) {
    totalCount
    results(limit: 20) {
      id
      ...TransactionsListFields
      __typename
    }
    __typename
  }
  snapshots: snapshotsForAccount(accountId: ${'$'}id) {
    date
    signedBalance
    __typename
  }
}

fragment EditAccountFormFields on Account {
  id
  displayName
  deactivatedAt
  displayBalance
  includeInNetWorth
  hideFromList
  hideTransactionsFromReports
  dataProvider
  dataProviderAccountId
  isManual
  manualInvestmentsTrackingMethod
  isAsset
  invertSyncedBalance
  canInvertBalance
  type {
    name
    display
    __typename
  }
  subtype {
    name
    display
    __typename
  }
  __typename
}

fragment InstitutionStatusFields on Institution {
  id
  hasIssuesReported
  hasIssuesReportedMessage
  plaidStatus
  status
  balanceStatus
  transactionsStatus
  __typename
}

fragment TransactionsListFields on Transaction {
  id
  ...TransactionOverviewFields
  __typename
}
""" + MonarchFragments.ACCOUNT_FIELDS + MonarchFragments.TRANSACTION_OVERVIEW_FIELDS

    /**
     * GET_TRANSACTION_CATEGORIES — fetches all transaction categories.
     *
     * Upstream: get_transaction_categories (line 1713), operation: GetCategories
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     */
    const val GET_TRANSACTION_CATEGORIES =
        """
query GetCategories {
  categories {
    ...CategoryFields
    __typename
  }
}
""" + MonarchFragments.CATEGORY_FIELDS

    /**
     * GET_TRANSACTION_TAGS — fetches all household transaction tags.
     *
     * Upstream: get_transaction_tags (line 1947), operation: GetHouseholdTransactionTags
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     */
    const val GET_TRANSACTION_TAGS = """
query GetHouseholdTransactionTags(${'$'}search: String, ${'$'}limit: Int, ${'$'}bulkParams: BulkTransactionDataParams) {
  householdTransactionTags(
    search: ${'$'}search
    limit: ${'$'}limit
    bulkParams: ${'$'}bulkParams
  ) {
    id
    name
    color
    order
    transactionCount
    __typename
  }
}"""

    /**
     * GET_CASHFLOW_SUMMARY — fetches income/expense/savings aggregates for a date range.
     *
     * Upstream: get_cashflow_summary (line 2412), operation: Web_GetCashFlowPage
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     */
    const val GET_CASHFLOW_SUMMARY = """
query Web_GetCashFlowPage(${'$'}filters: TransactionFilterInput) {
  summary: aggregates(filters: ${'$'}filters, fillEmptyValues: true) {
    summary {
      sumIncome
      sumExpense
      savings
      savingsRate
      __typename
    }
    __typename
  }
}"""

    /**
     * REQUEST_ACCOUNTS_REFRESH — mutation that triggers Monarch to re-poll Plaid for all given accounts.
     *
     * Upstream: request_accounts_refresh (line 661), operation: Common_ForceRefreshAccountsMutation
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     */
    const val REQUEST_ACCOUNTS_REFRESH =
        """
mutation Common_ForceRefreshAccountsMutation(${'$'}input: ForceRefreshAccountsInput!) {
  forceRefreshAccounts(input: ${'$'}input) {
    success
    errors {
      ...PayloadErrorFields
      __typename
    }
    __typename
  }
}
""" + MonarchFragments.PAYLOAD_ERROR_FIELDS

    /**
     * GET_AGGREGATE_SNAPSHOTS — fetches net-worth-over-time across all accounts.
     *
     * Upstream: get_aggregate_snapshots, operation: GetAggregateSnapshots
     * Ported on 2026-05-25
     */
    const val GET_AGGREGATE_SNAPSHOTS = """
query GetAggregateSnapshots(${'$'}filters: AggregateSnapshotFilters) {
  aggregateSnapshots(filters: ${'$'}filters) {
    date
    balance
    __typename
  }
}"""

    /**
     * GET_RECENT_ACCOUNT_BALANCES — recent balance fluctuations per account.
     *
     * Upstream: get_recent_account_balances, operation: GetAccountRecentBalances
     * Ported on 2026-05-25
     */
    const val GET_RECENT_ACCOUNT_BALANCES = """
query GetAccountRecentBalances(${'$'}startDate: Date!) {
  accounts {
    id
    recentBalances(startDate: ${'$'}startDate)
    __typename
  }
}"""

    /**
     * GET_SNAPSHOTS_BY_ACCOUNT_TYPE — balance history grouped by account type + reference list.
     *
     * Upstream: get_account_snapshots_by_type, operation: GetSnapshotsByAccountType
     * Ported on 2026-05-25
     */
    const val GET_SNAPSHOTS_BY_ACCOUNT_TYPE = """
query GetSnapshotsByAccountType(${'$'}startDate: Date!, ${'$'}timeframe: Timeframe!) {
  snapshotsByAccountType(startDate: ${'$'}startDate, timeframe: ${'$'}timeframe) {
    accountType
    month
    balance
    __typename
  }
  accountTypes {
    name
    group
    __typename
  }
}"""

    /**
     * GET_HOLDINGS — investment positions for a single account (relay-paginated).
     *
     * Upstream: get_account_holdings, operation: Web_GetHoldings
     * Ported on 2026-05-25
     */
    const val GET_HOLDINGS = """
query Web_GetHoldings(${'$'}input: PortfolioInput) {
  portfolio(input: ${'$'}input) {
    aggregateHoldings {
      edges {
        node {
          id
          quantity
          basis
          totalValue
          securityPriceChangeDollars
          securityPriceChangePercent
          lastSyncedAt
          holdings {
            id
            type
            typeDisplay
            name
            ticker
            closingPrice
            isManual
            closingPriceUpdatedAt
            __typename
          }
          security {
            id
            name
            type
            ticker
            typeDisplay
            currentPrice
            currentPriceUpdatedAt
            closingPrice
            closingPriceUpdatedAt
            oneDayChangePercent
            oneDayChangeDollars
            __typename
          }
          __typename
        }
        __typename
      }
      __typename
    }
    __typename
  }
}"""
}
