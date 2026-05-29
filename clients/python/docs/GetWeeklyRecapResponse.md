# GetWeeklyRecapResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetWeeklyRecapResponseData**](GetWeeklyRecapResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_weekly_recap_response import GetWeeklyRecapResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetWeeklyRecapResponse from a JSON string
get_weekly_recap_response_instance = GetWeeklyRecapResponse.from_json(json)
# print the JSON string representation of the object
print(GetWeeklyRecapResponse.to_json())

# convert the object into a dict
get_weekly_recap_response_dict = get_weekly_recap_response_instance.to_dict()
# create an instance of GetWeeklyRecapResponse from a dict
get_weekly_recap_response_from_dict = GetWeeklyRecapResponse.from_dict(get_weekly_recap_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


