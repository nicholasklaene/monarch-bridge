# GetPortfolioAllocationByHoldingsResponse

Shared shape for by-holding and by-account allocation queries.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetPortfolioAllocationByHoldingsResponseData**](GetPortfolioAllocationByHoldingsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_portfolio_allocation_by_holdings_response import GetPortfolioAllocationByHoldingsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetPortfolioAllocationByHoldingsResponse from a JSON string
get_portfolio_allocation_by_holdings_response_instance = GetPortfolioAllocationByHoldingsResponse.from_json(json)
# print the JSON string representation of the object
print(GetPortfolioAllocationByHoldingsResponse.to_json())

# convert the object into a dict
get_portfolio_allocation_by_holdings_response_dict = get_portfolio_allocation_by_holdings_response_instance.to_dict()
# create an instance of GetPortfolioAllocationByHoldingsResponse from a dict
get_portfolio_allocation_by_holdings_response_from_dict = GetPortfolioAllocationByHoldingsResponse.from_dict(get_portfolio_allocation_by_holdings_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


