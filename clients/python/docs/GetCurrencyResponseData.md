# GetCurrencyResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currency** | [**CurrencyPreferences**](CurrencyPreferences.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_currency_response_data import GetCurrencyResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCurrencyResponseData from a JSON string
get_currency_response_data_instance = GetCurrencyResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCurrencyResponseData.to_json())

# convert the object into a dict
get_currency_response_data_dict = get_currency_response_data_instance.to_dict()
# create an instance of GetCurrencyResponseData from a dict
get_currency_response_data_from_dict = GetCurrencyResponseData.from_dict(get_currency_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


