# YoyPoint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**period** | **str** |  | [optional] 
**income** | **float** |  | [optional] 
**expense** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.yoy_point import YoyPoint

# TODO update the JSON string below
json = "{}"
# create an instance of YoyPoint from a JSON string
yoy_point_instance = YoyPoint.from_json(json)
# print the JSON string representation of the object
print(YoyPoint.to_json())

# convert the object into a dict
yoy_point_dict = yoy_point_instance.to_dict()
# create an instance of YoyPoint from a dict
yoy_point_from_dict = YoyPoint.from_dict(yoy_point_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


