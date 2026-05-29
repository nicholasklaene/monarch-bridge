# GetFiscalYearResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fiscal_year** | [**FiscalYearPreferences**](FiscalYearPreferences.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_fiscal_year_response_data import GetFiscalYearResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetFiscalYearResponseData from a JSON string
get_fiscal_year_response_data_instance = GetFiscalYearResponseData.from_json(json)
# print the JSON string representation of the object
print(GetFiscalYearResponseData.to_json())

# convert the object into a dict
get_fiscal_year_response_data_dict = get_fiscal_year_response_data_instance.to_dict()
# create an instance of GetFiscalYearResponseData from a dict
get_fiscal_year_response_data_from_dict = GetFiscalYearResponseData.from_dict(get_fiscal_year_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


