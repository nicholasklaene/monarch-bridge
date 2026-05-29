# BalanceHistoryUploadResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UploadAccountBalanceHistory202ResponseData**](UploadAccountBalanceHistory202ResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.balance_history_upload_response import BalanceHistoryUploadResponse

# TODO update the JSON string below
json = "{}"
# create an instance of BalanceHistoryUploadResponse from a JSON string
balance_history_upload_response_instance = BalanceHistoryUploadResponse.from_json(json)
# print the JSON string representation of the object
print(BalanceHistoryUploadResponse.to_json())

# convert the object into a dict
balance_history_upload_response_dict = balance_history_upload_response_instance.to_dict()
# create an instance of BalanceHistoryUploadResponse from a dict
balance_history_upload_response_from_dict = BalanceHistoryUploadResponse.from_dict(balance_history_upload_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


