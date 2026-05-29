# CostBasisLot


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**acquisition_date** | **date** |  | [optional] 
**quantity** | **float** |  | [optional] 
**cost_basis** | **float** |  | [optional] 
**current_value** | **float** |  | [optional] 
**unrealized_gain** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cost_basis_lot import CostBasisLot

# TODO update the JSON string below
json = "{}"
# create an instance of CostBasisLot from a JSON string
cost_basis_lot_instance = CostBasisLot.from_json(json)
# print the JSON string representation of the object
print(CostBasisLot.to_json())

# convert the object into a dict
cost_basis_lot_dict = cost_basis_lot_instance.to_dict()
# create an instance of CostBasisLot from a dict
cost_basis_lot_from_dict = CostBasisLot.from_dict(cost_basis_lot_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


