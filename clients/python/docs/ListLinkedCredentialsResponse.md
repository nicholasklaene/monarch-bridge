# ListLinkedCredentialsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListLinkedCredentialsResponseData**](ListLinkedCredentialsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_linked_credentials_response import ListLinkedCredentialsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListLinkedCredentialsResponse from a JSON string
list_linked_credentials_response_instance = ListLinkedCredentialsResponse.from_json(json)
# print the JSON string representation of the object
print(ListLinkedCredentialsResponse.to_json())

# convert the object into a dict
list_linked_credentials_response_dict = list_linked_credentials_response_instance.to_dict()
# create an instance of ListLinkedCredentialsResponse from a dict
list_linked_credentials_response_from_dict = ListLinkedCredentialsResponse.from_dict(list_linked_credentials_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


