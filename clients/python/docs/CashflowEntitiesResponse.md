# CashflowEntitiesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCashflowEntitiesResponseData**](GetCashflowEntitiesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.cashflow_entities_response import CashflowEntitiesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowEntitiesResponse from a JSON string
cashflow_entities_response_instance = CashflowEntitiesResponse.from_json(json)
# print the JSON string representation of the object
print(CashflowEntitiesResponse.to_json())

# convert the object into a dict
cashflow_entities_response_dict = cashflow_entities_response_instance.to_dict()
# create an instance of CashflowEntitiesResponse from a dict
cashflow_entities_response_from_dict = CashflowEntitiesResponse.from_dict(cashflow_entities_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


