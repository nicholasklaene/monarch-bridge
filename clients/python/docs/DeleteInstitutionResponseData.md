# DeleteInstitutionResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deleted** | **bool** | True when Monarch confirms the credential was deleted. | 

## Example

```python
from monarch_bridge_client.models.delete_institution_response_data import DeleteInstitutionResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteInstitutionResponseData from a JSON string
delete_institution_response_data_instance = DeleteInstitutionResponseData.from_json(json)
# print the JSON string representation of the object
print(DeleteInstitutionResponseData.to_json())

# convert the object into a dict
delete_institution_response_data_dict = delete_institution_response_data_instance.to_dict()
# create an instance of DeleteInstitutionResponseData from a dict
delete_institution_response_data_from_dict = DeleteInstitutionResponseData.from_dict(delete_institution_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


