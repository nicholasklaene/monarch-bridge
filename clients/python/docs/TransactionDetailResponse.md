# TransactionDetailResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionDetailResponseData**](GetTransactionDetailResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.transaction_detail_response import TransactionDetailResponse

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionDetailResponse from a JSON string
transaction_detail_response_instance = TransactionDetailResponse.from_json(json)
# print the JSON string representation of the object
print(TransactionDetailResponse.to_json())

# convert the object into a dict
transaction_detail_response_dict = transaction_detail_response_instance.to_dict()
# create an instance of TransactionDetailResponse from a dict
transaction_detail_response_from_dict = TransactionDetailResponse.from_dict(transaction_detail_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


