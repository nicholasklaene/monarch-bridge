# TransactionsSummaryResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionsSummaryResponseData**](GetTransactionsSummaryResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.transactions_summary_response import TransactionsSummaryResponse

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionsSummaryResponse from a JSON string
transactions_summary_response_instance = TransactionsSummaryResponse.from_json(json)
# print the JSON string representation of the object
print(TransactionsSummaryResponse.to_json())

# convert the object into a dict
transactions_summary_response_dict = transactions_summary_response_instance.to_dict()
# create an instance of TransactionsSummaryResponse from a dict
transactions_summary_response_from_dict = TransactionsSummaryResponse.from_dict(transactions_summary_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


