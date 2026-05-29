# GetBudgetsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**budget_data** | **Dict[str, object]** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] 
**category_groups** | **List[Dict[str, object]]** |  | 

## Example

```python
from monarch_bridge_client.models.get_budgets_response_data import GetBudgetsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetBudgetsResponseData from a JSON string
get_budgets_response_data_instance = GetBudgetsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetBudgetsResponseData.to_json())

# convert the object into a dict
get_budgets_response_data_dict = get_budgets_response_data_instance.to_dict()
# create an instance of GetBudgetsResponseData from a dict
get_budgets_response_data_from_dict = GetBudgetsResponseData.from_dict(get_budgets_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


