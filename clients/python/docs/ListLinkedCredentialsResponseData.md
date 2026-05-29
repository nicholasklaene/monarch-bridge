# ListLinkedCredentialsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**credentials** | [**List[LinkedCredential]**](LinkedCredential.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_linked_credentials_response_data import ListLinkedCredentialsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListLinkedCredentialsResponseData from a JSON string
list_linked_credentials_response_data_instance = ListLinkedCredentialsResponseData.from_json(json)
# print the JSON string representation of the object
print(ListLinkedCredentialsResponseData.to_json())

# convert the object into a dict
list_linked_credentials_response_data_dict = list_linked_credentials_response_data_instance.to_dict()
# create an instance of ListLinkedCredentialsResponseData from a dict
list_linked_credentials_response_data_from_dict = ListLinkedCredentialsResponseData.from_dict(list_linked_credentials_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


