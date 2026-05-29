# GetPortfolioAllocationByHoldingsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**buckets** | [**List[PortfolioAllocationBucket]**](PortfolioAllocationBucket.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_portfolio_allocation_by_holdings_response_data import GetPortfolioAllocationByHoldingsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetPortfolioAllocationByHoldingsResponseData from a JSON string
get_portfolio_allocation_by_holdings_response_data_instance = GetPortfolioAllocationByHoldingsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetPortfolioAllocationByHoldingsResponseData.to_json())

# convert the object into a dict
get_portfolio_allocation_by_holdings_response_data_dict = get_portfolio_allocation_by_holdings_response_data_instance.to_dict()
# create an instance of GetPortfolioAllocationByHoldingsResponseData from a dict
get_portfolio_allocation_by_holdings_response_data_from_dict = GetPortfolioAllocationByHoldingsResponseData.from_dict(get_portfolio_allocation_by_holdings_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


