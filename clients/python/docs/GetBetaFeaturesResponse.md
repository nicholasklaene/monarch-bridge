# GetBetaFeaturesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetBetaFeaturesResponseData**](GetBetaFeaturesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_beta_features_response import GetBetaFeaturesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetBetaFeaturesResponse from a JSON string
get_beta_features_response_instance = GetBetaFeaturesResponse.from_json(json)
# print the JSON string representation of the object
print(GetBetaFeaturesResponse.to_json())

# convert the object into a dict
get_beta_features_response_dict = get_beta_features_response_instance.to_dict()
# create an instance of GetBetaFeaturesResponse from a dict
get_beta_features_response_from_dict = GetBetaFeaturesResponse.from_dict(get_beta_features_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


