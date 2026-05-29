# MerchantRef

Minimal merchant reference embedded in a transaction.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**transactions_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.merchant_ref import MerchantRef

# TODO update the JSON string below
json = "{}"
# create an instance of MerchantRef from a JSON string
merchant_ref_instance = MerchantRef.from_json(json)
# print the JSON string representation of the object
print(MerchantRef.to_json())

# convert the object into a dict
merchant_ref_dict = merchant_ref_instance.to_dict()
# create an instance of MerchantRef from a dict
merchant_ref_from_dict = MerchantRef.from_dict(merchant_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


