# Holding

An investment position aggregated across one or more accounts.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**ticker** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**type** | **str** |  | [optional] 
**total_value** | **float** |  | [optional] 
**total_quantity** | **float** |  | [optional] 
**cost_basis** | **float** |  | [optional] 
**last_price** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.holding import Holding

# TODO update the JSON string below
json = "{}"
# create an instance of Holding from a JSON string
holding_instance = Holding.from_json(json)
# print the JSON string representation of the object
print(Holding.to_json())

# convert the object into a dict
holding_dict = holding_instance.to_dict()
# create an instance of Holding from a dict
holding_from_dict = Holding.from_dict(holding_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


