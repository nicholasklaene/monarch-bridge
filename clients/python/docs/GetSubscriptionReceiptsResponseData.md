# GetSubscriptionReceiptsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**receipts** | [**List[SubscriptionReceipt]**](SubscriptionReceipt.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_subscription_receipts_response_data import GetSubscriptionReceiptsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubscriptionReceiptsResponseData from a JSON string
get_subscription_receipts_response_data_instance = GetSubscriptionReceiptsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetSubscriptionReceiptsResponseData.to_json())

# convert the object into a dict
get_subscription_receipts_response_data_dict = get_subscription_receipts_response_data_instance.to_dict()
# create an instance of GetSubscriptionReceiptsResponseData from a dict
get_subscription_receipts_response_data_from_dict = GetSubscriptionReceiptsResponseData.from_dict(get_subscription_receipts_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


