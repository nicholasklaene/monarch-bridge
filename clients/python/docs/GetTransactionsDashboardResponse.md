# GetTransactionsDashboardResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionsDashboardResponseData**](GetTransactionsDashboardResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transactions_dashboard_response import GetTransactionsDashboardResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionsDashboardResponse from a JSON string
get_transactions_dashboard_response_instance = GetTransactionsDashboardResponse.from_json(json)
# print the JSON string representation of the object
print(GetTransactionsDashboardResponse.to_json())

# convert the object into a dict
get_transactions_dashboard_response_dict = get_transactions_dashboard_response_instance.to_dict()
# create an instance of GetTransactionsDashboardResponse from a dict
get_transactions_dashboard_response_from_dict = GetTransactionsDashboardResponse.from_dict(get_transactions_dashboard_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


