# ResumeSubscriptionResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**resumed** | **bool** |  | [optional] 
**resumed_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.resume_subscription_response_data import ResumeSubscriptionResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ResumeSubscriptionResponseData from a JSON string
resume_subscription_response_data_instance = ResumeSubscriptionResponseData.from_json(json)
# print the JSON string representation of the object
print(ResumeSubscriptionResponseData.to_json())

# convert the object into a dict
resume_subscription_response_data_dict = resume_subscription_response_data_instance.to_dict()
# create an instance of ResumeSubscriptionResponseData from a dict
resume_subscription_response_data_from_dict = ResumeSubscriptionResponseData.from_dict(resume_subscription_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


