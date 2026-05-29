# GetBalanceHistoryStatusResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**session_key** | **str** |  | 
**status** | **str** | Current parse status (&#x60;pending&#x60;, &#x60;processing&#x60;, &#x60;completed&#x60;, &#x60;failed&#x60;). | 

## Example

```python
from monarch_bridge_client.models.get_balance_history_status_response_data import GetBalanceHistoryStatusResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetBalanceHistoryStatusResponseData from a JSON string
get_balance_history_status_response_data_instance = GetBalanceHistoryStatusResponseData.from_json(json)
# print the JSON string representation of the object
print(GetBalanceHistoryStatusResponseData.to_json())

# convert the object into a dict
get_balance_history_status_response_data_dict = get_balance_history_status_response_data_instance.to_dict()
# create an instance of GetBalanceHistoryStatusResponseData from a dict
get_balance_history_status_response_data_from_dict = GetBalanceHistoryStatusResponseData.from_dict(get_balance_history_status_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


