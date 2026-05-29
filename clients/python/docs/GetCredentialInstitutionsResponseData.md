# GetCredentialInstitutionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**credentials** | [**List[CredentialInstitutionRow]**](CredentialInstitutionRow.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_credential_institutions_response_data import GetCredentialInstitutionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCredentialInstitutionsResponseData from a JSON string
get_credential_institutions_response_data_instance = GetCredentialInstitutionsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCredentialInstitutionsResponseData.to_json())

# convert the object into a dict
get_credential_institutions_response_data_dict = get_credential_institutions_response_data_instance.to_dict()
# create an instance of GetCredentialInstitutionsResponseData from a dict
get_credential_institutions_response_data_from_dict = GetCredentialInstitutionsResponseData.from_dict(get_credential_institutions_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


