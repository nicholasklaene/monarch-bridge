# SetFiscalYearResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fiscal_year** | [**FiscalYearPreferences**](FiscalYearPreferences.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.set_fiscal_year_response_data import SetFiscalYearResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of SetFiscalYearResponseData from a JSON string
set_fiscal_year_response_data_instance = SetFiscalYearResponseData.from_json(json)
# print the JSON string representation of the object
print(SetFiscalYearResponseData.to_json())

# convert the object into a dict
set_fiscal_year_response_data_dict = set_fiscal_year_response_data_instance.to_dict()
# create an instance of SetFiscalYearResponseData from a dict
set_fiscal_year_response_data_from_dict = SetFiscalYearResponseData.from_dict(set_fiscal_year_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


