# GetCalendarEventsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCalendarEventsResponseData**](GetCalendarEventsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_calendar_events_response import GetCalendarEventsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCalendarEventsResponse from a JSON string
get_calendar_events_response_instance = GetCalendarEventsResponse.from_json(json)
# print the JSON string representation of the object
print(GetCalendarEventsResponse.to_json())

# convert the object into a dict
get_calendar_events_response_dict = get_calendar_events_response_instance.to_dict()
# create an instance of GetCalendarEventsResponse from a dict
get_calendar_events_response_from_dict = GetCalendarEventsResponse.from_dict(get_calendar_events_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


