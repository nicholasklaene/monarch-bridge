# GetCreditHistoryResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**snapshots** | [**List[CreditScoreSnapshot]**](CreditScoreSnapshot.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_credit_history_response_data import GetCreditHistoryResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCreditHistoryResponseData from a JSON string
get_credit_history_response_data_instance = GetCreditHistoryResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCreditHistoryResponseData.to_json())

# convert the object into a dict
get_credit_history_response_data_dict = get_credit_history_response_data_instance.to_dict()
# create an instance of GetCreditHistoryResponseData from a dict
get_credit_history_response_data_from_dict = GetCreditHistoryResponseData.from_dict(get_credit_history_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


