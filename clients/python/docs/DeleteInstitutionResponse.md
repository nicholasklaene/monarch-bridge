# DeleteInstitutionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteInstitutionResponseData**](DeleteInstitutionResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_institution_response import DeleteInstitutionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteInstitutionResponse from a JSON string
delete_institution_response_instance = DeleteInstitutionResponse.from_json(json)
# print the JSON string representation of the object
print(DeleteInstitutionResponse.to_json())

# convert the object into a dict
delete_institution_response_dict = delete_institution_response_instance.to_dict()
# create an instance of DeleteInstitutionResponse from a dict
delete_institution_response_from_dict = DeleteInstitutionResponse.from_dict(delete_institution_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


