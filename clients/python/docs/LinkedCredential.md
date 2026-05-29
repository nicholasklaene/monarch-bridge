# LinkedCredential

One linked data-provider credential plus its institution.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**institution_id** | **str** |  | [optional] 
**institution_name** | **str** |  | [optional] 
**institution_logo** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.linked_credential import LinkedCredential

# TODO update the JSON string below
json = "{}"
# create an instance of LinkedCredential from a JSON string
linked_credential_instance = LinkedCredential.from_json(json)
# print the JSON string representation of the object
print(LinkedCredential.to_json())

# convert the object into a dict
linked_credential_dict = linked_credential_instance.to_dict()
# create an instance of LinkedCredential from a dict
linked_credential_from_dict = LinkedCredential.from_dict(linked_credential_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


