# FlexExpenseRolloverPeriod


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**start_month** | **date** |  | [optional] 
**starting_balance** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.flex_expense_rollover_period import FlexExpenseRolloverPeriod

# TODO update the JSON string below
json = "{}"
# create an instance of FlexExpenseRolloverPeriod from a JSON string
flex_expense_rollover_period_instance = FlexExpenseRolloverPeriod.from_json(json)
# print the JSON string representation of the object
print(FlexExpenseRolloverPeriod.to_json())

# convert the object into a dict
flex_expense_rollover_period_dict = flex_expense_rollover_period_instance.to_dict()
# create an instance of FlexExpenseRolloverPeriod from a dict
flex_expense_rollover_period_from_dict = FlexExpenseRolloverPeriod.from_dict(flex_expense_rollover_period_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


