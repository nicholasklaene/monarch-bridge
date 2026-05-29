# GetPaychecksSummaryResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetPaychecksSummaryResponseData**](GetPaychecksSummaryResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_paychecks_summary_response import GetPaychecksSummaryResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetPaychecksSummaryResponse from a JSON string
get_paychecks_summary_response_instance = GetPaychecksSummaryResponse.from_json(json)
# print the JSON string representation of the object
print(GetPaychecksSummaryResponse.to_json())

# convert the object into a dict
get_paychecks_summary_response_dict = get_paychecks_summary_response_instance.to_dict()
# create an instance of GetPaychecksSummaryResponse from a dict
get_paychecks_summary_response_from_dict = GetPaychecksSummaryResponse.from_dict(get_paychecks_summary_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


