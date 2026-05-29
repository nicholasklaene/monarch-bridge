# DuplicateGroupKey

Tuple identifying one duplicate group. Composite key over `(date, amount, plaidName, accountId)` per the python lib's `find_duplicate_transactions` semantics. Any field can be null when the source transaction omits it; null values still group together. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | [optional] 
**amount** | **float** | Signed. | [optional] 
**account_id** | **str** |  | [optional] 
**plaid_name** | **str** | Raw Plaid description string. Distinguishes true double-inserts (identical plaidName) from coincidental same-day same-amount same-merchant charges (different plaidName).  | [optional] 

## Example

```python
from monarch_bridge_client.models.duplicate_group_key import DuplicateGroupKey

# TODO update the JSON string below
json = "{}"
# create an instance of DuplicateGroupKey from a JSON string
duplicate_group_key_instance = DuplicateGroupKey.from_json(json)
# print the JSON string representation of the object
print(DuplicateGroupKey.to_json())

# convert the object into a dict
duplicate_group_key_dict = duplicate_group_key_instance.to_dict()
# create an instance of DuplicateGroupKey from a dict
duplicate_group_key_from_dict = DuplicateGroupKey.from_dict(duplicate_group_key_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


