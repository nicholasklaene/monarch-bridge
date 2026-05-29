# CurrencyPreferences


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currency** | **str** |  | [optional] 
**symbol** | **str** |  | [optional] 
**position** | **str** | &#39;before&#39; or &#39;after&#39; the amount. | [optional] 

## Example

```python
from monarch_bridge_client.models.currency_preferences import CurrencyPreferences

# TODO update the JSON string below
json = "{}"
# create an instance of CurrencyPreferences from a JSON string
currency_preferences_instance = CurrencyPreferences.from_json(json)
# print the JSON string representation of the object
print(CurrencyPreferences.to_json())

# convert the object into a dict
currency_preferences_dict = currency_preferences_instance.to_dict()
# create an instance of CurrencyPreferences from a dict
currency_preferences_from_dict = CurrencyPreferences.from_dict(currency_preferences_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


