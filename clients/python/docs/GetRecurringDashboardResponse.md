# GetRecurringDashboardResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetRecurringDashboardResponseData**](GetRecurringDashboardResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_recurring_dashboard_response import GetRecurringDashboardResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetRecurringDashboardResponse from a JSON string
get_recurring_dashboard_response_instance = GetRecurringDashboardResponse.from_json(json)
# print the JSON string representation of the object
print(GetRecurringDashboardResponse.to_json())

# convert the object into a dict
get_recurring_dashboard_response_dict = get_recurring_dashboard_response_instance.to_dict()
# create an instance of GetRecurringDashboardResponse from a dict
get_recurring_dashboard_response_from_dict = GetRecurringDashboardResponse.from_dict(get_recurring_dashboard_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


