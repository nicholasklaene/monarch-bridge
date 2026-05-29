# AccountForFilterRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**display_name** | **str** |  | [optional] 
**data_provider** | **str** |  | [optional] 
**icon** | **str** |  | [optional] 
**logo_url** | **str** |  | [optional] 
**type_name** | **str** |  | [optional] 
**type_display** | **str** |  | [optional] 
**subtype_name** | **str** |  | [optional] 
**institution_id** | **str** |  | [optional] 
**institution_logo** | **str** |  | [optional] 
**institution_primary_color** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.account_for_filter_row import AccountForFilterRow

# TODO update the JSON string below
json = "{}"
# create an instance of AccountForFilterRow from a JSON string
account_for_filter_row_instance = AccountForFilterRow.from_json(json)
# print the JSON string representation of the object
print(AccountForFilterRow.to_json())

# convert the object into a dict
account_for_filter_row_dict = account_for_filter_row_instance.to_dict()
# create an instance of AccountForFilterRow from a dict
account_for_filter_row_from_dict = AccountForFilterRow.from_dict(account_for_filter_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


