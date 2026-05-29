# PortfolioAllocationResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetPortfolioAllocationResponseData**](GetPortfolioAllocationResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.portfolio_allocation_response import PortfolioAllocationResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PortfolioAllocationResponse from a JSON string
portfolio_allocation_response_instance = PortfolioAllocationResponse.from_json(json)
# print the JSON string representation of the object
print(PortfolioAllocationResponse.to_json())

# convert the object into a dict
portfolio_allocation_response_dict = portfolio_allocation_response_instance.to_dict()
# create an instance of PortfolioAllocationResponse from a dict
portfolio_allocation_response_from_dict = PortfolioAllocationResponse.from_dict(portfolio_allocation_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


