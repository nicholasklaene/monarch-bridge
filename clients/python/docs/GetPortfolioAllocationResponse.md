# GetPortfolioAllocationResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetPortfolioAllocationResponseData**](GetPortfolioAllocationResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_portfolio_allocation_response import GetPortfolioAllocationResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetPortfolioAllocationResponse from a JSON string
get_portfolio_allocation_response_instance = GetPortfolioAllocationResponse.from_json(json)
# print the JSON string representation of the object
print(GetPortfolioAllocationResponse.to_json())

# convert the object into a dict
get_portfolio_allocation_response_dict = get_portfolio_allocation_response_instance.to_dict()
# create an instance of GetPortfolioAllocationResponse from a dict
get_portfolio_allocation_response_from_dict = GetPortfolioAllocationResponse.from_dict(get_portfolio_allocation_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


