# GetTaxYearOverviewResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTaxYearOverviewResponseData**](GetTaxYearOverviewResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_year_overview_response import GetTaxYearOverviewResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxYearOverviewResponse from a JSON string
get_tax_year_overview_response_instance = GetTaxYearOverviewResponse.from_json(json)
# print the JSON string representation of the object
print(GetTaxYearOverviewResponse.to_json())

# convert the object into a dict
get_tax_year_overview_response_dict = get_tax_year_overview_response_instance.to_dict()
# create an instance of GetTaxYearOverviewResponse from a dict
get_tax_year_overview_response_from_dict = GetTaxYearOverviewResponse.from_dict(get_tax_year_overview_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


