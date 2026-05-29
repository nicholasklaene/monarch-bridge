# NetworthByTypeResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetNetworthByTypeResponseData**](GetNetworthByTypeResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.networth_by_type_response import NetworthByTypeResponse

# TODO update the JSON string below
json = "{}"
# create an instance of NetworthByTypeResponse from a JSON string
networth_by_type_response_instance = NetworthByTypeResponse.from_json(json)
# print the JSON string representation of the object
print(NetworthByTypeResponse.to_json())

# convert the object into a dict
networth_by_type_response_dict = networth_by_type_response_instance.to_dict()
# create an instance of NetworthByTypeResponse from a dict
networth_by_type_response_from_dict = NetworthByTypeResponse.from_dict(networth_by_type_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


