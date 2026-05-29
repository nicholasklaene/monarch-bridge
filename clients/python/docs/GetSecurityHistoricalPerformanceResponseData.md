# GetSecurityHistoricalPerformanceResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**security** | [**SecurityHistoricalSummary**](SecurityHistoricalSummary.md) |  | 
**chart** | [**List[SecurityHistoricalPoint]**](SecurityHistoricalPoint.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_security_historical_performance_response_data import GetSecurityHistoricalPerformanceResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetSecurityHistoricalPerformanceResponseData from a JSON string
get_security_historical_performance_response_data_instance = GetSecurityHistoricalPerformanceResponseData.from_json(json)
# print the JSON string representation of the object
print(GetSecurityHistoricalPerformanceResponseData.to_json())

# convert the object into a dict
get_security_historical_performance_response_data_dict = get_security_historical_performance_response_data_instance.to_dict()
# create an instance of GetSecurityHistoricalPerformanceResponseData from a dict
get_security_historical_performance_response_data_from_dict = GetSecurityHistoricalPerformanceResponseData.from_dict(get_security_historical_performance_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


