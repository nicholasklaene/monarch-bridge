# GetLookupResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[LookupEntity]**](LookupEntity.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_lookup_response_data import GetLookupResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetLookupResponseData from a JSON string
get_lookup_response_data_instance = GetLookupResponseData.from_json(json)
# print the JSON string representation of the object
print(GetLookupResponseData.to_json())

# convert the object into a dict
get_lookup_response_data_dict = get_lookup_response_data_instance.to_dict()
# create an instance of GetLookupResponseData from a dict
get_lookup_response_data_from_dict = GetLookupResponseData.from_dict(get_lookup_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


