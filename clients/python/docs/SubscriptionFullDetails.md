# SubscriptionFullDetails


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tier** | **str** |  | [optional] 
**status** | **str** |  | [optional] 
**renewal_date** | **date** |  | [optional] 
**billing_frequency** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**currency** | **str** |  | [optional] 
**payment_method** | **str** |  | [optional] 
**trial_ends_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.subscription_full_details import SubscriptionFullDetails

# TODO update the JSON string below
json = "{}"
# create an instance of SubscriptionFullDetails from a JSON string
subscription_full_details_instance = SubscriptionFullDetails.from_json(json)
# print the JSON string representation of the object
print(SubscriptionFullDetails.to_json())

# convert the object into a dict
subscription_full_details_dict = subscription_full_details_instance.to_dict()
# create an instance of SubscriptionFullDetails from a dict
subscription_full_details_from_dict = SubscriptionFullDetails.from_dict(subscription_full_details_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


