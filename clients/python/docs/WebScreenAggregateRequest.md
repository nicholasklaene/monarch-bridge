# WebScreenAggregateRequest

Body shape for every `/v1/web/*` screen-aggregate endpoint. `variables` is forwarded as-is to Monarch's GraphQL endpoint as the operation's `variables` map. Omit the body or send `{}` for ops that take no vars. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**variables** | **Dict[str, object]** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] 

## Example

```python
from monarch_bridge_client.models.web_screen_aggregate_request import WebScreenAggregateRequest

# TODO update the JSON string below
json = "{}"
# create an instance of WebScreenAggregateRequest from a JSON string
web_screen_aggregate_request_instance = WebScreenAggregateRequest.from_json(json)
# print the JSON string representation of the object
print(WebScreenAggregateRequest.to_json())

# convert the object into a dict
web_screen_aggregate_request_dict = web_screen_aggregate_request_instance.to_dict()
# create an instance of WebScreenAggregateRequest from a dict
web_screen_aggregate_request_from_dict = WebScreenAggregateRequest.from_dict(web_screen_aggregate_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


