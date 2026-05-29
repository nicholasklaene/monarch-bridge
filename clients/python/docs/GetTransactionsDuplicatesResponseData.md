# GetTransactionsDuplicatesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | [**List[GetTransactionsDuplicatesResponseDataGroupsInner]**](GetTransactionsDuplicatesResponseDataGroupsInner.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transactions_duplicates_response_data import GetTransactionsDuplicatesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionsDuplicatesResponseData from a JSON string
get_transactions_duplicates_response_data_instance = GetTransactionsDuplicatesResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTransactionsDuplicatesResponseData.to_json())

# convert the object into a dict
get_transactions_duplicates_response_data_dict = get_transactions_duplicates_response_data_instance.to_dict()
# create an instance of GetTransactionsDuplicatesResponseData from a dict
get_transactions_duplicates_response_data_from_dict = GetTransactionsDuplicatesResponseData.from_dict(get_transactions_duplicates_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


