
# CreateManualTaxLotRequest

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **acquisitionDate** | [**java.time.LocalDate**](java.time.LocalDate.md) |  |  |
| **acquisitionQuantity** | **kotlin.Double** |  |  |
| **costBasisPerUnit** | **kotlin.Double** |  |  |
| **accountId** | **kotlin.String** | Optional override for the account id. If absent the bridge does not forward it (Monarch errors if missing, clients should normally pass it).  |  [optional] |



