# UpdateAccountGroupOrderResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateAccountGroupOrderResponseData**](UpdateAccountGroupOrderResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_account_group_order_response import UpdateAccountGroupOrderResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateAccountGroupOrderResponse from a JSON string
update_account_group_order_response_instance = UpdateAccountGroupOrderResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateAccountGroupOrderResponse.to_json())

# convert the object into a dict
update_account_group_order_response_dict = update_account_group_order_response_instance.to_dict()
# create an instance of UpdateAccountGroupOrderResponse from a dict
update_account_group_order_response_from_dict = UpdateAccountGroupOrderResponse.from_dict(update_account_group_order_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


