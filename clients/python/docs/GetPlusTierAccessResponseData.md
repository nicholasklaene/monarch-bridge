# GetPlusTierAccessResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**entitlements** | **List[str]** |  | 
**plus_trial_ends_at** | **str** |  | [optional] 
**canceled_plus_trial_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_plus_tier_access_response_data import GetPlusTierAccessResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetPlusTierAccessResponseData from a JSON string
get_plus_tier_access_response_data_instance = GetPlusTierAccessResponseData.from_json(json)
# print the JSON string representation of the object
print(GetPlusTierAccessResponseData.to_json())

# convert the object into a dict
get_plus_tier_access_response_data_dict = get_plus_tier_access_response_data_instance.to_dict()
# create an instance of GetPlusTierAccessResponseData from a dict
get_plus_tier_access_response_data_from_dict = GetPlusTierAccessResponseData.from_dict(get_plus_tier_access_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


