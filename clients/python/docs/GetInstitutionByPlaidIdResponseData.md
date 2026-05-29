# GetInstitutionByPlaidIdResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**institution** | [**InstitutionDetail**](InstitutionDetail.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_institution_by_plaid_id_response_data import GetInstitutionByPlaidIdResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetInstitutionByPlaidIdResponseData from a JSON string
get_institution_by_plaid_id_response_data_instance = GetInstitutionByPlaidIdResponseData.from_json(json)
# print the JSON string representation of the object
print(GetInstitutionByPlaidIdResponseData.to_json())

# convert the object into a dict
get_institution_by_plaid_id_response_data_dict = get_institution_by_plaid_id_response_data_instance.to_dict()
# create an instance of GetInstitutionByPlaidIdResponseData from a dict
get_institution_by_plaid_id_response_data_from_dict = GetInstitutionByPlaidIdResponseData.from_dict(get_institution_by_plaid_id_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


