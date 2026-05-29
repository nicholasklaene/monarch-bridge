# TaxBracketEstimates


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tax_year** | **int** |  | 
**filing_status** | **str** |  | [optional] 
**estimated_agi** | **float** |  | [optional] 
**marginal_rate** | **float** |  | [optional] 
**effective_rate** | **float** |  | [optional] 
**brackets** | [**List[TaxBracket]**](TaxBracket.md) |  | 

## Example

```python
from monarch_bridge_client.models.tax_bracket_estimates import TaxBracketEstimates

# TODO update the JSON string below
json = "{}"
# create an instance of TaxBracketEstimates from a JSON string
tax_bracket_estimates_instance = TaxBracketEstimates.from_json(json)
# print the JSON string representation of the object
print(TaxBracketEstimates.to_json())

# convert the object into a dict
tax_bracket_estimates_dict = tax_bracket_estimates_instance.to_dict()
# create an instance of TaxBracketEstimates from a dict
tax_bracket_estimates_from_dict = TaxBracketEstimates.from_dict(tax_bracket_estimates_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


