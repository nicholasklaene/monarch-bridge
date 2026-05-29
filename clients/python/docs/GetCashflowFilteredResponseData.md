# GetCashflowFilteredResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**summary** | [**CashflowSummary**](CashflowSummary.md) |  | [optional] 
**by_year** | [**List[CashflowTimeframeBucket]**](CashflowTimeframeBucket.md) |  | [optional] 
**by_month** | [**List[CashflowTimeframeBucket]**](CashflowTimeframeBucket.md) |  | [optional] 
**by_quarter** | [**List[CashflowTimeframeBucket]**](CashflowTimeframeBucket.md) |  | [optional] 
**by_category** | [**List[CashflowEntityCategoryRow]**](CashflowEntityCategoryRow.md) |  | [optional] 
**by_category_group** | [**List[CashflowCategoryGroupRow]**](CashflowCategoryGroupRow.md) |  | [optional] 
**by_merchant** | [**List[CashflowMerchantRow]**](CashflowMerchantRow.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_cashflow_filtered_response_data import GetCashflowFilteredResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowFilteredResponseData from a JSON string
get_cashflow_filtered_response_data_instance = GetCashflowFilteredResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCashflowFilteredResponseData.to_json())

# convert the object into a dict
get_cashflow_filtered_response_data_dict = get_cashflow_filtered_response_data_instance.to_dict()
# create an instance of GetCashflowFilteredResponseData from a dict
get_cashflow_filtered_response_data_from_dict = GetCashflowFilteredResponseData.from_dict(get_cashflow_filtered_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


