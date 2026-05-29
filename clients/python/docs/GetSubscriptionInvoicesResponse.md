# GetSubscriptionInvoicesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSubscriptionInvoicesResponseData**](GetSubscriptionInvoicesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_subscription_invoices_response import GetSubscriptionInvoicesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubscriptionInvoicesResponse from a JSON string
get_subscription_invoices_response_instance = GetSubscriptionInvoicesResponse.from_json(json)
# print the JSON string representation of the object
print(GetSubscriptionInvoicesResponse.to_json())

# convert the object into a dict
get_subscription_invoices_response_dict = get_subscription_invoices_response_instance.to_dict()
# create an instance of GetSubscriptionInvoicesResponse from a dict
get_subscription_invoices_response_from_dict = GetSubscriptionInvoicesResponse.from_dict(get_subscription_invoices_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


