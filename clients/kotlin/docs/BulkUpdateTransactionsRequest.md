
# BulkUpdateTransactionsRequest

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **expectedAffectedTransactionCount** | **kotlin.Int** | Safety check. Monarch refuses if actual affected count differs. |  |
| **updates** | [**BulkTransactionUpdates**](BulkTransactionUpdates.md) |  |  |
| **selectedTransactionIds** | **kotlin.collections.List&lt;kotlin.String&gt;** | Ids to patch (explicit mode). Ignored when &#x60;allSelected: true&#x60;. |  [optional] |
| **excludedTransactionIds** | **kotlin.collections.List&lt;kotlin.String&gt;** | Ids to skip (filter mode). Ignored when &#x60;allSelected: false&#x60;. |  [optional] |
| **allSelected** | **kotlin.Boolean** | Switch between explicit (false) and filter (true) selection. |  [optional] |
| **filters** | [**BulkTransactionFilters**](BulkTransactionFilters.md) |  |  [optional] |



