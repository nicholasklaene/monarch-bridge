# PreviewSubscriptionPlanChangeResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**prorated_charge** | **float** |  | [optional] 
**new_renewal_date** | **date** |  | [optional] 
**currency** | **str** |  | [optional] 
**summary** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.preview_subscription_plan_change_response_data import PreviewSubscriptionPlanChangeResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of PreviewSubscriptionPlanChangeResponseData from a JSON string
preview_subscription_plan_change_response_data_instance = PreviewSubscriptionPlanChangeResponseData.from_json(json)
# print the JSON string representation of the object
print(PreviewSubscriptionPlanChangeResponseData.to_json())

# convert the object into a dict
preview_subscription_plan_change_response_data_dict = preview_subscription_plan_change_response_data_instance.to_dict()
# create an instance of PreviewSubscriptionPlanChangeResponseData from a dict
preview_subscription_plan_change_response_data_from_dict = PreviewSubscriptionPlanChangeResponseData.from_dict(preview_subscription_plan_change_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


