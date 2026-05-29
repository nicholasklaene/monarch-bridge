# GetSubscriptionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**SubscriptionDetails**](SubscriptionDetails.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_subscription_response import GetSubscriptionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubscriptionResponse from a JSON string
get_subscription_response_instance = GetSubscriptionResponse.from_json(json)
# print the JSON string representation of the object
print(GetSubscriptionResponse.to_json())

# convert the object into a dict
get_subscription_response_dict = get_subscription_response_instance.to_dict()
# create an instance of GetSubscriptionResponse from a dict
get_subscription_response_from_dict = GetSubscriptionResponse.from_dict(get_subscription_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


