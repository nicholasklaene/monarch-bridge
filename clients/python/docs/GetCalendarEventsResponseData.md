# GetCalendarEventsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**events** | [**List[CalendarEvent]**](CalendarEvent.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_calendar_events_response_data import GetCalendarEventsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCalendarEventsResponseData from a JSON string
get_calendar_events_response_data_instance = GetCalendarEventsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCalendarEventsResponseData.to_json())

# convert the object into a dict
get_calendar_events_response_data_dict = get_calendar_events_response_data_instance.to_dict()
# create an instance of GetCalendarEventsResponseData from a dict
get_calendar_events_response_data_from_dict = GetCalendarEventsResponseData.from_dict(get_calendar_events_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


