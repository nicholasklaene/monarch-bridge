# GetNetworthResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetNetworthResponseData**](GetNetworthResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_networth_response import GetNetworthResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetNetworthResponse from a JSON string
get_networth_response_instance = GetNetworthResponse.from_json(json)
# print the JSON string representation of the object
print(GetNetworthResponse.to_json())

# convert the object into a dict
get_networth_response_dict = get_networth_response_instance.to_dict()
# create an instance of GetNetworthResponse from a dict
get_networth_response_from_dict = GetNetworthResponse.from_dict(get_networth_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


