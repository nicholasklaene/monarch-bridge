# ErrorResponse

Uniform error shape for every non-2xx response. `code` is one of the canonical machine-readable values (`invalid_input`, `invalid_param`, `session_missing`, `session_expired`, `rate_limited`, `monarch_request_failed`, `payload_error`, `not_found`, `internal_error`) OR - when forwarded from a Monarch PayloadError - the upstream error code verbatim. Modeled as `string` to keep the forwarded case open-ended. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **str** | Stable machine-readable error code. | 
**message** | **str** | Human-readable explanation. | 
**details** | **Dict[str, object]** | Free-form structured detail (field errors, upstream payload error, etc.). | [optional] 

## Example

```python
from monarch_bridge_client.models.error_response import ErrorResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ErrorResponse from a JSON string
error_response_instance = ErrorResponse.from_json(json)
# print the JSON string representation of the object
print(ErrorResponse.to_json())

# convert the object into a dict
error_response_dict = error_response_instance.to_dict()
# create an instance of ErrorResponse from a dict
error_response_from_dict = ErrorResponse.from_dict(error_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


