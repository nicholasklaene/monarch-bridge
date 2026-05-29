# GetTaxBracketEstimatesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTaxBracketEstimatesResponseData**](GetTaxBracketEstimatesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_bracket_estimates_response import GetTaxBracketEstimatesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxBracketEstimatesResponse from a JSON string
get_tax_bracket_estimates_response_instance = GetTaxBracketEstimatesResponse.from_json(json)
# print the JSON string representation of the object
print(GetTaxBracketEstimatesResponse.to_json())

# convert the object into a dict
get_tax_bracket_estimates_response_dict = get_tax_bracket_estimates_response_instance.to_dict()
# create an instance of GetTaxBracketEstimatesResponse from a dict
get_tax_bracket_estimates_response_from_dict = GetTaxBracketEstimatesResponse.from_dict(get_tax_bracket_estimates_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


