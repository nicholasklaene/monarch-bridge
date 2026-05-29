# SetCurrencyResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currency** | [**CurrencyPreferences**](CurrencyPreferences.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.set_currency_response_data import SetCurrencyResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of SetCurrencyResponseData from a JSON string
set_currency_response_data_instance = SetCurrencyResponseData.from_json(json)
# print the JSON string representation of the object
print(SetCurrencyResponseData.to_json())

# convert the object into a dict
set_currency_response_data_dict = set_currency_response_data_instance.to_dict()
# create an instance of SetCurrencyResponseData from a dict
set_currency_response_data_from_dict = SetCurrencyResponseData.from_dict(set_currency_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


