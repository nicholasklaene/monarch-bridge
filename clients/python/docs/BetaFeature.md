# BetaFeature


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**description** | **str** |  | [optional] 
**enrolled** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.beta_feature import BetaFeature

# TODO update the JSON string below
json = "{}"
# create an instance of BetaFeature from a JSON string
beta_feature_instance = BetaFeature.from_json(json)
# print the JSON string representation of the object
print(BetaFeature.to_json())

# convert the object into a dict
beta_feature_dict = beta_feature_instance.to_dict()
# create an instance of BetaFeature from a dict
beta_feature_from_dict = BetaFeature.from_dict(beta_feature_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


