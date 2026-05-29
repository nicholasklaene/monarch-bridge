# MerchantRecurringStream

Recurring-transaction stream associated with a merchant; null when none.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**frequency** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**base_date** | **str** | ISO date &#x60;YYYY-MM-DD&#x60;. | [optional] 
**is_active** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.merchant_recurring_stream import MerchantRecurringStream

# TODO update the JSON string below
json = "{}"
# create an instance of MerchantRecurringStream from a JSON string
merchant_recurring_stream_instance = MerchantRecurringStream.from_json(json)
# print the JSON string representation of the object
print(MerchantRecurringStream.to_json())

# convert the object into a dict
merchant_recurring_stream_dict = merchant_recurring_stream_instance.to_dict()
# create an instance of MerchantRecurringStream from a dict
merchant_recurring_stream_from_dict = MerchantRecurringStream.from_dict(merchant_recurring_stream_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


