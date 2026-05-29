# GetTaxLotPerformanceResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**holding_id** | **str** |  | [optional] 
**historical_chart** | [**List[TaxLotPerformancePoint]**](TaxLotPerformancePoint.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_tax_lot_performance_response_data import GetTaxLotPerformanceResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxLotPerformanceResponseData from a JSON string
get_tax_lot_performance_response_data_instance = GetTaxLotPerformanceResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTaxLotPerformanceResponseData.to_json())

# convert the object into a dict
get_tax_lot_performance_response_data_dict = get_tax_lot_performance_response_data_instance.to_dict()
# create an instance of GetTaxLotPerformanceResponseData from a dict
get_tax_lot_performance_response_data_from_dict = GetTaxLotPerformanceResponseData.from_dict(get_tax_lot_performance_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


