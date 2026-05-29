# PauseSubscriptionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**PauseSubscriptionResponseData**](PauseSubscriptionResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.pause_subscription_response import PauseSubscriptionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PauseSubscriptionResponse from a JSON string
pause_subscription_response_instance = PauseSubscriptionResponse.from_json(json)
# print the JSON string representation of the object
print(PauseSubscriptionResponse.to_json())

# convert the object into a dict
pause_subscription_response_dict = pause_subscription_response_instance.to_dict()
# create an instance of PauseSubscriptionResponse from a dict
pause_subscription_response_from_dict = PauseSubscriptionResponse.from_dict(pause_subscription_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


