# Security

A row from Monarch's security catalog. `currentPrice` and friends may be null for thinly-traded or manual securities.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**ticker** | **str** |  | [optional] 
**type** | **str** |  | [optional] 
**type_display** | **str** |  | [optional] 
**logo** | **str** |  | [optional] 
**current_price** | **float** |  | [optional] 
**closing_price** | **float** |  | [optional] 
**one_day_change_dollars** | **float** |  | [optional] 
**one_day_change_percent** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.security import Security

# TODO update the JSON string below
json = "{}"
# create an instance of Security from a JSON string
security_instance = Security.from_json(json)
# print the JSON string representation of the object
print(Security.to_json())

# convert the object into a dict
security_dict = security_instance.to_dict()
# create an instance of Security from a dict
security_from_dict = Security.from_dict(security_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


