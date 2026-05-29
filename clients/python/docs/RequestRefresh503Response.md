# RequestRefresh503Response

Uniform error shape for every non-2xx response. `code` is one of the canonical machine-readable values (`invalid_input`, `invalid_param`, `session_missing`, `session_expired`, `rate_limited`, `monarch_request_failed`, `payload_error`, `not_found`, `internal_error`) OR - when forwarded from a Monarch PayloadError - the upstream error code verbatim. Modeled as `string` to keep the forwarded case open-ended. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **str** | Stable machine-readable error code. | 
**message** | **str** | Human-readable explanation. | 
**details** | **Dict[str, object]** | Free-form structured detail (field errors, upstream payload error, etc.). | [optional] 

## Example

```python
from monarch_bridge_client.models.request_refresh503_response import RequestRefresh503Response

# TODO update the JSON string below
json = "{}"
# create an instance of RequestRefresh503Response from a JSON string
request_refresh503_response_instance = RequestRefresh503Response.from_json(json)
# print the JSON string representation of the object
print(RequestRefresh503Response.to_json())

# convert the object into a dict
request_refresh503_response_dict = request_refresh503_response_instance.to_dict()
# create an instance of RequestRefresh503Response from a dict
request_refresh503_response_from_dict = RequestRefresh503Response.from_dict(request_refresh503_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


