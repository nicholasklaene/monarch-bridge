# GetSubscriptionDetailsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSubscriptionDetailsResponseData**](GetSubscriptionDetailsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_subscription_details_response import GetSubscriptionDetailsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubscriptionDetailsResponse from a JSON string
get_subscription_details_response_instance = GetSubscriptionDetailsResponse.from_json(json)
# print the JSON string representation of the object
print(GetSubscriptionDetailsResponse.to_json())

# convert the object into a dict
get_subscription_details_response_dict = get_subscription_details_response_instance.to_dict()
# create an instance of GetSubscriptionDetailsResponse from a dict
get_subscription_details_response_from_dict = GetSubscriptionDetailsResponse.from_dict(get_subscription_details_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


