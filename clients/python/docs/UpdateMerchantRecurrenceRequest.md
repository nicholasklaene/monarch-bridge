# UpdateMerchantRecurrenceRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** | Required by Monarch - pass current name if not changing. | 
**is_recurring** | **bool** |  | [optional] 
**frequency** | **str** |  | [optional] 
**base_date** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**is_active** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_merchant_recurrence_request import UpdateMerchantRecurrenceRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateMerchantRecurrenceRequest from a JSON string
update_merchant_recurrence_request_instance = UpdateMerchantRecurrenceRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateMerchantRecurrenceRequest.to_json())

# convert the object into a dict
update_merchant_recurrence_request_dict = update_merchant_recurrence_request_instance.to_dict()
# create an instance of UpdateMerchantRecurrenceRequest from a dict
update_merchant_recurrence_request_from_dict = UpdateMerchantRecurrenceRequest.from_dict(update_merchant_recurrence_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


