# GetLookupResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetLookupResponseData**](GetLookupResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_lookup_response import GetLookupResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetLookupResponse from a JSON string
get_lookup_response_instance = GetLookupResponse.from_json(json)
# print the JSON string representation of the object
print(GetLookupResponse.to_json())

# convert the object into a dict
get_lookup_response_dict = get_lookup_response_instance.to_dict()
# create an instance of GetLookupResponse from a dict
get_lookup_response_from_dict = GetLookupResponse.from_dict(get_lookup_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


