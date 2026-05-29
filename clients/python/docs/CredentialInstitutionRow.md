# CredentialInstitutionRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**credential_id** | **str** |  | 
**institution_id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**plaid_institution_id** | **str** |  | [optional] 
**finicity_institution_id** | **str** |  | [optional] 
**mx_institution_id** | **str** |  | [optional] 
**preferred_data_provider** | **str** |  | [optional] 
**logo** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.credential_institution_row import CredentialInstitutionRow

# TODO update the JSON string below
json = "{}"
# create an instance of CredentialInstitutionRow from a JSON string
credential_institution_row_instance = CredentialInstitutionRow.from_json(json)
# print the JSON string representation of the object
print(CredentialInstitutionRow.to_json())

# convert the object into a dict
credential_institution_row_dict = credential_institution_row_instance.to_dict()
# create an instance of CredentialInstitutionRow from a dict
credential_institution_row_from_dict = CredentialInstitutionRow.from_dict(credential_institution_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


