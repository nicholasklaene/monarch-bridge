# SavingsRateTrendPoint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**period** | **str** |  | [optional] 
**savings_rate** | **float** |  | [optional] 
**income** | **float** |  | [optional] 
**expense** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.savings_rate_trend_point import SavingsRateTrendPoint

# TODO update the JSON string below
json = "{}"
# create an instance of SavingsRateTrendPoint from a JSON string
savings_rate_trend_point_instance = SavingsRateTrendPoint.from_json(json)
# print the JSON string representation of the object
print(SavingsRateTrendPoint.to_json())

# convert the object into a dict
savings_rate_trend_point_dict = savings_rate_trend_point_instance.to_dict()
# create an instance of SavingsRateTrendPoint from a dict
savings_rate_trend_point_from_dict = SavingsRateTrendPoint.from_dict(savings_rate_trend_point_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


