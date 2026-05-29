# StartDownloadTransactionsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**StartDownloadTransactionsResponseData**](StartDownloadTransactionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.start_download_transactions_response import StartDownloadTransactionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of StartDownloadTransactionsResponse from a JSON string
start_download_transactions_response_instance = StartDownloadTransactionsResponse.from_json(json)
# print the JSON string representation of the object
print(StartDownloadTransactionsResponse.to_json())

# convert the object into a dict
start_download_transactions_response_dict = start_download_transactions_response_instance.to_dict()
# create an instance of StartDownloadTransactionsResponse from a dict
start_download_transactions_response_from_dict = StartDownloadTransactionsResponse.from_dict(start_download_transactions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


