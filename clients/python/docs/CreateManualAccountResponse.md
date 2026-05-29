# CreateManualAccountResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateManualAccountResponseData**](CreateManualAccountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_manual_account_response import CreateManualAccountResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualAccountResponse from a JSON string
create_manual_account_response_instance = CreateManualAccountResponse.from_json(json)
# print the JSON string representation of the object
print(CreateManualAccountResponse.to_json())

# convert the object into a dict
create_manual_account_response_dict = create_manual_account_response_instance.to_dict()
# create an instance of CreateManualAccountResponse from a dict
create_manual_account_response_from_dict = CreateManualAccountResponse.from_dict(create_manual_account_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


