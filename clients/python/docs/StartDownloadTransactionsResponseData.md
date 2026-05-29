# StartDownloadTransactionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**session_key** | **str** |  | 
**status** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.start_download_transactions_response_data import StartDownloadTransactionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of StartDownloadTransactionsResponseData from a JSON string
start_download_transactions_response_data_instance = StartDownloadTransactionsResponseData.from_json(json)
# print the JSON string representation of the object
print(StartDownloadTransactionsResponseData.to_json())

# convert the object into a dict
start_download_transactions_response_data_dict = start_download_transactions_response_data_instance.to_dict()
# create an instance of StartDownloadTransactionsResponseData from a dict
start_download_transactions_response_data_from_dict = StartDownloadTransactionsResponseData.from_dict(start_download_transactions_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


