# PreviewAccountBalanceResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**PreviewAccountBalanceResponseData**](PreviewAccountBalanceResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.preview_account_balance_response import PreviewAccountBalanceResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PreviewAccountBalanceResponse from a JSON string
preview_account_balance_response_instance = PreviewAccountBalanceResponse.from_json(json)
# print the JSON string representation of the object
print(PreviewAccountBalanceResponse.to_json())

# convert the object into a dict
preview_account_balance_response_dict = preview_account_balance_response_instance.to_dict()
# create an instance of PreviewAccountBalanceResponse from a dict
preview_account_balance_response_from_dict = PreviewAccountBalanceResponse.from_dict(preview_account_balance_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


