# GetSecurityDividendsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSecurityDividendsResponseData**](GetSecurityDividendsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_security_dividends_response import GetSecurityDividendsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSecurityDividendsResponse from a JSON string
get_security_dividends_response_instance = GetSecurityDividendsResponse.from_json(json)
# print the JSON string representation of the object
print(GetSecurityDividendsResponse.to_json())

# convert the object into a dict
get_security_dividends_response_dict = get_security_dividends_response_instance.to_dict()
# create an instance of GetSecurityDividendsResponse from a dict
get_security_dividends_response_from_dict = GetSecurityDividendsResponse.from_dict(get_security_dividends_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


