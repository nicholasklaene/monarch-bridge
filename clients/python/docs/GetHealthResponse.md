# GetHealthResponse

Body of `GET /healthz`. Self-contained - not wrapped in a `data` envelope so health checks stay zero-parse.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | **str** |  | 
**authenticated** | **bool** | Whether a Monarch session is currently loaded. | 
**last_verified_at** | **datetime** | Last time the loaded session was confirmed valid against Monarch. | [optional] 

## Example

```python
from monarch_bridge_client.models.get_health_response import GetHealthResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetHealthResponse from a JSON string
get_health_response_instance = GetHealthResponse.from_json(json)
# print the JSON string representation of the object
print(GetHealthResponse.to_json())

# convert the object into a dict
get_health_response_dict = get_health_response_instance.to_dict()
# create an instance of GetHealthResponse from a dict
get_health_response_from_dict = GetHealthResponse.from_dict(get_health_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


