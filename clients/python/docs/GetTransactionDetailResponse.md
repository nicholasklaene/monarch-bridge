# GetTransactionDetailResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionDetailResponseData**](GetTransactionDetailResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transaction_detail_response import GetTransactionDetailResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionDetailResponse from a JSON string
get_transaction_detail_response_instance = GetTransactionDetailResponse.from_json(json)
# print the JSON string representation of the object
print(GetTransactionDetailResponse.to_json())

# convert the object into a dict
get_transaction_detail_response_dict = get_transaction_detail_response_instance.to_dict()
# create an instance of GetTransactionDetailResponse from a dict
get_transaction_detail_response_from_dict = GetTransactionDetailResponse.from_dict(get_transaction_detail_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


