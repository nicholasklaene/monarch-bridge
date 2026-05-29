# ArchiveGoalResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateGoalResponseData**](CreateGoalResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.archive_goal_response import ArchiveGoalResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ArchiveGoalResponse from a JSON string
archive_goal_response_instance = ArchiveGoalResponse.from_json(json)
# print the JSON string representation of the object
print(ArchiveGoalResponse.to_json())

# convert the object into a dict
archive_goal_response_dict = archive_goal_response_instance.to_dict()
# create an instance of ArchiveGoalResponse from a dict
archive_goal_response_from_dict = ArchiveGoalResponse.from_dict(archive_goal_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


