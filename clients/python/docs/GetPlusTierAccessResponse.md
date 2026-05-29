# GetPlusTierAccessResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetPlusTierAccessResponseData**](GetPlusTierAccessResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_plus_tier_access_response import GetPlusTierAccessResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetPlusTierAccessResponse from a JSON string
get_plus_tier_access_response_instance = GetPlusTierAccessResponse.from_json(json)
# print the JSON string representation of the object
print(GetPlusTierAccessResponse.to_json())

# convert the object into a dict
get_plus_tier_access_response_dict = get_plus_tier_access_response_instance.to_dict()
# create an instance of GetPlusTierAccessResponse from a dict
get_plus_tier_access_response_from_dict = GetPlusTierAccessResponse.from_dict(get_plus_tier_access_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


