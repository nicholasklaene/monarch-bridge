
# CreateManualInvestmentsAccountRequest

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **name** | **kotlin.String** |  |  |
| **subtype** | **kotlin.String** | Account subtype string (e.g. &#x60;401k&#x60;, &#x60;ira&#x60;, &#x60;brokerage&#x60;). |  |
| **trackingMethod** | **kotlin.String** | One of &#x60;balances&#x60;, &#x60;holdings&#x60;. Maps to Monarch&#39;s &#x60;manualInvestmentsTrackingMethod&#x60;. |  [optional] |
| **initialBalance** | **kotlin.Double** | Seed balance for balance-tracked accounts. |  [optional] |
| **initialHoldings** | [**kotlin.collections.List&lt;InitialHoldingInput&gt;**](InitialHoldingInput.md) | Seed holdings for holdings-tracked accounts. |  [optional] |



