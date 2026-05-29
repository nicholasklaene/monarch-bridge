# ListGoalsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goals** | [**List[Goal]**](Goal.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_goals_response_data import ListGoalsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListGoalsResponseData from a JSON string
list_goals_response_data_instance = ListGoalsResponseData.from_json(json)
# print the JSON string representation of the object
print(ListGoalsResponseData.to_json())

# convert the object into a dict
list_goals_response_data_dict = list_goals_response_data_instance.to_dict()
# create an instance of ListGoalsResponseData from a dict
list_goals_response_data_from_dict = ListGoalsResponseData.from_dict(list_goals_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


