# MatchSearchTransactionsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MatchSearchTransactionsResponseData**](MatchSearchTransactionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.match_search_transactions_response import MatchSearchTransactionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MatchSearchTransactionsResponse from a JSON string
match_search_transactions_response_instance = MatchSearchTransactionsResponse.from_json(json)
# print the JSON string representation of the object
print(MatchSearchTransactionsResponse.to_json())

# convert the object into a dict
match_search_transactions_response_dict = match_search_transactions_response_instance.to_dict()
# create an instance of MatchSearchTransactionsResponse from a dict
match_search_transactions_response_from_dict = MatchSearchTransactionsResponse.from_dict(match_search_transactions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


