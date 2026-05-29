# GetBudgetTimelineResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**months** | [**List[BudgetTimelineMonth]**](BudgetTimelineMonth.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_budget_timeline_response_data import GetBudgetTimelineResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetBudgetTimelineResponseData from a JSON string
get_budget_timeline_response_data_instance = GetBudgetTimelineResponseData.from_json(json)
# print the JSON string representation of the object
print(GetBudgetTimelineResponseData.to_json())

# convert the object into a dict
get_budget_timeline_response_data_dict = get_budget_timeline_response_data_instance.to_dict()
# create an instance of GetBudgetTimelineResponseData from a dict
get_budget_timeline_response_data_from_dict = GetBudgetTimelineResponseData.from_dict(get_budget_timeline_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


