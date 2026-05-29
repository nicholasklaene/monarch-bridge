# FeatureFlag


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**enabled** | **bool** |  | [optional] 
**variant** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.feature_flag import FeatureFlag

# TODO update the JSON string below
json = "{}"
# create an instance of FeatureFlag from a JSON string
feature_flag_instance = FeatureFlag.from_json(json)
# print the JSON string representation of the object
print(FeatureFlag.to_json())

# convert the object into a dict
feature_flag_dict = feature_flag_instance.to_dict()
# create an instance of FeatureFlag from a dict
feature_flag_from_dict = FeatureFlag.from_dict(feature_flag_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


