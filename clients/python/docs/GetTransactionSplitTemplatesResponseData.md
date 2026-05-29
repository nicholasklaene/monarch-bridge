# GetTransactionSplitTemplatesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**templates** | [**List[SplitTemplate]**](SplitTemplate.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transaction_split_templates_response_data import GetTransactionSplitTemplatesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionSplitTemplatesResponseData from a JSON string
get_transaction_split_templates_response_data_instance = GetTransactionSplitTemplatesResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTransactionSplitTemplatesResponseData.to_json())

# convert the object into a dict
get_transaction_split_templates_response_data_dict = get_transaction_split_templates_response_data_instance.to_dict()
# create an instance of GetTransactionSplitTemplatesResponseData from a dict
get_transaction_split_templates_response_data_from_dict = GetTransactionSplitTemplatesResponseData.from_dict(get_transaction_split_templates_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


