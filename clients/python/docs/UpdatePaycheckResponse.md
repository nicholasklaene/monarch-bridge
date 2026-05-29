# UpdatePaycheckResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreatePaycheckResponseData**](CreatePaycheckResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_paycheck_response import UpdatePaycheckResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdatePaycheckResponse from a JSON string
update_paycheck_response_instance = UpdatePaycheckResponse.from_json(json)
# print the JSON string representation of the object
print(UpdatePaycheckResponse.to_json())

# convert the object into a dict
update_paycheck_response_dict = update_paycheck_response_instance.to_dict()
# create an instance of UpdatePaycheckResponse from a dict
update_paycheck_response_from_dict = UpdatePaycheckResponse.from_dict(update_paycheck_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


