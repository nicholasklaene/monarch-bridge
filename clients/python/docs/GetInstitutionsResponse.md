# GetInstitutionsResponse

Linked institution credentials + their accounts + the subscription summary. `credentials` and `accounts` are upstream free-form; clients should iterate by name. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetInstitutionsResponseData**](GetInstitutionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_institutions_response import GetInstitutionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetInstitutionsResponse from a JSON string
get_institutions_response_instance = GetInstitutionsResponse.from_json(json)
# print the JSON string representation of the object
print(GetInstitutionsResponse.to_json())

# convert the object into a dict
get_institutions_response_dict = get_institutions_response_instance.to_dict()
# create an instance of GetInstitutionsResponse from a dict
get_institutions_response_from_dict = GetInstitutionsResponse.from_dict(get_institutions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


