# GetTransactionsSummaryResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionsSummaryResponseData**](GetTransactionsSummaryResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transactions_summary_response import GetTransactionsSummaryResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionsSummaryResponse from a JSON string
get_transactions_summary_response_instance = GetTransactionsSummaryResponse.from_json(json)
# print the JSON string representation of the object
print(GetTransactionsSummaryResponse.to_json())

# convert the object into a dict
get_transactions_summary_response_dict = get_transactions_summary_response_instance.to_dict()
# create an instance of GetTransactionsSummaryResponse from a dict
get_transactions_summary_response_from_dict = GetTransactionsSummaryResponse.from_dict(get_transactions_summary_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


