
# Account

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.String** | Stable Monarch account id. |  |
| **displayName** | **kotlin.String** |  |  |
| **type** | **kotlin.String** | Top-level account type (e.g. &#x60;depository&#x60;, &#x60;brokerage&#x60;, &#x60;credit&#x60;). |  [optional] |
| **subtype** | **kotlin.String** | Subtype within the type (e.g. &#x60;savings&#x60;, &#x60;401k&#x60;). |  [optional] |
| **mask** | **kotlin.String** |  |  [optional] |
| **currentBalance** | **kotlin.Double** | Last-known balance in account currency. May be negative for credit/loan. |  [optional] |
| **displayBalance** | **kotlin.Double** |  |  [optional] |
| **isHidden** | **kotlin.Boolean** | Monarch&#39;s legacy hidden flag. |  [optional] |
| **hideFromList** | **kotlin.Boolean** | True if the user has hidden this account from the main list. |  [optional] |
| **includeInNetWorth** | **kotlin.Boolean** |  |  [optional] |
| **isAsset** | **kotlin.Boolean** |  |  [optional] |
| **isManual** | **kotlin.Boolean** | True for manually-created (non-Plaid) accounts. |  [optional] |
| **institution** | [**Institution**](Institution.md) |  |  [optional] |



