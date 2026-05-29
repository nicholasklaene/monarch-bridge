# BenchmarkPoint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | [optional] 
**portfolio_return** | **float** |  | [optional] 
**benchmark_return** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.benchmark_point import BenchmarkPoint

# TODO update the JSON string below
json = "{}"
# create an instance of BenchmarkPoint from a JSON string
benchmark_point_instance = BenchmarkPoint.from_json(json)
# print the JSON string representation of the object
print(BenchmarkPoint.to_json())

# convert the object into a dict
benchmark_point_dict = benchmark_point_instance.to_dict()
# create an instance of BenchmarkPoint from a dict
benchmark_point_from_dict = BenchmarkPoint.from_dict(benchmark_point_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


