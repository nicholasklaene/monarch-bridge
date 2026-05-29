# GetTransactionsDuplicatesResponseDataGroupsInner


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**key** | [**DuplicateGroupKey**](DuplicateGroupKey.md) |  | 
**transactions** | [**List[Transaction]**](Transaction.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transactions_duplicates_response_data_groups_inner import GetTransactionsDuplicatesResponseDataGroupsInner

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionsDuplicatesResponseDataGroupsInner from a JSON string
get_transactions_duplicates_response_data_groups_inner_instance = GetTransactionsDuplicatesResponseDataGroupsInner.from_json(json)
# print the JSON string representation of the object
print(GetTransactionsDuplicatesResponseDataGroupsInner.to_json())

# convert the object into a dict
get_transactions_duplicates_response_data_groups_inner_dict = get_transactions_duplicates_response_data_groups_inner_instance.to_dict()
# create an instance of GetTransactionsDuplicatesResponseDataGroupsInner from a dict
get_transactions_duplicates_response_data_groups_inner_from_dict = GetTransactionsDuplicatesResponseDataGroupsInner.from_dict(get_transactions_duplicates_response_data_groups_inner_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


