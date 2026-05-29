# Institution

The financial institution (bank, broker, etc.) backing an account.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | 
**primary_color** | **str** |  | [optional] 
**url** | **str** |  | [optional] 
**plaid_institution_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.institution import Institution

# TODO update the JSON string below
json = "{}"
# create an instance of Institution from a JSON string
institution_instance = Institution.from_json(json)
# print the JSON string representation of the object
print(Institution.to_json())

# convert the object into a dict
institution_dict = institution_instance.to_dict()
# create an instance of Institution from a dict
institution_from_dict = Institution.from_dict(institution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


