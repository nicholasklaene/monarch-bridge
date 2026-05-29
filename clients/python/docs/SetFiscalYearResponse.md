# SetFiscalYearResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**SetFiscalYearResponseData**](SetFiscalYearResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.set_fiscal_year_response import SetFiscalYearResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SetFiscalYearResponse from a JSON string
set_fiscal_year_response_instance = SetFiscalYearResponse.from_json(json)
# print the JSON string representation of the object
print(SetFiscalYearResponse.to_json())

# convert the object into a dict
set_fiscal_year_response_dict = set_fiscal_year_response_instance.to_dict()
# create an instance of SetFiscalYearResponse from a dict
set_fiscal_year_response_from_dict = SetFiscalYearResponse.from_dict(set_fiscal_year_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


