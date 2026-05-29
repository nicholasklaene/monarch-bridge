# ListGoalsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListGoalsResponseData**](ListGoalsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_goals_response import ListGoalsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListGoalsResponse from a JSON string
list_goals_response_instance = ListGoalsResponse.from_json(json)
# print the JSON string representation of the object
print(ListGoalsResponse.to_json())

# convert the object into a dict
list_goals_response_dict = list_goals_response_instance.to_dict()
# create an instance of ListGoalsResponse from a dict
list_goals_response_from_dict = ListGoalsResponse.from_dict(list_goals_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


