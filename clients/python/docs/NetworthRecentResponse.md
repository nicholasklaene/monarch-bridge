# NetworthRecentResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetNetworthRecentResponseData**](GetNetworthRecentResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.networth_recent_response import NetworthRecentResponse

# TODO update the JSON string below
json = "{}"
# create an instance of NetworthRecentResponse from a JSON string
networth_recent_response_instance = NetworthRecentResponse.from_json(json)
# print the JSON string representation of the object
print(NetworthRecentResponse.to_json())

# convert the object into a dict
networth_recent_response_dict = networth_recent_response_instance.to_dict()
# create an instance of NetworthRecentResponse from a dict
networth_recent_response_from_dict = NetworthRecentResponse.from_dict(networth_recent_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


