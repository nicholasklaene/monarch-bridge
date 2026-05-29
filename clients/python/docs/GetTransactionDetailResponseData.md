# GetTransactionDetailResponseData

`transaction` is the full upstream Monarch transaction tree (splits, attachments, merchant, category, etc.) - left as free-form so new Monarch fields pass through. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transaction** | **Dict[str, object]** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_transaction_detail_response_data import GetTransactionDetailResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionDetailResponseData from a JSON string
get_transaction_detail_response_data_instance = GetTransactionDetailResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTransactionDetailResponseData.to_json())

# convert the object into a dict
get_transaction_detail_response_data_dict = get_transaction_detail_response_data_instance.to_dict()
# create an instance of GetTransactionDetailResponseData from a dict
get_transaction_detail_response_data_from_dict = GetTransactionDetailResponseData.from_dict(get_transaction_detail_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


