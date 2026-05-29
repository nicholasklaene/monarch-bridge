# GetHoldingHistoryResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetHoldingHistoryResponseData**](GetHoldingHistoryResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_holding_history_response import GetHoldingHistoryResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetHoldingHistoryResponse from a JSON string
get_holding_history_response_instance = GetHoldingHistoryResponse.from_json(json)
# print the JSON string representation of the object
print(GetHoldingHistoryResponse.to_json())

# convert the object into a dict
get_holding_history_response_dict = get_holding_history_response_instance.to_dict()
# create an instance of GetHoldingHistoryResponse from a dict
get_holding_history_response_from_dict = GetHoldingHistoryResponse.from_dict(get_holding_history_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


