# SubscriptionInvoice

One billing-history row from Monarch's subscription system.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**var_date** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**status** | **str** | &#x60;paid&#x60;, &#x60;pending&#x60;, &#x60;failed&#x60;, &#x60;refunded&#x60;. | [optional] 
**pdf_url** | **str** |  | [optional] 
**period_start** | **str** |  | [optional] 
**period_end** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.subscription_invoice import SubscriptionInvoice

# TODO update the JSON string below
json = "{}"
# create an instance of SubscriptionInvoice from a JSON string
subscription_invoice_instance = SubscriptionInvoice.from_json(json)
# print the JSON string representation of the object
print(SubscriptionInvoice.to_json())

# convert the object into a dict
subscription_invoice_dict = subscription_invoice_instance.to_dict()
# create an instance of SubscriptionInvoice from a dict
subscription_invoice_from_dict = SubscriptionInvoice.from_dict(subscription_invoice_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


