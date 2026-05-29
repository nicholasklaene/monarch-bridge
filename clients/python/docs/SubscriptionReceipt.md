# SubscriptionReceipt


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**issue_date** | **date** |  | [optional] 
**amount** | **float** |  | [optional] 
**currency** | **str** |  | [optional] 
**download_url** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.subscription_receipt import SubscriptionReceipt

# TODO update the JSON string below
json = "{}"
# create an instance of SubscriptionReceipt from a JSON string
subscription_receipt_instance = SubscriptionReceipt.from_json(json)
# print the JSON string representation of the object
print(SubscriptionReceipt.to_json())

# convert the object into a dict
subscription_receipt_dict = subscription_receipt_instance.to_dict()
# create an instance of SubscriptionReceipt from a dict
subscription_receipt_from_dict = SubscriptionReceipt.from_dict(subscription_receipt_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


