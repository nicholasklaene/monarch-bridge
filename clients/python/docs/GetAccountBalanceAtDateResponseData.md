# GetAccountBalanceAtDateResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**display_balance** | **float** |  | [optional] 
**include_in_net_worth** | **bool** |  | 
**account_type** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_account_balance_at_date_response_data import GetAccountBalanceAtDateResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountBalanceAtDateResponseData from a JSON string
get_account_balance_at_date_response_data_instance = GetAccountBalanceAtDateResponseData.from_json(json)
# print the JSON string representation of the object
print(GetAccountBalanceAtDateResponseData.to_json())

# convert the object into a dict
get_account_balance_at_date_response_data_dict = get_account_balance_at_date_response_data_instance.to_dict()
# create an instance of GetAccountBalanceAtDateResponseData from a dict
get_account_balance_at_date_response_data_from_dict = GetAccountBalanceAtDateResponseData.from_dict(get_account_balance_at_date_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


