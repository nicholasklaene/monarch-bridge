# UpdateTransactionRequest

Partial update - send only the fields you want to change. Path `{id}` is injected into the GraphQL input by the proxy. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | **str** | New categoryId. | [optional] 
**merchant_name** | **str** | New merchant display name. | [optional] 
**amount** | **float** |  | [optional] 
**var_date** | **str** |  | [optional] 
**notes** | **str** |  | [optional] 
**hide_from_reports** | **bool** |  | [optional] 
**needs_review** | **bool** |  | [optional] 
**reviewed** | **bool** |  | [optional] 
**goal_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_transaction_request import UpdateTransactionRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateTransactionRequest from a JSON string
update_transaction_request_instance = UpdateTransactionRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateTransactionRequest.to_json())

# convert the object into a dict
update_transaction_request_dict = update_transaction_request_instance.to_dict()
# create an instance of UpdateTransactionRequest from a dict
update_transaction_request_from_dict = UpdateTransactionRequest.from_dict(update_transaction_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


