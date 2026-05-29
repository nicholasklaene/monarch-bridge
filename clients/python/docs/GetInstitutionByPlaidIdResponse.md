# GetInstitutionByPlaidIdResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetInstitutionByPlaidIdResponseData**](GetInstitutionByPlaidIdResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_institution_by_plaid_id_response import GetInstitutionByPlaidIdResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetInstitutionByPlaidIdResponse from a JSON string
get_institution_by_plaid_id_response_instance = GetInstitutionByPlaidIdResponse.from_json(json)
# print the JSON string representation of the object
print(GetInstitutionByPlaidIdResponse.to_json())

# convert the object into a dict
get_institution_by_plaid_id_response_dict = get_institution_by_plaid_id_response_instance.to_dict()
# create an instance of GetInstitutionByPlaidIdResponse from a dict
get_institution_by_plaid_id_response_from_dict = GetInstitutionByPlaidIdResponse.from_dict(get_institution_by_plaid_id_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


