# IntegrationStatus

Per-credential provider health row.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**credential_id** | **str** |  | 
**institution_name** | **str** |  | [optional] 
**provider** | **str** | &#x60;plaid&#x60;, &#x60;mx&#x60;, &#x60;finicity&#x60;, &#x60;manual&#x60;. | [optional] 
**status** | **str** | &#x60;connected&#x60;, &#x60;syncing&#x60;, &#x60;error&#x60;, &#x60;disconnected&#x60;. | [optional] 
**last_synced_at** | **str** |  | [optional] 
**error_code** | **str** |  | [optional] 
**error_message** | **str** |  | [optional] 
**needs_reauth** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.integration_status import IntegrationStatus

# TODO update the JSON string below
json = "{}"
# create an instance of IntegrationStatus from a JSON string
integration_status_instance = IntegrationStatus.from_json(json)
# print the JSON string representation of the object
print(IntegrationStatus.to_json())

# convert the object into a dict
integration_status_dict = integration_status_instance.to_dict()
# create an instance of IntegrationStatus from a dict
integration_status_from_dict = IntegrationStatus.from_dict(integration_status_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


