# WeeklyRecap

One auto-generated weekly recap.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**date_range_start** | **date** |  | 
**date_range_end** | **date** |  | 
**summary** | **str** |  | [optional] 
**sentiment** | **str** |  | [optional] 
**created_at** | **str** |  | [optional] 
**updated_at** | **str** |  | [optional] 
**cards** | [**List[WeeklyRecapCard]**](WeeklyRecapCard.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.weekly_recap import WeeklyRecap

# TODO update the JSON string below
json = "{}"
# create an instance of WeeklyRecap from a JSON string
weekly_recap_instance = WeeklyRecap.from_json(json)
# print the JSON string representation of the object
print(WeeklyRecap.to_json())

# convert the object into a dict
weekly_recap_dict = weekly_recap_instance.to_dict()
# create an instance of WeeklyRecap from a dict
weekly_recap_from_dict = WeeklyRecap.from_dict(weekly_recap_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


