# GetRecurringForecastResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**forecast** | [**List[RecurringForecastEntry]**](RecurringForecastEntry.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_recurring_forecast_response_data import GetRecurringForecastResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetRecurringForecastResponseData from a JSON string
get_recurring_forecast_response_data_instance = GetRecurringForecastResponseData.from_json(json)
# print the JSON string representation of the object
print(GetRecurringForecastResponseData.to_json())

# convert the object into a dict
get_recurring_forecast_response_data_dict = get_recurring_forecast_response_data_instance.to_dict()
# create an instance of GetRecurringForecastResponseData from a dict
get_recurring_forecast_response_data_from_dict = GetRecurringForecastResponseData.from_dict(get_recurring_forecast_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


