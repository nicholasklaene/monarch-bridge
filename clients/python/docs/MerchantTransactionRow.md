# MerchantTransactionRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**var_date** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**merchant_name** | **str** |  | [optional] 
**category_name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.merchant_transaction_row import MerchantTransactionRow

# TODO update the JSON string below
json = "{}"
# create an instance of MerchantTransactionRow from a JSON string
merchant_transaction_row_instance = MerchantTransactionRow.from_json(json)
# print the JSON string representation of the object
print(MerchantTransactionRow.to_json())

# convert the object into a dict
merchant_transaction_row_dict = merchant_transaction_row_instance.to_dict()
# create an instance of MerchantTransactionRow from a dict
merchant_transaction_row_from_dict = MerchantTransactionRow.from_dict(merchant_transaction_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


