# GetTransactionsDashboardResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total_count** | **int** |  | [optional] 
**total_selectable_count** | **int** |  | [optional] 
**rule_count** | **int** |  | [optional] 
**summary_count** | **int** |  | [optional] 
**results** | [**List[DashboardTransactionRow]**](DashboardTransactionRow.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transactions_dashboard_response_data import GetTransactionsDashboardResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionsDashboardResponseData from a JSON string
get_transactions_dashboard_response_data_instance = GetTransactionsDashboardResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTransactionsDashboardResponseData.to_json())

# convert the object into a dict
get_transactions_dashboard_response_data_dict = get_transactions_dashboard_response_data_instance.to_dict()
# create an instance of GetTransactionsDashboardResponseData from a dict
get_transactions_dashboard_response_data_from_dict = GetTransactionsDashboardResponseData.from_dict(get_transactions_dashboard_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


