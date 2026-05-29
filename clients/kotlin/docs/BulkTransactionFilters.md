
# BulkTransactionFilters

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **startDate** | [**java.time.LocalDate**](java.time.LocalDate.md) |  |  [optional] |
| **endDate** | [**java.time.LocalDate**](java.time.LocalDate.md) |  |  [optional] |
| **search** | **kotlin.String** |  |  [optional] |
| **categories** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **accounts** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **tags** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **hasAttachments** | **kotlin.Boolean** |  |  [optional] |
| **hasNotes** | **kotlin.Boolean** |  |  [optional] |
| **hideFromReports** | **kotlin.Boolean** |  |  [optional] |
| **isSplit** | **kotlin.Boolean** |  |  [optional] |
| **isRecurring** | **kotlin.Boolean** |  |  [optional] |
| **importedFromMint** | **kotlin.Boolean** |  |  [optional] |
| **syncedFromInstitution** | **kotlin.Boolean** |  |  [optional] |
| **needsReview** | **kotlin.Boolean** |  |  [optional] |
| **transactionVisibility** | [**inline**](#TransactionVisibility) |  |  [optional] |


<a id="TransactionVisibility"></a>
## Enum: transactionVisibility
| Name | Value |
| ---- | ----- |
| transactionVisibility | hidden_transactions_only, all_transactions |



