# SetTransactionTagsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transaction_id** | **str** |  | 
**tag_ids** | **List[str]** |  | 

## Example

```python
from monarch_bridge_client.models.set_transaction_tags_response_data import SetTransactionTagsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of SetTransactionTagsResponseData from a JSON string
set_transaction_tags_response_data_instance = SetTransactionTagsResponseData.from_json(json)
# print the JSON string representation of the object
print(SetTransactionTagsResponseData.to_json())

# convert the object into a dict
set_transaction_tags_response_data_dict = set_transaction_tags_response_data_instance.to_dict()
# create an instance of SetTransactionTagsResponseData from a dict
set_transaction_tags_response_data_from_dict = SetTransactionTagsResponseData.from_dict(set_transaction_tags_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


