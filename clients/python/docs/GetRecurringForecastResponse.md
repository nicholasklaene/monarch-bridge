# GetRecurringForecastResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetRecurringForecastResponseData**](GetRecurringForecastResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_recurring_forecast_response import GetRecurringForecastResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetRecurringForecastResponse from a JSON string
get_recurring_forecast_response_instance = GetRecurringForecastResponse.from_json(json)
# print the JSON string representation of the object
print(GetRecurringForecastResponse.to_json())

# convert the object into a dict
get_recurring_forecast_response_dict = get_recurring_forecast_response_instance.to_dict()
# create an instance of GetRecurringForecastResponse from a dict
get_recurring_forecast_response_from_dict = GetRecurringForecastResponse.from_dict(get_recurring_forecast_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


