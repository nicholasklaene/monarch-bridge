# GetCashflowBreakdownResponse

Cashflow broken down into four buckets. The bucket arrays are free-form Monarch trees (category / group / merchant aggregates); summary is also free-form. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCashflowBreakdownResponseData**](GetCashflowBreakdownResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cashflow_breakdown_response import GetCashflowBreakdownResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowBreakdownResponse from a JSON string
get_cashflow_breakdown_response_instance = GetCashflowBreakdownResponse.from_json(json)
# print the JSON string representation of the object
print(GetCashflowBreakdownResponse.to_json())

# convert the object into a dict
get_cashflow_breakdown_response_dict = get_cashflow_breakdown_response_instance.to_dict()
# create an instance of GetCashflowBreakdownResponse from a dict
get_cashflow_breakdown_response_from_dict = GetCashflowBreakdownResponse.from_dict(get_cashflow_breakdown_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


