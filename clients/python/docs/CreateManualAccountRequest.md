# CreateManualAccountRequest

Body for `POST /v1/accounts`. See `GET /v1/account-type-options` for valid type/subtype pairs.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** |  | 
**subtype** | **str** |  | 
**name** | **str** |  | 
**display_balance** | **float** |  | [optional] [default to 0.0]
**include_in_net_worth** | **bool** |  | [optional] [default to True]

## Example

```python
from monarch_bridge_client.models.create_manual_account_request import CreateManualAccountRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualAccountRequest from a JSON string
create_manual_account_request_instance = CreateManualAccountRequest.from_json(json)
# print the JSON string representation of the object
print(CreateManualAccountRequest.to_json())

# convert the object into a dict
create_manual_account_request_dict = create_manual_account_request_instance.to_dict()
# create an instance of CreateManualAccountRequest from a dict
create_manual_account_request_from_dict = CreateManualAccountRequest.from_dict(create_manual_account_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


