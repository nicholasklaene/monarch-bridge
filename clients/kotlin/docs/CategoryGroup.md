
# CategoryGroup

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.String** |  |  |
| **name** | **kotlin.String** |  |  |
| **order** | **kotlin.Int** |  |  [optional] |
| **type** | **kotlin.String** | One of &#x60;income&#x60;, &#x60;expense&#x60;, &#x60;transfer&#x60;. |  [optional] |
| **updatedAt** | **kotlin.String** |  |  [optional] |
| **createdAt** | **kotlin.String** |  |  [optional] |
| **color** | **kotlin.String** | Display color hex (sent by &#x60;CategoryGroupFields&#x60;). |  [optional] |
| **groupLevelBudgetingEnabled** | **kotlin.Boolean** | True when the user budgets at group level rather than per-category. |  [optional] |
| **budgetVariability** | **kotlin.String** | One of &#x60;fixed&#x60;, &#x60;flexible&#x60;, &#x60;non_monthly&#x60;. Drives fixed-vs-flex bucket classification. |  [optional] |
| **rolloverPeriod** | [**CategoryGroupRolloverPeriod**](CategoryGroupRolloverPeriod.md) |  |  [optional] |



