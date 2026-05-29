# InstitutionsResponse

Linked institution credentials + their accounts + the subscription summary. `credentials` and `accounts` are upstream free-form; clients should iterate by name. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetInstitutionsResponseData**](GetInstitutionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.institutions_response import InstitutionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of InstitutionsResponse from a JSON string
institutions_response_instance = InstitutionsResponse.from_json(json)
# print the JSON string representation of the object
print(InstitutionsResponse.to_json())

# convert the object into a dict
institutions_response_dict = institutions_response_instance.to_dict()
# create an instance of InstitutionsResponse from a dict
institutions_response_from_dict = InstitutionsResponse.from_dict(institutions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


