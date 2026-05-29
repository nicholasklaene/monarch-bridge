# GetPortfolioAllocationHoldingsDetailResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**holdings** | [**List[PortfolioAllocationHolding]**](PortfolioAllocationHolding.md) |  | 
**total_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_portfolio_allocation_holdings_detail_response_data import GetPortfolioAllocationHoldingsDetailResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetPortfolioAllocationHoldingsDetailResponseData from a JSON string
get_portfolio_allocation_holdings_detail_response_data_instance = GetPortfolioAllocationHoldingsDetailResponseData.from_json(json)
# print the JSON string representation of the object
print(GetPortfolioAllocationHoldingsDetailResponseData.to_json())

# convert the object into a dict
get_portfolio_allocation_holdings_detail_response_data_dict = get_portfolio_allocation_holdings_detail_response_data_instance.to_dict()
# create an instance of GetPortfolioAllocationHoldingsDetailResponseData from a dict
get_portfolio_allocation_holdings_detail_response_data_from_dict = GetPortfolioAllocationHoldingsDetailResponseData.from_dict(get_portfolio_allocation_holdings_detail_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


