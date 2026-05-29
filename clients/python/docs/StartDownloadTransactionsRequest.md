# StartDownloadTransactionsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filters** | **Dict[str, object]** | TransactionFilterInput - passed through verbatim. Common keys, &#x60;search&#x60;, &#x60;categories&#x60;, &#x60;accounts&#x60;, &#x60;tags&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;hideFromReports&#x60;. | [optional] 
**order_by** | **str** | Sort key (e.g. &#x60;date&#x60; or &#x60;amount&#x60;). Optional. | [optional] 

## Example

```python
from monarch_bridge_client.models.start_download_transactions_request import StartDownloadTransactionsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of StartDownloadTransactionsRequest from a JSON string
start_download_transactions_request_instance = StartDownloadTransactionsRequest.from_json(json)
# print the JSON string representation of the object
print(StartDownloadTransactionsRequest.to_json())

# convert the object into a dict
start_download_transactions_request_dict = start_download_transactions_request_instance.to_dict()
# create an instance of StartDownloadTransactionsRequest from a dict
start_download_transactions_request_from_dict = StartDownloadTransactionsRequest.from_dict(start_download_transactions_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


