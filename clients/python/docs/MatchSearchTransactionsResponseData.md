# MatchSearchTransactionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[MatchSearchTransactionsResponseDataResultsInner]**](MatchSearchTransactionsResponseDataResultsInner.md) |  | 

## Example

```python
from monarch_bridge_client.models.match_search_transactions_response_data import MatchSearchTransactionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of MatchSearchTransactionsResponseData from a JSON string
match_search_transactions_response_data_instance = MatchSearchTransactionsResponseData.from_json(json)
# print the JSON string representation of the object
print(MatchSearchTransactionsResponseData.to_json())

# convert the object into a dict
match_search_transactions_response_data_dict = match_search_transactions_response_data_instance.to_dict()
# create an instance of MatchSearchTransactionsResponseData from a dict
match_search_transactions_response_data_from_dict = MatchSearchTransactionsResponseData.from_dict(match_search_transactions_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


