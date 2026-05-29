# MerchantStats


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchant_id** | **str** |  | 
**total_spend** | **float** |  | [optional] 
**transaction_count** | **int** |  | [optional] 
**average_transaction** | **float** |  | [optional] 
**first_seen** | **str** |  | [optional] 
**last_seen** | **str** |  | [optional] 
**months_active** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.merchant_stats import MerchantStats

# TODO update the JSON string below
json = "{}"
# create an instance of MerchantStats from a JSON string
merchant_stats_instance = MerchantStats.from_json(json)
# print the JSON string representation of the object
print(MerchantStats.to_json())

# convert the object into a dict
merchant_stats_dict = merchant_stats_instance.to_dict()
# create an instance of MerchantStats from a dict
merchant_stats_from_dict = MerchantStats.from_dict(merchant_stats_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


