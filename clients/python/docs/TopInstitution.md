# TopInstitution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**logo** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.top_institution import TopInstitution

# TODO update the JSON string below
json = "{}"
# create an instance of TopInstitution from a JSON string
top_institution_instance = TopInstitution.from_json(json)
# print the JSON string representation of the object
print(TopInstitution.to_json())

# convert the object into a dict
top_institution_dict = top_institution_instance.to_dict()
# create an instance of TopInstitution from a dict
top_institution_from_dict = TopInstitution.from_dict(top_institution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


