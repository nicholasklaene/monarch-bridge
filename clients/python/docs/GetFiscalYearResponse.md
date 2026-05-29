# GetFiscalYearResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetFiscalYearResponseData**](GetFiscalYearResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_fiscal_year_response import GetFiscalYearResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetFiscalYearResponse from a JSON string
get_fiscal_year_response_instance = GetFiscalYearResponse.from_json(json)
# print the JSON string representation of the object
print(GetFiscalYearResponse.to_json())

# convert the object into a dict
get_fiscal_year_response_dict = get_fiscal_year_response_instance.to_dict()
# create an instance of GetFiscalYearResponse from a dict
get_fiscal_year_response_from_dict = GetFiscalYearResponse.from_dict(get_fiscal_year_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


