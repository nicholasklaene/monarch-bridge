# PortfolioAllocationHolding


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**holding_ids** | **List[str]** |  | [optional] 
**security_name** | **str** |  | 
**ticker** | **str** |  | [optional] 
**security_type** | **str** |  | [optional] 
**security_type_display** | **str** |  | [optional] 
**quantity** | **float** |  | [optional] 
**value** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.portfolio_allocation_holding import PortfolioAllocationHolding

# TODO update the JSON string below
json = "{}"
# create an instance of PortfolioAllocationHolding from a JSON string
portfolio_allocation_holding_instance = PortfolioAllocationHolding.from_json(json)
# print the JSON string representation of the object
print(PortfolioAllocationHolding.to_json())

# convert the object into a dict
portfolio_allocation_holding_dict = portfolio_allocation_holding_instance.to_dict()
# create an instance of PortfolioAllocationHolding from a dict
portfolio_allocation_holding_from_dict = PortfolioAllocationHolding.from_dict(portfolio_allocation_holding_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


