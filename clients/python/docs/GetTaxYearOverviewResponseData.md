# GetTaxYearOverviewResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**overview** | [**TaxYearOverview**](TaxYearOverview.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_year_overview_response_data import GetTaxYearOverviewResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxYearOverviewResponseData from a JSON string
get_tax_year_overview_response_data_instance = GetTaxYearOverviewResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTaxYearOverviewResponseData.to_json())

# convert the object into a dict
get_tax_year_overview_response_data_dict = get_tax_year_overview_response_data_instance.to_dict()
# create an instance of GetTaxYearOverviewResponseData from a dict
get_tax_year_overview_response_data_from_dict = GetTaxYearOverviewResponseData.from_dict(get_tax_year_overview_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


