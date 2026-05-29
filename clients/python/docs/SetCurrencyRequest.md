# SetCurrencyRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currency** | **str** |  | 
**position** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.set_currency_request import SetCurrencyRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SetCurrencyRequest from a JSON string
set_currency_request_instance = SetCurrencyRequest.from_json(json)
# print the JSON string representation of the object
print(SetCurrencyRequest.to_json())

# convert the object into a dict
set_currency_request_dict = set_currency_request_instance.to_dict()
# create an instance of SetCurrencyRequest from a dict
set_currency_request_from_dict = SetCurrencyRequest.from_dict(set_currency_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


