# Ref

Minimal `id` + `name` reference to a related entity.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.ref import Ref

# TODO update the JSON string below
json = "{}"
# create an instance of Ref from a JSON string
ref_instance = Ref.from_json(json)
# print the JSON string representation of the object
print(Ref.to_json())

# convert the object into a dict
ref_dict = ref_instance.to_dict()
# create an instance of Ref from a dict
ref_from_dict = Ref.from_dict(ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


