# PortfolioAllocationHoldingsDetailResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetPortfolioAllocationHoldingsDetailResponseData**](GetPortfolioAllocationHoldingsDetailResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.portfolio_allocation_holdings_detail_response import PortfolioAllocationHoldingsDetailResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PortfolioAllocationHoldingsDetailResponse from a JSON string
portfolio_allocation_holdings_detail_response_instance = PortfolioAllocationHoldingsDetailResponse.from_json(json)
# print the JSON string representation of the object
print(PortfolioAllocationHoldingsDetailResponse.to_json())

# convert the object into a dict
portfolio_allocation_holdings_detail_response_dict = portfolio_allocation_holdings_detail_response_instance.to_dict()
# create an instance of PortfolioAllocationHoldingsDetailResponse from a dict
portfolio_allocation_holdings_detail_response_from_dict = PortfolioAllocationHoldingsDetailResponse.from_dict(portfolio_allocation_holdings_detail_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


