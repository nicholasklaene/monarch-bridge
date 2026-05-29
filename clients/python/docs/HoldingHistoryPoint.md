# HoldingHistoryPoint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | 
**quantity** | **float** |  | [optional] 
**value** | **float** |  | [optional] 
**price** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.holding_history_point import HoldingHistoryPoint

# TODO update the JSON string below
json = "{}"
# create an instance of HoldingHistoryPoint from a JSON string
holding_history_point_instance = HoldingHistoryPoint.from_json(json)
# print the JSON string representation of the object
print(HoldingHistoryPoint.to_json())

# convert the object into a dict
holding_history_point_dict = holding_history_point_instance.to_dict()
# create an instance of HoldingHistoryPoint from a dict
holding_history_point_from_dict = HoldingHistoryPoint.from_dict(holding_history_point_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


