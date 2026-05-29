# SpendingDashboardCategory


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_id** | **str** |  | 
**name** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.spending_dashboard_category import SpendingDashboardCategory

# TODO update the JSON string below
json = "{}"
# create an instance of SpendingDashboardCategory from a JSON string
spending_dashboard_category_instance = SpendingDashboardCategory.from_json(json)
# print the JSON string representation of the object
print(SpendingDashboardCategory.to_json())

# convert the object into a dict
spending_dashboard_category_dict = spending_dashboard_category_instance.to_dict()
# create an instance of SpendingDashboardCategory from a dict
spending_dashboard_category_from_dict = SpendingDashboardCategory.from_dict(spending_dashboard_category_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


