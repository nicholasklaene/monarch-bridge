# ResumeSubscriptionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ResumeSubscriptionResponseData**](ResumeSubscriptionResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.resume_subscription_response import ResumeSubscriptionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ResumeSubscriptionResponse from a JSON string
resume_subscription_response_instance = ResumeSubscriptionResponse.from_json(json)
# print the JSON string representation of the object
print(ResumeSubscriptionResponse.to_json())

# convert the object into a dict
resume_subscription_response_dict = resume_subscription_response_instance.to_dict()
# create an instance of ResumeSubscriptionResponse from a dict
resume_subscription_response_from_dict = ResumeSubscriptionResponse.from_dict(resume_subscription_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


