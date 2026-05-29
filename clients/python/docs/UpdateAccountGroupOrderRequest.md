# UpdateAccountGroupOrderRequest

Reorder request. `groupIds` is the new ordering - index = order.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**group_ids** | **List[str]** |  | 

## Example

```python
from monarch_bridge_client.models.update_account_group_order_request import UpdateAccountGroupOrderRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateAccountGroupOrderRequest from a JSON string
update_account_group_order_request_instance = UpdateAccountGroupOrderRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateAccountGroupOrderRequest.to_json())

# convert the object into a dict
update_account_group_order_request_dict = update_account_group_order_request_instance.to_dict()
# create an instance of UpdateAccountGroupOrderRequest from a dict
update_account_group_order_request_from_dict = UpdateAccountGroupOrderRequest.from_dict(update_account_group_order_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


