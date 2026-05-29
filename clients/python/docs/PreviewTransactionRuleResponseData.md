# PreviewTransactionRuleResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total_count** | **int** |  | 
**results** | [**List[TransactionRulePreviewMatch]**](TransactionRulePreviewMatch.md) |  | 

## Example

```python
from monarch_bridge_client.models.preview_transaction_rule_response_data import PreviewTransactionRuleResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of PreviewTransactionRuleResponseData from a JSON string
preview_transaction_rule_response_data_instance = PreviewTransactionRuleResponseData.from_json(json)
# print the JSON string representation of the object
print(PreviewTransactionRuleResponseData.to_json())

# convert the object into a dict
preview_transaction_rule_response_data_dict = preview_transaction_rule_response_data_instance.to_dict()
# create an instance of PreviewTransactionRuleResponseData from a dict
preview_transaction_rule_response_data_from_dict = PreviewTransactionRuleResponseData.from_dict(preview_transaction_rule_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


