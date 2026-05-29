# Account

A Monarch account - either Plaid-linked or manually-created.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | Stable Monarch account id. | 
**display_name** | **str** |  | 
**type** | **str** | Top-level account type (e.g. &#x60;depository&#x60;, &#x60;brokerage&#x60;, &#x60;credit&#x60;). | [optional] 
**subtype** | **str** | Subtype within the type (e.g. &#x60;savings&#x60;, &#x60;401k&#x60;). | [optional] 
**mask** | **str** |  | [optional] 
**current_balance** | **float** | Last-known balance in account currency. May be negative for credit/loan. | [optional] 
**display_balance** | **float** |  | [optional] 
**is_hidden** | **bool** | Monarch&#39;s legacy hidden flag. | [optional] 
**hide_from_list** | **bool** | True if the user has hidden this account from the main list. | [optional] 
**include_in_net_worth** | **bool** |  | [optional] 
**is_asset** | **bool** |  | [optional] 
**is_manual** | **bool** | True for manually-created (non-Plaid) accounts. | [optional] 
**institution** | [**Institution**](Institution.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.account import Account

# TODO update the JSON string below
json = "{}"
# create an instance of Account from a JSON string
account_instance = Account.from_json(json)
# print the JSON string representation of the object
print(Account.to_json())

# convert the object into a dict
account_dict = account_instance.to_dict()
# create an instance of Account from a dict
account_from_dict = Account.from_dict(account_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


