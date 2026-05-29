# SetCurrencyResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**SetCurrencyResponseData**](SetCurrencyResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.set_currency_response import SetCurrencyResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SetCurrencyResponse from a JSON string
set_currency_response_instance = SetCurrencyResponse.from_json(json)
# print the JSON string representation of the object
print(SetCurrencyResponse.to_json())

# convert the object into a dict
set_currency_response_dict = set_currency_response_instance.to_dict()
# create an instance of SetCurrencyResponse from a dict
set_currency_response_from_dict = SetCurrencyResponse.from_dict(set_currency_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


