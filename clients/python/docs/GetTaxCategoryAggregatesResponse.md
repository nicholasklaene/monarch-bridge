# GetTaxCategoryAggregatesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTaxCategoryAggregatesResponseData**](GetTaxCategoryAggregatesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_category_aggregates_response import GetTaxCategoryAggregatesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxCategoryAggregatesResponse from a JSON string
get_tax_category_aggregates_response_instance = GetTaxCategoryAggregatesResponse.from_json(json)
# print the JSON string representation of the object
print(GetTaxCategoryAggregatesResponse.to_json())

# convert the object into a dict
get_tax_category_aggregates_response_dict = get_tax_category_aggregates_response_instance.to_dict()
# create an instance of GetTaxCategoryAggregatesResponse from a dict
get_tax_category_aggregates_response_from_dict = GetTaxCategoryAggregatesResponse.from_dict(get_tax_category_aggregates_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


