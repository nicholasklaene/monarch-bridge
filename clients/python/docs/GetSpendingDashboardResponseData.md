# GetSpendingDashboardResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dashboard** | [**SpendingDashboard**](SpendingDashboard.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_spending_dashboard_response_data import GetSpendingDashboardResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetSpendingDashboardResponseData from a JSON string
get_spending_dashboard_response_data_instance = GetSpendingDashboardResponseData.from_json(json)
# print the JSON string representation of the object
print(GetSpendingDashboardResponseData.to_json())

# convert the object into a dict
get_spending_dashboard_response_data_dict = get_spending_dashboard_response_data_instance.to_dict()
# create an instance of GetSpendingDashboardResponseData from a dict
get_spending_dashboard_response_data_from_dict = GetSpendingDashboardResponseData.from_dict(get_spending_dashboard_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


