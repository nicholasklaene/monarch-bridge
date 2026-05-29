# RecurringForecastEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | 
**amount** | **float** |  | [optional] 
**merchant_name** | **str** |  | [optional] 
**stream_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.recurring_forecast_entry import RecurringForecastEntry

# TODO update the JSON string below
json = "{}"
# create an instance of RecurringForecastEntry from a JSON string
recurring_forecast_entry_instance = RecurringForecastEntry.from_json(json)
# print the JSON string representation of the object
print(RecurringForecastEntry.to_json())

# convert the object into a dict
recurring_forecast_entry_dict = recurring_forecast_entry_instance.to_dict()
# create an instance of RecurringForecastEntry from a dict
recurring_forecast_entry_from_dict = RecurringForecastEntry.from_dict(recurring_forecast_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


