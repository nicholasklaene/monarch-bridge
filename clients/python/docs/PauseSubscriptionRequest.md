# PauseSubscriptionRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**resume_at** | **date** | When the pause should auto-resume; omit for indefinite pause. | [optional] 
**reason** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.pause_subscription_request import PauseSubscriptionRequest

# TODO update the JSON string below
json = "{}"
# create an instance of PauseSubscriptionRequest from a JSON string
pause_subscription_request_instance = PauseSubscriptionRequest.from_json(json)
# print the JSON string representation of the object
print(PauseSubscriptionRequest.to_json())

# convert the object into a dict
pause_subscription_request_dict = pause_subscription_request_instance.to_dict()
# create an instance of PauseSubscriptionRequest from a dict
pause_subscription_request_from_dict = PauseSubscriptionRequest.from_dict(pause_subscription_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


