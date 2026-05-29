# GetBetaFeaturesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**features** | [**List[BetaFeature]**](BetaFeature.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_beta_features_response_data import GetBetaFeaturesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetBetaFeaturesResponseData from a JSON string
get_beta_features_response_data_instance = GetBetaFeaturesResponseData.from_json(json)
# print the JSON string representation of the object
print(GetBetaFeaturesResponseData.to_json())

# convert the object into a dict
get_beta_features_response_data_dict = get_beta_features_response_data_instance.to_dict()
# create an instance of GetBetaFeaturesResponseData from a dict
get_beta_features_response_data_from_dict = GetBetaFeaturesResponseData.from_dict(get_beta_features_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


