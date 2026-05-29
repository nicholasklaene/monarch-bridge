# TaxBracket


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**lower_bound** | **float** |  | [optional] 
**upper_bound** | **float** |  | [optional] 
**rate** | **float** |  | [optional] 
**tax_owed** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tax_bracket import TaxBracket

# TODO update the JSON string below
json = "{}"
# create an instance of TaxBracket from a JSON string
tax_bracket_instance = TaxBracket.from_json(json)
# print the JSON string representation of the object
print(TaxBracket.to_json())

# convert the object into a dict
tax_bracket_dict = tax_bracket_instance.to_dict()
# create an instance of TaxBracket from a dict
tax_bracket_from_dict = TaxBracket.from_dict(tax_bracket_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


