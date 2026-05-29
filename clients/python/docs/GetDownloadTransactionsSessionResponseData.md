# GetDownloadTransactionsSessionResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**session_key** | **str** |  | 
**status** | **str** |  | [optional] 
**error_message** | **str** |  | [optional] 
**url** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_download_transactions_session_response_data import GetDownloadTransactionsSessionResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetDownloadTransactionsSessionResponseData from a JSON string
get_download_transactions_session_response_data_instance = GetDownloadTransactionsSessionResponseData.from_json(json)
# print the JSON string representation of the object
print(GetDownloadTransactionsSessionResponseData.to_json())

# convert the object into a dict
get_download_transactions_session_response_data_dict = get_download_transactions_session_response_data_instance.to_dict()
# create an instance of GetDownloadTransactionsSessionResponseData from a dict
get_download_transactions_session_response_data_from_dict = GetDownloadTransactionsSessionResponseData.from_dict(get_download_transactions_session_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


