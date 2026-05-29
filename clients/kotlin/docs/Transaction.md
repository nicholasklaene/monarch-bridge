
# Transaction

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.String** |  |  |
| **date** | [**java.time.LocalDate**](java.time.LocalDate.md) |  |  |
| **amount** | **kotlin.Double** | Signed. Negative &#x3D; expense, positive &#x3D; income. |  |
| **pending** | **kotlin.Boolean** |  |  [optional] |
| **plaidName** | **kotlin.String** |  |  [optional] |
| **notes** | **kotlin.String** |  |  [optional] |
| **hideFromReports** | **kotlin.Boolean** |  |  [optional] |
| **needsReview** | **kotlin.Boolean** |  |  [optional] |
| **isRecurring** | **kotlin.Boolean** |  |  [optional] |
| **isSplitTransaction** | **kotlin.Boolean** |  |  [optional] |
| **createdAt** | **kotlin.String** |  |  [optional] |
| **updatedAt** | **kotlin.String** |  |  [optional] |
| **account** | [**TransactionAccountRef**](TransactionAccountRef.md) |  |  [optional] |
| **merchant** | [**MerchantRef**](MerchantRef.md) |  |  [optional] |
| **category** | [**Ref**](Ref.md) |  |  [optional] |
| **tags** | [**kotlin.collections.List&lt;TagRef&gt;**](TagRef.md) |  |  [optional] |



