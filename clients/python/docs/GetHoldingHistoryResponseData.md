# GetHoldingHistoryResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**history** | [**List[HoldingHistoryPoint]**](HoldingHistoryPoint.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_holding_history_response_data import GetHoldingHistoryResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetHoldingHistoryResponseData from a JSON string
get_holding_history_response_data_instance = GetHoldingHistoryResponseData.from_json(json)
# print the JSON string representation of the object
print(GetHoldingHistoryResponseData.to_json())

# convert the object into a dict
get_holding_history_response_data_dict = get_holding_history_response_data_instance.to_dict()
# create an instance of GetHoldingHistoryResponseData from a dict
get_holding_history_response_data_from_dict = GetHoldingHistoryResponseData.from_dict(get_holding_history_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


