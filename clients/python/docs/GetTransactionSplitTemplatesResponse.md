# GetTransactionSplitTemplatesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionSplitTemplatesResponseData**](GetTransactionSplitTemplatesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transaction_split_templates_response import GetTransactionSplitTemplatesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionSplitTemplatesResponse from a JSON string
get_transaction_split_templates_response_instance = GetTransactionSplitTemplatesResponse.from_json(json)
# print the JSON string representation of the object
print(GetTransactionSplitTemplatesResponse.to_json())

# convert the object into a dict
get_transaction_split_templates_response_dict = get_transaction_split_templates_response_instance.to_dict()
# create an instance of GetTransactionSplitTemplatesResponse from a dict
get_transaction_split_templates_response_from_dict = GetTransactionSplitTemplatesResponse.from_dict(get_transaction_split_templates_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


