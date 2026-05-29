# MerchantAggregateRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchant_id** | **str** |  | 
**merchant_name** | **str** |  | [optional] 
**total_amount** | **float** |  | [optional] 
**transaction_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.merchant_aggregate_row import MerchantAggregateRow

# TODO update the JSON string below
json = "{}"
# create an instance of MerchantAggregateRow from a JSON string
merchant_aggregate_row_instance = MerchantAggregateRow.from_json(json)
# print the JSON string representation of the object
print(MerchantAggregateRow.to_json())

# convert the object into a dict
merchant_aggregate_row_dict = merchant_aggregate_row_instance.to_dict()
# create an instance of MerchantAggregateRow from a dict
merchant_aggregate_row_from_dict = MerchantAggregateRow.from_dict(merchant_aggregate_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


