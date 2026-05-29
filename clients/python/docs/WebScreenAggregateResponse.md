# WebScreenAggregateResponse

Envelope for every `/v1/web/*` screen-aggregate endpoint. `data` is the raw Monarch GraphQL response tree as a FreeForm map; the proxy does not type the deep shape because web-bundle aggregates churn per release. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | **Dict[str, object]** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | 

## Example

```python
from monarch_bridge_client.models.web_screen_aggregate_response import WebScreenAggregateResponse

# TODO update the JSON string below
json = "{}"
# create an instance of WebScreenAggregateResponse from a JSON string
web_screen_aggregate_response_instance = WebScreenAggregateResponse.from_json(json)
# print the JSON string representation of the object
print(WebScreenAggregateResponse.to_json())

# convert the object into a dict
web_screen_aggregate_response_dict = web_screen_aggregate_response_instance.to_dict()
# create an instance of WebScreenAggregateResponse from a dict
web_screen_aggregate_response_from_dict = WebScreenAggregateResponse.from_dict(web_screen_aggregate_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


