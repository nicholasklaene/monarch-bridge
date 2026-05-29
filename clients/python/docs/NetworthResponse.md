# NetworthResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetNetworthResponseData**](GetNetworthResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.networth_response import NetworthResponse

# TODO update the JSON string below
json = "{}"
# create an instance of NetworthResponse from a JSON string
networth_response_instance = NetworthResponse.from_json(json)
# print the JSON string representation of the object
print(NetworthResponse.to_json())

# convert the object into a dict
networth_response_dict = networth_response_instance.to_dict()
# create an instance of NetworthResponse from a dict
networth_response_from_dict = NetworthResponse.from_dict(networth_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


