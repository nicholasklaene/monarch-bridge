# TaxYearOverview


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tax_year** | **int** |  | 
**total_income** | **float** |  | [optional] 
**total_deductions** | **float** |  | [optional] 
**estimated_tax** | **float** |  | [optional] 
**transaction_count** | **int** |  | [optional] 
**schedule_summaries** | [**List[TaxScheduleSummary]**](TaxScheduleSummary.md) |  | 

## Example

```python
from monarch_bridge_client.models.tax_year_overview import TaxYearOverview

# TODO update the JSON string below
json = "{}"
# create an instance of TaxYearOverview from a JSON string
tax_year_overview_instance = TaxYearOverview.from_json(json)
# print the JSON string representation of the object
print(TaxYearOverview.to_json())

# convert the object into a dict
tax_year_overview_dict = tax_year_overview_instance.to_dict()
# create an instance of TaxYearOverview from a dict
tax_year_overview_from_dict = TaxYearOverview.from_dict(tax_year_overview_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


