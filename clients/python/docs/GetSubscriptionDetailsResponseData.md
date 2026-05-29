# GetSubscriptionDetailsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**details** | [**SubscriptionFullDetails**](SubscriptionFullDetails.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_subscription_details_response_data import GetSubscriptionDetailsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubscriptionDetailsResponseData from a JSON string
get_subscription_details_response_data_instance = GetSubscriptionDetailsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetSubscriptionDetailsResponseData.to_json())

# convert the object into a dict
get_subscription_details_response_data_dict = get_subscription_details_response_data_instance.to_dict()
# create an instance of GetSubscriptionDetailsResponseData from a dict
get_subscription_details_response_data_from_dict = GetSubscriptionDetailsResponseData.from_dict(get_subscription_details_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


