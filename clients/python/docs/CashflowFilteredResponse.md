# CashflowFilteredResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCashflowFilteredResponseData**](GetCashflowFilteredResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.cashflow_filtered_response import CashflowFilteredResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowFilteredResponse from a JSON string
cashflow_filtered_response_instance = CashflowFilteredResponse.from_json(json)
# print the JSON string representation of the object
print(CashflowFilteredResponse.to_json())

# convert the object into a dict
cashflow_filtered_response_dict = cashflow_filtered_response_instance.to_dict()
# create an instance of CashflowFilteredResponse from a dict
cashflow_filtered_response_from_dict = CashflowFilteredResponse.from_dict(cashflow_filtered_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


