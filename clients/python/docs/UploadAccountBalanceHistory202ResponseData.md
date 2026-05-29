# UploadAccountBalanceHistory202ResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**session_key** | **str** | Use to poll &#x60;GET /v1/balance-history/{sessionKey}/status&#x60;. | 
**status** | **str** | Current parse status (&#x60;pending&#x60;, &#x60;processing&#x60;, &#x60;completed&#x60;, &#x60;failed&#x60;). | 

## Example

```python
from monarch_bridge_client.models.upload_account_balance_history202_response_data import UploadAccountBalanceHistory202ResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UploadAccountBalanceHistory202ResponseData from a JSON string
upload_account_balance_history202_response_data_instance = UploadAccountBalanceHistory202ResponseData.from_json(json)
# print the JSON string representation of the object
print(UploadAccountBalanceHistory202ResponseData.to_json())

# convert the object into a dict
upload_account_balance_history202_response_data_dict = upload_account_balance_history202_response_data_instance.to_dict()
# create an instance of UploadAccountBalanceHistory202ResponseData from a dict
upload_account_balance_history202_response_data_from_dict = UploadAccountBalanceHistory202ResponseData.from_dict(upload_account_balance_history202_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


