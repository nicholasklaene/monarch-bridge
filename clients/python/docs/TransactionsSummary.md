# TransactionsSummary

Aggregate stats across a transaction window.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**count** | **int** |  | [optional] 
**sum** | **float** |  | [optional] 
**avg** | **float** |  | [optional] 
**min** | **float** |  | [optional] 
**max** | **float** |  | [optional] 
**first** | **date** |  | [optional] 
**last** | **date** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transactions_summary import TransactionsSummary

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionsSummary from a JSON string
transactions_summary_instance = TransactionsSummary.from_json(json)
# print the JSON string representation of the object
print(TransactionsSummary.to_json())

# convert the object into a dict
transactions_summary_dict = transactions_summary_instance.to_dict()
# create an instance of TransactionsSummary from a dict
transactions_summary_from_dict = TransactionsSummary.from_dict(transactions_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


