# PreviewAccountBalanceResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**display_balance_preview** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.preview_account_balance_response_data import PreviewAccountBalanceResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of PreviewAccountBalanceResponseData from a JSON string
preview_account_balance_response_data_instance = PreviewAccountBalanceResponseData.from_json(json)
# print the JSON string representation of the object
print(PreviewAccountBalanceResponseData.to_json())

# convert the object into a dict
preview_account_balance_response_data_dict = preview_account_balance_response_data_instance.to_dict()
# create an instance of PreviewAccountBalanceResponseData from a dict
preview_account_balance_response_data_from_dict = PreviewAccountBalanceResponseData.from_dict(preview_account_balance_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


