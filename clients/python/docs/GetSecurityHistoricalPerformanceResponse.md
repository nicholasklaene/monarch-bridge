# GetSecurityHistoricalPerformanceResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSecurityHistoricalPerformanceResponseData**](GetSecurityHistoricalPerformanceResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_security_historical_performance_response import GetSecurityHistoricalPerformanceResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSecurityHistoricalPerformanceResponse from a JSON string
get_security_historical_performance_response_instance = GetSecurityHistoricalPerformanceResponse.from_json(json)
# print the JSON string representation of the object
print(GetSecurityHistoricalPerformanceResponse.to_json())

# convert the object into a dict
get_security_historical_performance_response_dict = get_security_historical_performance_response_instance.to_dict()
# create an instance of GetSecurityHistoricalPerformanceResponse from a dict
get_security_historical_performance_response_from_dict = GetSecurityHistoricalPerformanceResponse.from_dict(get_security_historical_performance_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


