# UpdateMerchantRecurrenceResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchant** | **Dict[str, object]** | Updated merchant with recurrence stream. | [optional] 

## Example

```python
from monarch_bridge_client.models.update_merchant_recurrence_response_data import UpdateMerchantRecurrenceResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateMerchantRecurrenceResponseData from a JSON string
update_merchant_recurrence_response_data_instance = UpdateMerchantRecurrenceResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateMerchantRecurrenceResponseData.to_json())

# convert the object into a dict
update_merchant_recurrence_response_data_dict = update_merchant_recurrence_response_data_instance.to_dict()
# create an instance of UpdateMerchantRecurrenceResponseData from a dict
update_merchant_recurrence_response_data_from_dict = UpdateMerchantRecurrenceResponseData.from_dict(update_merchant_recurrence_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


