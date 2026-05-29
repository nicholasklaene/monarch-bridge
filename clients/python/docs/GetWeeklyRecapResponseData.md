# GetWeeklyRecapResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**recap** | [**WeeklyRecap**](WeeklyRecap.md) | Null when Monarch has not generated a recap for the window yet. | [optional] 

## Example

```python
from monarch_bridge_client.models.get_weekly_recap_response_data import GetWeeklyRecapResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetWeeklyRecapResponseData from a JSON string
get_weekly_recap_response_data_instance = GetWeeklyRecapResponseData.from_json(json)
# print the JSON string representation of the object
print(GetWeeklyRecapResponseData.to_json())

# convert the object into a dict
get_weekly_recap_response_data_dict = get_weekly_recap_response_data_instance.to_dict()
# create an instance of GetWeeklyRecapResponseData from a dict
get_weekly_recap_response_data_from_dict = GetWeeklyRecapResponseData.from_dict(get_weekly_recap_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


