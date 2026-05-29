# GetCredentialInstitutionsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCredentialInstitutionsResponseData**](GetCredentialInstitutionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_credential_institutions_response import GetCredentialInstitutionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCredentialInstitutionsResponse from a JSON string
get_credential_institutions_response_instance = GetCredentialInstitutionsResponse.from_json(json)
# print the JSON string representation of the object
print(GetCredentialInstitutionsResponse.to_json())

# convert the object into a dict
get_credential_institutions_response_dict = get_credential_institutions_response_instance.to_dict()
# create an instance of GetCredentialInstitutionsResponse from a dict
get_credential_institutions_response_from_dict = GetCredentialInstitutionsResponse.from_dict(get_credential_institutions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


