# FiscalYearPreferences


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**start_month** | **int** | 1&#x3D;January, 12&#x3D;December. | [optional] 
**start_day** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.fiscal_year_preferences import FiscalYearPreferences

# TODO update the JSON string below
json = "{}"
# create an instance of FiscalYearPreferences from a JSON string
fiscal_year_preferences_instance = FiscalYearPreferences.from_json(json)
# print the JSON string representation of the object
print(FiscalYearPreferences.to_json())

# convert the object into a dict
fiscal_year_preferences_dict = fiscal_year_preferences_instance.to_dict()
# create an instance of FiscalYearPreferences from a dict
fiscal_year_preferences_from_dict = FiscalYearPreferences.from_dict(fiscal_year_preferences_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


