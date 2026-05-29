# GetCashflowBreakdownResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**by_category** | **List[Dict[str, object]]** |  | 
**by_category_group** | **List[Dict[str, object]]** |  | 
**by_merchant** | **List[Dict[str, object]]** |  | 
**summary** | **Dict[str, object]** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_cashflow_breakdown_response_data import GetCashflowBreakdownResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowBreakdownResponseData from a JSON string
get_cashflow_breakdown_response_data_instance = GetCashflowBreakdownResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCashflowBreakdownResponseData.to_json())

# convert the object into a dict
get_cashflow_breakdown_response_data_dict = get_cashflow_breakdown_response_data_instance.to_dict()
# create an instance of GetCashflowBreakdownResponseData from a dict
get_cashflow_breakdown_response_data_from_dict = GetCashflowBreakdownResponseData.from_dict(get_cashflow_breakdown_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


