# CashflowMerchantRef


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**logo_url** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cashflow_merchant_ref import CashflowMerchantRef

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowMerchantRef from a JSON string
cashflow_merchant_ref_instance = CashflowMerchantRef.from_json(json)
# print the JSON string representation of the object
print(CashflowMerchantRef.to_json())

# convert the object into a dict
cashflow_merchant_ref_dict = cashflow_merchant_ref_instance.to_dict()
# create an instance of CashflowMerchantRef from a dict
cashflow_merchant_ref_from_dict = CashflowMerchantRef.from_dict(cashflow_merchant_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


