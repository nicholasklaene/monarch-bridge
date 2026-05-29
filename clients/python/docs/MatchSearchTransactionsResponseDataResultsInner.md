# MatchSearchTransactionsResponseDataResultsInner


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**amount** | **float** |  | [optional] 
**var_date** | **str** |  | [optional] 
**plaid_name** | **str** |  | [optional] 
**merchant** | [**MatchSearchTransactionsResponseDataResultsInnerMerchant**](MatchSearchTransactionsResponseDataResultsInnerMerchant.md) |  | [optional] 
**account** | [**MatchSearchTransactionsResponseDataResultsInnerAccount**](MatchSearchTransactionsResponseDataResultsInnerAccount.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.match_search_transactions_response_data_results_inner import MatchSearchTransactionsResponseDataResultsInner

# TODO update the JSON string below
json = "{}"
# create an instance of MatchSearchTransactionsResponseDataResultsInner from a JSON string
match_search_transactions_response_data_results_inner_instance = MatchSearchTransactionsResponseDataResultsInner.from_json(json)
# print the JSON string representation of the object
print(MatchSearchTransactionsResponseDataResultsInner.to_json())

# convert the object into a dict
match_search_transactions_response_data_results_inner_dict = match_search_transactions_response_data_results_inner_instance.to_dict()
# create an instance of MatchSearchTransactionsResponseDataResultsInner from a dict
match_search_transactions_response_data_results_inner_from_dict = MatchSearchTransactionsResponseDataResultsInner.from_dict(match_search_transactions_response_data_results_inner_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


