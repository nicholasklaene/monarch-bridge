# UpdateCategoryGroupBudgetVariabilityRequest

Body for `PATCH /v1/category-groups/{id}/budget-variability`. Narrowly scoped to flip the fixed-vs-flex classification. Common values: `fixed`, `flexible`, `non_monthly`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**budget_variability** | **str** |  | 

## Example

```python
from monarch_bridge_client.models.update_category_group_budget_variability_request import UpdateCategoryGroupBudgetVariabilityRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateCategoryGroupBudgetVariabilityRequest from a JSON string
update_category_group_budget_variability_request_instance = UpdateCategoryGroupBudgetVariabilityRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateCategoryGroupBudgetVariabilityRequest.to_json())

# convert the object into a dict
update_category_group_budget_variability_request_dict = update_category_group_budget_variability_request_instance.to_dict()
# create an instance of UpdateCategoryGroupBudgetVariabilityRequest from a dict
update_category_group_budget_variability_request_from_dict = UpdateCategoryGroupBudgetVariabilityRequest.from_dict(update_category_group_budget_variability_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


