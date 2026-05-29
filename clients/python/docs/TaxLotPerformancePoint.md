# TaxLotPerformancePoint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | [optional] 
**unrealized_gains** | **float** |  | [optional] 
**return_percent** | **float** |  | [optional] 
**cost_basis** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tax_lot_performance_point import TaxLotPerformancePoint

# TODO update the JSON string below
json = "{}"
# create an instance of TaxLotPerformancePoint from a JSON string
tax_lot_performance_point_instance = TaxLotPerformancePoint.from_json(json)
# print the JSON string representation of the object
print(TaxLotPerformancePoint.to_json())

# convert the object into a dict
tax_lot_performance_point_dict = tax_lot_performance_point_instance.to_dict()
# create an instance of TaxLotPerformancePoint from a dict
tax_lot_performance_point_from_dict = TaxLotPerformancePoint.from_dict(tax_lot_performance_point_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


