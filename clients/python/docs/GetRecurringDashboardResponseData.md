# GetRecurringDashboardResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**remaining_due_amount** | **float** |  | [optional] 
**items** | [**List[DashboardRecurringItem]**](DashboardRecurringItem.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_recurring_dashboard_response_data import GetRecurringDashboardResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetRecurringDashboardResponseData from a JSON string
get_recurring_dashboard_response_data_instance = GetRecurringDashboardResponseData.from_json(json)
# print the JSON string representation of the object
print(GetRecurringDashboardResponseData.to_json())

# convert the object into a dict
get_recurring_dashboard_response_data_dict = get_recurring_dashboard_response_data_instance.to_dict()
# create an instance of GetRecurringDashboardResponseData from a dict
get_recurring_dashboard_response_data_from_dict = GetRecurringDashboardResponseData.from_dict(get_recurring_dashboard_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


