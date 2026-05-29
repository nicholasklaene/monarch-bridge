# MobileScreenAggregateResponse

Envelope for every `/v1/mobile/*` screen-aggregate endpoint. `data` is the raw Monarch GraphQL response tree as a FreeForm map; the proxy does not type the deep shape because mobile-bundle aggregates churn per release. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | **Dict[str, object]** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | 

## Example

```python
from monarch_bridge_client.models.mobile_screen_aggregate_response import MobileScreenAggregateResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MobileScreenAggregateResponse from a JSON string
mobile_screen_aggregate_response_instance = MobileScreenAggregateResponse.from_json(json)
# print the JSON string representation of the object
print(MobileScreenAggregateResponse.to_json())

# convert the object into a dict
mobile_screen_aggregate_response_dict = mobile_screen_aggregate_response_instance.to_dict()
# create an instance of MobileScreenAggregateResponse from a dict
mobile_screen_aggregate_response_from_dict = MobileScreenAggregateResponse.from_dict(mobile_screen_aggregate_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


