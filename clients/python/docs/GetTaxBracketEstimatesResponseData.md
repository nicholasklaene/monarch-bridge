# GetTaxBracketEstimatesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**estimates** | [**TaxBracketEstimates**](TaxBracketEstimates.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_bracket_estimates_response_data import GetTaxBracketEstimatesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxBracketEstimatesResponseData from a JSON string
get_tax_bracket_estimates_response_data_instance = GetTaxBracketEstimatesResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTaxBracketEstimatesResponseData.to_json())

# convert the object into a dict
get_tax_bracket_estimates_response_data_dict = get_tax_bracket_estimates_response_data_instance.to_dict()
# create an instance of GetTaxBracketEstimatesResponseData from a dict
get_tax_bracket_estimates_response_data_from_dict = GetTaxBracketEstimatesResponseData.from_dict(get_tax_bracket_estimates_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


