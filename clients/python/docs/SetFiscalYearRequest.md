# SetFiscalYearRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**start_month** | **int** |  | 
**start_day** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.set_fiscal_year_request import SetFiscalYearRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SetFiscalYearRequest from a JSON string
set_fiscal_year_request_instance = SetFiscalYearRequest.from_json(json)
# print the JSON string representation of the object
print(SetFiscalYearRequest.to_json())

# convert the object into a dict
set_fiscal_year_request_dict = set_fiscal_year_request_instance.to_dict()
# create an instance of SetFiscalYearRequest from a dict
set_fiscal_year_request_from_dict = SetFiscalYearRequest.from_dict(set_fiscal_year_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


