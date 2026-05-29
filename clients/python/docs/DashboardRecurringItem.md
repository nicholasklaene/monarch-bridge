# DashboardRecurringItem


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | 
**amount** | **float** |  | [optional] 
**is_past** | **bool** |  | [optional] 
**stream_id** | **str** |  | [optional] 
**stream_name** | **str** |  | [optional] 
**frequency** | **str** |  | [optional] 
**logo_url** | **str** |  | [optional] 
**merchant_id** | **str** |  | [optional] 
**account_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.dashboard_recurring_item import DashboardRecurringItem

# TODO update the JSON string below
json = "{}"
# create an instance of DashboardRecurringItem from a JSON string
dashboard_recurring_item_instance = DashboardRecurringItem.from_json(json)
# print the JSON string representation of the object
print(DashboardRecurringItem.to_json())

# convert the object into a dict
dashboard_recurring_item_dict = dashboard_recurring_item_instance.to_dict()
# create an instance of DashboardRecurringItem from a dict
dashboard_recurring_item_from_dict = DashboardRecurringItem.from_dict(dashboard_recurring_item_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


