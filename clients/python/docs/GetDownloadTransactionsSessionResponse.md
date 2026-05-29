# GetDownloadTransactionsSessionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetDownloadTransactionsSessionResponseData**](GetDownloadTransactionsSessionResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_download_transactions_session_response import GetDownloadTransactionsSessionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetDownloadTransactionsSessionResponse from a JSON string
get_download_transactions_session_response_instance = GetDownloadTransactionsSessionResponse.from_json(json)
# print the JSON string representation of the object
print(GetDownloadTransactionsSessionResponse.to_json())

# convert the object into a dict
get_download_transactions_session_response_dict = get_download_transactions_session_response_instance.to_dict()
# create an instance of GetDownloadTransactionsSessionResponse from a dict
get_download_transactions_session_response_from_dict = GetDownloadTransactionsSessionResponse.from_dict(get_download_transactions_session_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


