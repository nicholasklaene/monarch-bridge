# TaxScheduleSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**schedule** | **str** |  | 
**total** | **float** |  | [optional] 
**line_item_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tax_schedule_summary import TaxScheduleSummary

# TODO update the JSON string below
json = "{}"
# create an instance of TaxScheduleSummary from a JSON string
tax_schedule_summary_instance = TaxScheduleSummary.from_json(json)
# print the JSON string representation of the object
print(TaxScheduleSummary.to_json())

# convert the object into a dict
tax_schedule_summary_dict = tax_schedule_summary_instance.to_dict()
# create an instance of TaxScheduleSummary from a dict
tax_schedule_summary_from_dict = TaxScheduleSummary.from_dict(tax_schedule_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


