# CashflowTimeframeBucket


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**period** | **str** | The grouping bucket label (year/month/quarter as ISO string). | 
**savings** | **float** |  | [optional] 
**savings_rate** | **float** |  | [optional] 
**sum_income** | **float** |  | [optional] 
**sum_expense** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cashflow_timeframe_bucket import CashflowTimeframeBucket

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowTimeframeBucket from a JSON string
cashflow_timeframe_bucket_instance = CashflowTimeframeBucket.from_json(json)
# print the JSON string representation of the object
print(CashflowTimeframeBucket.to_json())

# convert the object into a dict
cashflow_timeframe_bucket_dict = cashflow_timeframe_bucket_instance.to_dict()
# create an instance of CashflowTimeframeBucket from a dict
cashflow_timeframe_bucket_from_dict = CashflowTimeframeBucket.from_dict(cashflow_timeframe_bucket_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


