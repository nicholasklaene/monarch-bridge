# RecentAccountBalances

One account's recent-balance series.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**recent_balances** | **List[float]** | Most recent balances, oldest-first. | [optional] 

## Example

```python
from monarch_bridge_client.models.recent_account_balances import RecentAccountBalances

# TODO update the JSON string below
json = "{}"
# create an instance of RecentAccountBalances from a JSON string
recent_account_balances_instance = RecentAccountBalances.from_json(json)
# print the JSON string representation of the object
print(RecentAccountBalances.to_json())

# convert the object into a dict
recent_account_balances_dict = recent_account_balances_instance.to_dict()
# create an instance of RecentAccountBalances from a dict
recent_account_balances_from_dict = RecentAccountBalances.from_dict(recent_account_balances_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


