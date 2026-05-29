# GetNetworthByTypeResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetNetworthByTypeResponseData**](GetNetworthByTypeResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_networth_by_type_response import GetNetworthByTypeResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetNetworthByTypeResponse from a JSON string
get_networth_by_type_response_instance = GetNetworthByTypeResponse.from_json(json)
# print the JSON string representation of the object
print(GetNetworthByTypeResponse.to_json())

# convert the object into a dict
get_networth_by_type_response_dict = get_networth_by_type_response_instance.to_dict()
# create an instance of GetNetworthByTypeResponse from a dict
get_networth_by_type_response_from_dict = GetNetworthByTypeResponse.from_dict(get_networth_by_type_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


