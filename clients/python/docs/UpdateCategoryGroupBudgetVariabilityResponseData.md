# UpdateCategoryGroupBudgetVariabilityResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_group** | [**CategoryGroupBudgetVariabilityRef**](CategoryGroupBudgetVariabilityRef.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_category_group_budget_variability_response_data import UpdateCategoryGroupBudgetVariabilityResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateCategoryGroupBudgetVariabilityResponseData from a JSON string
update_category_group_budget_variability_response_data_instance = UpdateCategoryGroupBudgetVariabilityResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateCategoryGroupBudgetVariabilityResponseData.to_json())

# convert the object into a dict
update_category_group_budget_variability_response_data_dict = update_category_group_budget_variability_response_data_instance.to_dict()
# create an instance of UpdateCategoryGroupBudgetVariabilityResponseData from a dict
update_category_group_budget_variability_response_data_from_dict = UpdateCategoryGroupBudgetVariabilityResponseData.from_dict(update_category_group_budget_variability_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


