# GetExpenseByTagResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetExpenseByTagResponseData**](GetExpenseByTagResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_expense_by_tag_response import GetExpenseByTagResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetExpenseByTagResponse from a JSON string
get_expense_by_tag_response_instance = GetExpenseByTagResponse.from_json(json)
# print the JSON string representation of the object
print(GetExpenseByTagResponse.to_json())

# convert the object into a dict
get_expense_by_tag_response_dict = get_expense_by_tag_response_instance.to_dict()
# create an instance of GetExpenseByTagResponse from a dict
get_expense_by_tag_response_from_dict = GetExpenseByTagResponse.from_dict(get_expense_by_tag_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


