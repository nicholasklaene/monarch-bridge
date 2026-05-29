# SecurityHistoricalPerformanceResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSecurityHistoricalPerformanceResponseData**](GetSecurityHistoricalPerformanceResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.security_historical_performance_response import SecurityHistoricalPerformanceResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SecurityHistoricalPerformanceResponse from a JSON string
security_historical_performance_response_instance = SecurityHistoricalPerformanceResponse.from_json(json)
# print the JSON string representation of the object
print(SecurityHistoricalPerformanceResponse.to_json())

# convert the object into a dict
security_historical_performance_response_dict = security_historical_performance_response_instance.to_dict()
# create an instance of SecurityHistoricalPerformanceResponse from a dict
security_historical_performance_response_from_dict = SecurityHistoricalPerformanceResponse.from_dict(security_historical_performance_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


