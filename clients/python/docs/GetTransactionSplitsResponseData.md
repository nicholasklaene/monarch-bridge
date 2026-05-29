# GetTransactionSplitsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**amount** | **float** |  | 
**merchant** | [**Ref**](Ref.md) |  | [optional] 
**category** | [**Ref**](Ref.md) |  | [optional] 
**splits** | [**List[TransactionSplit]**](TransactionSplit.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transaction_splits_response_data import GetTransactionSplitsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionSplitsResponseData from a JSON string
get_transaction_splits_response_data_instance = GetTransactionSplitsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTransactionSplitsResponseData.to_json())

# convert the object into a dict
get_transaction_splits_response_data_dict = get_transaction_splits_response_data_instance.to_dict()
# create an instance of GetTransactionSplitsResponseData from a dict
get_transaction_splits_response_data_from_dict = GetTransactionSplitsResponseData.from_dict(get_transaction_splits_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


