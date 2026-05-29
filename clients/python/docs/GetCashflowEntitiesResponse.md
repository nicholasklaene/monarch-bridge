# GetCashflowEntitiesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCashflowEntitiesResponseData**](GetCashflowEntitiesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cashflow_entities_response import GetCashflowEntitiesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowEntitiesResponse from a JSON string
get_cashflow_entities_response_instance = GetCashflowEntitiesResponse.from_json(json)
# print the JSON string representation of the object
print(GetCashflowEntitiesResponse.to_json())

# convert the object into a dict
get_cashflow_entities_response_dict = get_cashflow_entities_response_instance.to_dict()
# create an instance of GetCashflowEntitiesResponse from a dict
get_cashflow_entities_response_from_dict = GetCashflowEntitiesResponse.from_dict(get_cashflow_entities_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


