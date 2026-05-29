# ListTransactionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total_count** | **int** |  | 
**results** | [**List[Transaction]**](Transaction.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_transactions_response_data import ListTransactionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListTransactionsResponseData from a JSON string
list_transactions_response_data_instance = ListTransactionsResponseData.from_json(json)
# print the JSON string representation of the object
print(ListTransactionsResponseData.to_json())

# convert the object into a dict
list_transactions_response_data_dict = list_transactions_response_data_instance.to_dict()
# create an instance of ListTransactionsResponseData from a dict
list_transactions_response_data_from_dict = ListTransactionsResponseData.from_dict(list_transactions_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


