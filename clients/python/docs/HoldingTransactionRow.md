# HoldingTransactionRow

One discrete event that moved a holding (buy, sell, dividend, transfer).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**var_date** | **str** |  | [optional] 
**type** | **str** | &#x60;buy&#x60;, &#x60;sell&#x60;, &#x60;dividend&#x60;, &#x60;transfer_in&#x60;, &#x60;transfer_out&#x60;. | [optional] 
**quantity** | **float** |  | [optional] 
**price** | **float** |  | [optional] 
**amount** | **float** |  | [optional] 
**fees** | **float** |  | [optional] 
**notes** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.holding_transaction_row import HoldingTransactionRow

# TODO update the JSON string below
json = "{}"
# create an instance of HoldingTransactionRow from a JSON string
holding_transaction_row_instance = HoldingTransactionRow.from_json(json)
# print the JSON string representation of the object
print(HoldingTransactionRow.to_json())

# convert the object into a dict
holding_transaction_row_dict = holding_transaction_row_instance.to_dict()
# create an instance of HoldingTransactionRow from a dict
holding_transaction_row_from_dict = HoldingTransactionRow.from_dict(holding_transaction_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


