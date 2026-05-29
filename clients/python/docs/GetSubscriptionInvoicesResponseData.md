# GetSubscriptionInvoicesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**invoices** | [**List[SubscriptionInvoice]**](SubscriptionInvoice.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_subscription_invoices_response_data import GetSubscriptionInvoicesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubscriptionInvoicesResponseData from a JSON string
get_subscription_invoices_response_data_instance = GetSubscriptionInvoicesResponseData.from_json(json)
# print the JSON string representation of the object
print(GetSubscriptionInvoicesResponseData.to_json())

# convert the object into a dict
get_subscription_invoices_response_data_dict = get_subscription_invoices_response_data_instance.to_dict()
# create an instance of GetSubscriptionInvoicesResponseData from a dict
get_subscription_invoices_response_data_from_dict = GetSubscriptionInvoicesResponseData.from_dict(get_subscription_invoices_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


