
# CreateCategoryGroupRequest

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **name** | **kotlin.String** |  |  |
| **type** | **kotlin.String** | One of &#x60;income&#x60;, &#x60;expense&#x60;, &#x60;transfer&#x60;. |  |
| **color** | **kotlin.String** | Display color hex (with or without leading &#x60;#&#x60;). |  [optional] |
| **icon** | **kotlin.String** |  |  [optional] |
| **budgetVariability** | **kotlin.String** | One of &#x60;fixed&#x60;, &#x60;flexible&#x60;, &#x60;non_monthly&#x60;. |  [optional] |
| **groupLevelBudgetingEnabled** | **kotlin.Boolean** |  |  [optional] |
| **orderBefore** | **kotlin.String** | UUID of an existing group; the new group is inserted before it. Omit to append at the end. |  [optional] |
| **rolloverEnabled** | **kotlin.Boolean** |  |  [optional] |
| **rolloverType** | **kotlin.String** |  |  [optional] |
| **rolloverStartMonth** | **kotlin.String** | ISO date &#x60;YYYY-MM-DD&#x60; of the first month in the initial rollover window. |  [optional] |
| **rolloverStartingBalance** | **kotlin.Double** |  |  [optional] |



