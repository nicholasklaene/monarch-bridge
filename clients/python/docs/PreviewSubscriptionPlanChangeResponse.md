# PreviewSubscriptionPlanChangeResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**PreviewSubscriptionPlanChangeResponseData**](PreviewSubscriptionPlanChangeResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.preview_subscription_plan_change_response import PreviewSubscriptionPlanChangeResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PreviewSubscriptionPlanChangeResponse from a JSON string
preview_subscription_plan_change_response_instance = PreviewSubscriptionPlanChangeResponse.from_json(json)
# print the JSON string representation of the object
print(PreviewSubscriptionPlanChangeResponse.to_json())

# convert the object into a dict
preview_subscription_plan_change_response_dict = preview_subscription_plan_change_response_instance.to_dict()
# create an instance of PreviewSubscriptionPlanChangeResponse from a dict
preview_subscription_plan_change_response_from_dict = PreviewSubscriptionPlanChangeResponse.from_dict(preview_subscription_plan_change_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


