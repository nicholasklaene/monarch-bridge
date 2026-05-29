# SpendingDashboard


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total_spend** | **float** |  | [optional] 
**budget_remaining** | **float** |  | [optional] 
**top_categories** | [**List[SpendingDashboardCategory]**](SpendingDashboardCategory.md) |  | 

## Example

```python
from monarch_bridge_client.models.spending_dashboard import SpendingDashboard

# TODO update the JSON string below
json = "{}"
# create an instance of SpendingDashboard from a JSON string
spending_dashboard_instance = SpendingDashboard.from_json(json)
# print the JSON string representation of the object
print(SpendingDashboard.to_json())

# convert the object into a dict
spending_dashboard_dict = spending_dashboard_instance.to_dict()
# create an instance of SpendingDashboard from a dict
spending_dashboard_from_dict = SpendingDashboard.from_dict(spending_dashboard_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


