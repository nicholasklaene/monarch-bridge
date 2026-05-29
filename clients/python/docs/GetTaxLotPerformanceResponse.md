# GetTaxLotPerformanceResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTaxLotPerformanceResponseData**](GetTaxLotPerformanceResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_lot_performance_response import GetTaxLotPerformanceResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxLotPerformanceResponse from a JSON string
get_tax_lot_performance_response_instance = GetTaxLotPerformanceResponse.from_json(json)
# print the JSON string representation of the object
print(GetTaxLotPerformanceResponse.to_json())

# convert the object into a dict
get_tax_lot_performance_response_dict = get_tax_lot_performance_response_instance.to_dict()
# create an instance of GetTaxLotPerformanceResponse from a dict
get_tax_lot_performance_response_from_dict = GetTaxLotPerformanceResponse.from_dict(get_tax_lot_performance_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


