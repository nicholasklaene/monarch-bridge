
# Goal

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.String** |  |  |
| **name** | **kotlin.String** |  |  |
| **type** | **kotlin.String** | One of &#x60;savings&#x60;, &#x60;debt&#x60;. |  [optional] |
| **status** | **kotlin.String** | Lifecycle status (&#x60;active&#x60;, &#x60;complete&#x60;, &#x60;archived&#x60;, etc.). |  [optional] |
| **progress** | **kotlin.Double** | 0.0 → 1.0 fraction of &#x60;targetAmount&#x60; reached. |  [optional] |
| **currentBalance** | **kotlin.Double** |  |  [optional] |
| **targetAmount** | **kotlin.Double** |  |  [optional] |
| **targetDate** | **kotlin.String** | ISO date the user is aiming for (&#x60;YYYY-MM-DD&#x60;); nullable for open-ended goals. |  [optional] |
| **archivedAt** | **kotlin.String** | ISO timestamp the goal was archived; null for active goals. |  [optional] |
| **createdAt** | **kotlin.String** |  |  [optional] |
| **priority** | **kotlin.Int** | User-set ordering (lower &#x3D; higher priority). |  [optional] |
| **isSinkingFund** | **kotlin.Boolean** |  |  [optional] |
| **plannedMonthlyContribution** | **kotlin.Double** |  |  [optional] |
| **estimatedMonthsUntilCompletion** | **kotlin.Int** |  |  [optional] |
| **forecastedCompletionDate** | **kotlin.String** |  |  [optional] |
| **imageStorageProvider** | **kotlin.String** |  |  [optional] |
| **imageStorageProviderId** | **kotlin.String** |  |  [optional] |



