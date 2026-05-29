# UpdateAccountResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | [**Account**](Account.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_account_response_data import UpdateAccountResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateAccountResponseData from a JSON string
update_account_response_data_instance = UpdateAccountResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateAccountResponseData.to_json())

# convert the object into a dict
update_account_response_data_dict = update_account_response_data_instance.to_dict()
# create an instance of UpdateAccountResponseData from a dict
update_account_response_data_from_dict = UpdateAccountResponseData.from_dict(update_account_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


