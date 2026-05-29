# PortfolioAllocationSimpleResponse

Shared shape for by-holding and by-account allocation queries.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetPortfolioAllocationByHoldingsResponseData**](GetPortfolioAllocationByHoldingsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.portfolio_allocation_simple_response import PortfolioAllocationSimpleResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PortfolioAllocationSimpleResponse from a JSON string
portfolio_allocation_simple_response_instance = PortfolioAllocationSimpleResponse.from_json(json)
# print the JSON string representation of the object
print(PortfolioAllocationSimpleResponse.to_json())

# convert the object into a dict
portfolio_allocation_simple_response_dict = portfolio_allocation_simple_response_instance.to_dict()
# create an instance of PortfolioAllocationSimpleResponse from a dict
portfolio_allocation_simple_response_from_dict = PortfolioAllocationSimpleResponse.from_dict(portfolio_allocation_simple_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


