package com.nicholasklaene.monarchproxy.services

/**
 * GraphQL fragments ported verbatim from upstream monarchmoneycommunity.
 *
 * Source: bradleyseanf/monarchmoneycommunity@dev monarchmoney/monarchmoney.py
 * Upstream HEAD commit: befdadc7163f90053be5820346f3095b78c7a857
 * Ported on 2026-05-09
 */
object MonarchFragments {
    /**
     * AccountFields fragment.
     *
     * Upstream: get_accounts (line 200), get_account_history (line 906)
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     */
    const val ACCOUNT_FIELDS = """
fragment AccountFields on Account {
  id
  displayName
  syncDisabled
  deactivatedAt
  isHidden
  isAsset
  mask
  createdAt
  updatedAt
  displayLastUpdatedAt
  currentBalance
  displayBalance
  includeInNetWorth
  hideFromList
  hideTransactionsFromReports
  includeBalanceInNetWorth
  includeInGoalBalance
  dataProvider
  dataProviderAccountId
  isManual
  transactionsCount
  holdingsCount
  manualInvestmentsTrackingMethod
  order
  logoUrl
  type {
    name
    display
    group
    __typename
  }
  subtype {
    name
    display
    __typename
  }
  credential {
    id
    updateRequired
    disconnectedFromDataProviderAt
    dataProvider
    institution {
      id
      plaidInstitutionId
      name
      status
      __typename
    }
    __typename
  }
  institution {
    id
    name
    primaryColor
    url
    __typename
  }
  __typename
}"""

    /**
     * TransactionOverviewFields fragment.
     *
     * Upstream: get_transactions (line 1496), get_account_history (line 1012)
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     *
     * Note: get_transactions uses an extended form with additional fields
     * (extension, filename, originalAssetUrl, publicId, sizeBytes on attachments;
     * account, createdAt, updatedAt fields).
     * This fragment uses the richer get_transactions form.
     */
    const val TRANSACTION_OVERVIEW_FIELDS = """
fragment TransactionOverviewFields on Transaction {
  id
  amount
  pending
  date
  hideFromReports
  plaidName
  notes
  isRecurring
  reviewStatus
  needsReview
  attachments {
    id
    extension
    filename
    originalAssetUrl
    publicId
    sizeBytes
    __typename
  }
  isSplitTransaction
  createdAt
  updatedAt
  category {
    id
    name
    __typename
  }
  merchant {
    name
    id
    transactionsCount
    __typename
  }
  account {
    id
    displayName
    __typename
  }
  tags {
    id
    name
    color
    order
    __typename
  }
  __typename
}"""

    /**
     * CategoryFields fragment.
     *
     * Upstream: get_transaction_categories (line 1720)
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     */
    const val CATEGORY_FIELDS = """
fragment CategoryFields on Category {
  id
  order
  name
  systemCategory
  isSystemCategory
  isDisabled
  updatedAt
  createdAt
  group {
    id
    name
    type
    __typename
  }
  __typename
}"""

    /**
     * PayloadErrorFields fragment.
     *
     * Upstream: request_accounts_refresh (line 672), create_transaction, delete_transaction_category, etc.
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     */
    const val PAYLOAD_ERROR_FIELDS = """
fragment PayloadErrorFields on PayloadError {
  fieldErrors {
    field
    messages
    __typename
  }
  message
  code
  __typename
}"""

    /**
     * InstitutionInfoFields fragment.
     *
     * Upstream: Web_GetInstitutionSettings (line 1125)
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     *
     * Depends on InstitutionLogoWithStatusFields (inline-expanded in GET_ACCOUNT_HISTORY query).
     */
    const val INSTITUTION_INFO_FIELDS = """
fragment InstitutionInfoFields on Credential {
  id
  displayLastUpdatedAt
  dataProvider
  updateRequired
  disconnectedFromDataProviderAt
  ...InstitutionLogoWithStatusFields
  institution {
    id
    name
    hasIssuesReported
    hasIssuesReportedMessage
    __typename
  }
  __typename
}"""

    /**
     * InstitutionLogoWithStatusFields fragment — dependency of INSTITUTION_INFO_FIELDS.
     *
     * Upstream: Web_GetInstitutionSettings (line 1142)
     * Commit: befdadc7163f90053be5820346f3095b78c7a857
     * Ported on 2026-05-09
     */
    const val INSTITUTION_LOGO_WITH_STATUS_FIELDS = """
fragment InstitutionLogoWithStatusFields on Credential {
  dataProvider
  updateRequired
  institution {
    hasIssuesReported
    status
    balanceStatus
    transactionsStatus
    __typename
  }
  __typename
}"""
}
