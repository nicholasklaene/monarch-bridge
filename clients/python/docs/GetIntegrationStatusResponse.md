# GetIntegrationStatusResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetIntegrationStatusResponseData**](GetIntegrationStatusResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_integration_status_response import GetIntegrationStatusResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetIntegrationStatusResponse from a JSON string
get_integration_status_response_instance = GetIntegrationStatusResponse.from_json(json)
# print the JSON string representation of the object
print(GetIntegrationStatusResponse.to_json())

# convert the object into a dict
get_integration_status_response_dict = get_integration_status_response_instance.to_dict()
# create an instance of GetIntegrationStatusResponse from a dict
get_integration_status_response_from_dict = GetIntegrationStatusResponse.from_dict(get_integration_status_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


