# SecurityHistoricalPoint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | 
**return_percent** | **float** | Cumulative return from window start, as a fraction (0.05 &#x3D; 5%). | [optional] 
**value** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.security_historical_point import SecurityHistoricalPoint

# TODO update the JSON string below
json = "{}"
# create an instance of SecurityHistoricalPoint from a JSON string
security_historical_point_instance = SecurityHistoricalPoint.from_json(json)
# print the JSON string representation of the object
print(SecurityHistoricalPoint.to_json())

# convert the object into a dict
security_historical_point_dict = security_historical_point_instance.to_dict()
# create an instance of SecurityHistoricalPoint from a dict
security_historical_point_from_dict = SecurityHistoricalPoint.from_dict(security_historical_point_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


