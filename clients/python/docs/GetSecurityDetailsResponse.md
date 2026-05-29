# GetSecurityDetailsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSecurityDetailsResponseData**](GetSecurityDetailsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_security_details_response import GetSecurityDetailsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSecurityDetailsResponse from a JSON string
get_security_details_response_instance = GetSecurityDetailsResponse.from_json(json)
# print the JSON string representation of the object
print(GetSecurityDetailsResponse.to_json())

# convert the object into a dict
get_security_details_response_dict = get_security_details_response_instance.to_dict()
# create an instance of GetSecurityDetailsResponse from a dict
get_security_details_response_from_dict = GetSecurityDetailsResponse.from_dict(get_security_details_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


