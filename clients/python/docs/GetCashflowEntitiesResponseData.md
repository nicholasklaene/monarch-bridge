# GetCashflowEntitiesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**by_category** | [**List[CashflowEntityCategoryRow]**](CashflowEntityCategoryRow.md) |  | 
**by_category_group** | [**List[CashflowCategoryGroupRow]**](CashflowCategoryGroupRow.md) |  | 
**by_merchant** | [**List[CashflowMerchantRow]**](CashflowMerchantRow.md) |  | 
**summary** | [**CashflowSummary**](CashflowSummary.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_cashflow_entities_response_data import GetCashflowEntitiesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowEntitiesResponseData from a JSON string
get_cashflow_entities_response_data_instance = GetCashflowEntitiesResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCashflowEntitiesResponseData.to_json())

# convert the object into a dict
get_cashflow_entities_response_data_dict = get_cashflow_entities_response_data_instance.to_dict()
# create an instance of GetCashflowEntitiesResponseData from a dict
get_cashflow_entities_response_data_from_dict = GetCashflowEntitiesResponseData.from_dict(get_cashflow_entities_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


