# DashboardTransactionRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**var_date** | **date** |  | [optional] 
**amount** | **float** |  | [optional] 
**merchant_name** | **str** |  | [optional] 
**category_name** | **str** |  | [optional] 
**account_display_name** | **str** |  | [optional] 
**notes** | **str** |  | [optional] 
**plaid_name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.dashboard_transaction_row import DashboardTransactionRow

# TODO update the JSON string below
json = "{}"
# create an instance of DashboardTransactionRow from a JSON string
dashboard_transaction_row_instance = DashboardTransactionRow.from_json(json)
# print the JSON string representation of the object
print(DashboardTransactionRow.to_json())

# convert the object into a dict
dashboard_transaction_row_dict = dashboard_transaction_row_instance.to_dict()
# create an instance of DashboardTransactionRow from a dict
dashboard_transaction_row_from_dict = DashboardTransactionRow.from_dict(dashboard_transaction_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


