# GetSpendingDashboardResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSpendingDashboardResponseData**](GetSpendingDashboardResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_spending_dashboard_response import GetSpendingDashboardResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSpendingDashboardResponse from a JSON string
get_spending_dashboard_response_instance = GetSpendingDashboardResponse.from_json(json)
# print the JSON string representation of the object
print(GetSpendingDashboardResponse.to_json())

# convert the object into a dict
get_spending_dashboard_response_dict = get_spending_dashboard_response_instance.to_dict()
# create an instance of GetSpendingDashboardResponse from a dict
get_spending_dashboard_response_from_dict = GetSpendingDashboardResponse.from_dict(get_spending_dashboard_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


