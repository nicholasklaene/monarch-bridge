# UpdateAccountResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateAccountResponseData**](UpdateAccountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_account_response import UpdateAccountResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateAccountResponse from a JSON string
update_account_response_instance = UpdateAccountResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateAccountResponse.to_json())

# convert the object into a dict
update_account_response_dict = update_account_response_instance.to_dict()
# create an instance of UpdateAccountResponse from a dict
update_account_response_from_dict = UpdateAccountResponse.from_dict(update_account_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


