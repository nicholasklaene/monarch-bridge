# UploadAccountBalanceHistory202Response


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UploadAccountBalanceHistory202ResponseData**](UploadAccountBalanceHistory202ResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.upload_account_balance_history202_response import UploadAccountBalanceHistory202Response

# TODO update the JSON string below
json = "{}"
# create an instance of UploadAccountBalanceHistory202Response from a JSON string
upload_account_balance_history202_response_instance = UploadAccountBalanceHistory202Response.from_json(json)
# print the JSON string representation of the object
print(UploadAccountBalanceHistory202Response.to_json())

# convert the object into a dict
upload_account_balance_history202_response_dict = upload_account_balance_history202_response_instance.to_dict()
# create an instance of UploadAccountBalanceHistory202Response from a dict
upload_account_balance_history202_response_from_dict = UploadAccountBalanceHistory202Response.from_dict(upload_account_balance_history202_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


