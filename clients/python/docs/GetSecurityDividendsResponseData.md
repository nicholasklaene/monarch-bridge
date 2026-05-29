# GetSecurityDividendsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dividends** | [**List[SecurityDividend]**](SecurityDividend.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_security_dividends_response_data import GetSecurityDividendsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetSecurityDividendsResponseData from a JSON string
get_security_dividends_response_data_instance = GetSecurityDividendsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetSecurityDividendsResponseData.to_json())

# convert the object into a dict
get_security_dividends_response_data_dict = get_security_dividends_response_data_instance.to_dict()
# create an instance of GetSecurityDividendsResponseData from a dict
get_security_dividends_response_data_from_dict = GetSecurityDividendsResponseData.from_dict(get_security_dividends_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


