# GetExpenseByCategoryResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetExpenseByCategoryResponseData**](GetExpenseByCategoryResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_expense_by_category_response import GetExpenseByCategoryResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetExpenseByCategoryResponse from a JSON string
get_expense_by_category_response_instance = GetExpenseByCategoryResponse.from_json(json)
# print the JSON string representation of the object
print(GetExpenseByCategoryResponse.to_json())

# convert the object into a dict
get_expense_by_category_response_dict = get_expense_by_category_response_instance.to_dict()
# create an instance of GetExpenseByCategoryResponse from a dict
get_expense_by_category_response_from_dict = GetExpenseByCategoryResponse.from_dict(get_expense_by_category_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


