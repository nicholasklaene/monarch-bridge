# GetIntegrationStatusResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**integrations** | [**List[IntegrationStatus]**](IntegrationStatus.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_integration_status_response_data import GetIntegrationStatusResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetIntegrationStatusResponseData from a JSON string
get_integration_status_response_data_instance = GetIntegrationStatusResponseData.from_json(json)
# print the JSON string representation of the object
print(GetIntegrationStatusResponseData.to_json())

# convert the object into a dict
get_integration_status_response_data_dict = get_integration_status_response_data_instance.to_dict()
# create an instance of GetIntegrationStatusResponseData from a dict
get_integration_status_response_data_from_dict = GetIntegrationStatusResponseData.from_dict(get_integration_status_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


