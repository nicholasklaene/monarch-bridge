# GetCurrencyResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCurrencyResponseData**](GetCurrencyResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_currency_response import GetCurrencyResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCurrencyResponse from a JSON string
get_currency_response_instance = GetCurrencyResponse.from_json(json)
# print the JSON string representation of the object
print(GetCurrencyResponse.to_json())

# convert the object into a dict
get_currency_response_dict = get_currency_response_instance.to_dict()
# create an instance of GetCurrencyResponse from a dict
get_currency_response_from_dict = GetCurrencyResponse.from_dict(get_currency_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


