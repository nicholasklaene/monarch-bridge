# CalendarEvent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | 
**type** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**reference_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.calendar_event import CalendarEvent

# TODO update the JSON string below
json = "{}"
# create an instance of CalendarEvent from a JSON string
calendar_event_instance = CalendarEvent.from_json(json)
# print the JSON string representation of the object
print(CalendarEvent.to_json())

# convert the object into a dict
calendar_event_dict = calendar_event_instance.to_dict()
# create an instance of CalendarEvent from a dict
calendar_event_from_dict = CalendarEvent.from_dict(calendar_event_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


