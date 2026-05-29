# CreditHistoryResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCreditHistoryResponseData**](GetCreditHistoryResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.credit_history_response import CreditHistoryResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreditHistoryResponse from a JSON string
credit_history_response_instance = CreditHistoryResponse.from_json(json)
# print the JSON string representation of the object
print(CreditHistoryResponse.to_json())

# convert the object into a dict
credit_history_response_dict = credit_history_response_instance.to_dict()
# create an instance of CreditHistoryResponse from a dict
credit_history_response_from_dict = CreditHistoryResponse.from_dict(credit_history_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


