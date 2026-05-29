# UpdateAccountGroupOrderResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | [**List[AccountGroupOrderEntry]**](AccountGroupOrderEntry.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_account_group_order_response_data import UpdateAccountGroupOrderResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateAccountGroupOrderResponseData from a JSON string
update_account_group_order_response_data_instance = UpdateAccountGroupOrderResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateAccountGroupOrderResponseData.to_json())

# convert the object into a dict
update_account_group_order_response_data_dict = update_account_group_order_response_data_instance.to_dict()
# create an instance of UpdateAccountGroupOrderResponseData from a dict
update_account_group_order_response_data_from_dict = UpdateAccountGroupOrderResponseData.from_dict(update_account_group_order_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


