# Merchant

A Monarch merchant. The optional `logoUrl`, `ruleCount`, `canBeDeleted`, `hasActiveRecurringStreams`, and `recurringTransactionStream` are populated by the detail-read variant (`Common_GetEditMerchant`); the search variants only fill `id`, `name`, `transactionCount`, and (with logos) `logoUrl`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**logo_url** | **str** |  | [optional] 
**transaction_count** | **int** |  | [optional] 
**rule_count** | **int** |  | [optional] 
**can_be_deleted** | **bool** |  | [optional] 
**has_active_recurring_streams** | **bool** |  | [optional] 
**recurring_transaction_stream** | [**MerchantRecurringStream**](MerchantRecurringStream.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.merchant import Merchant

# TODO update the JSON string below
json = "{}"
# create an instance of Merchant from a JSON string
merchant_instance = Merchant.from_json(json)
# print the JSON string representation of the object
print(Merchant.to_json())

# convert the object into a dict
merchant_dict = merchant_instance.to_dict()
# create an instance of Merchant from a dict
merchant_from_dict = Merchant.from_dict(merchant_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


