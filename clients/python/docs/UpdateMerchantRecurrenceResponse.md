# UpdateMerchantRecurrenceResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateMerchantRecurrenceResponseData**](UpdateMerchantRecurrenceResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_merchant_recurrence_response import UpdateMerchantRecurrenceResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateMerchantRecurrenceResponse from a JSON string
update_merchant_recurrence_response_instance = UpdateMerchantRecurrenceResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateMerchantRecurrenceResponse.to_json())

# convert the object into a dict
update_merchant_recurrence_response_dict = update_merchant_recurrence_response_instance.to_dict()
# create an instance of UpdateMerchantRecurrenceResponse from a dict
update_merchant_recurrence_response_from_dict = UpdateMerchantRecurrenceResponse.from_dict(update_merchant_recurrence_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


