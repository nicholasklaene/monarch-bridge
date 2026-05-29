# PauseSubscriptionResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paused** | **bool** |  | [optional] 
**paused_at** | **str** |  | [optional] 
**resume_at** | **date** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.pause_subscription_response_data import PauseSubscriptionResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of PauseSubscriptionResponseData from a JSON string
pause_subscription_response_data_instance = PauseSubscriptionResponseData.from_json(json)
# print the JSON string representation of the object
print(PauseSubscriptionResponseData.to_json())

# convert the object into a dict
pause_subscription_response_data_dict = pause_subscription_response_data_instance.to_dict()
# create an instance of PauseSubscriptionResponseData from a dict
pause_subscription_response_data_from_dict = PauseSubscriptionResponseData.from_dict(pause_subscription_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


