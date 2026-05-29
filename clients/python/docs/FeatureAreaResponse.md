# FeatureAreaResponse

Envelope for every `/v1/{advice,forecast,bills,equity-grants,report-configs, business-entities}/*` feature-area endpoint. `data` is the raw Monarch GraphQL response tree as a FreeForm map; the proxy does not type the deep shape because these Monarch surfaces (advice items, forecast scenarios, bills, equity grants, report configs, business entities) churn per release and are wiring-only here. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | **Dict[str, object]** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | 

## Example

```python
from monarch_bridge_client.models.feature_area_response import FeatureAreaResponse

# TODO update the JSON string below
json = "{}"
# create an instance of FeatureAreaResponse from a JSON string
feature_area_response_instance = FeatureAreaResponse.from_json(json)
# print the JSON string representation of the object
print(FeatureAreaResponse.to_json())

# convert the object into a dict
feature_area_response_dict = feature_area_response_instance.to_dict()
# create an instance of FeatureAreaResponse from a dict
feature_area_response_from_dict = FeatureAreaResponse.from_dict(feature_area_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


