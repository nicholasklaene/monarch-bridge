# PreviewSubscriptionPlanChangeRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**target_tier** | **str** |  | 
**billing_frequency** | **str** | Optional: &#39;monthly&#39; or &#39;yearly&#39;. | [optional] 

## Example

```python
from monarch_bridge_client.models.preview_subscription_plan_change_request import PreviewSubscriptionPlanChangeRequest

# TODO update the JSON string below
json = "{}"
# create an instance of PreviewSubscriptionPlanChangeRequest from a JSON string
preview_subscription_plan_change_request_instance = PreviewSubscriptionPlanChangeRequest.from_json(json)
# print the JSON string representation of the object
print(PreviewSubscriptionPlanChangeRequest.to_json())

# convert the object into a dict
preview_subscription_plan_change_request_dict = preview_subscription_plan_change_request_instance.to_dict()
# create an instance of PreviewSubscriptionPlanChangeRequest from a dict
preview_subscription_plan_change_request_from_dict = PreviewSubscriptionPlanChangeRequest.from_dict(preview_subscription_plan_change_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


