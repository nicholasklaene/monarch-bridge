# CashflowDayPoint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**day** | **date** |  | 
**sum_expense** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cashflow_day_point import CashflowDayPoint

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowDayPoint from a JSON string
cashflow_day_point_instance = CashflowDayPoint.from_json(json)
# print the JSON string representation of the object
print(CashflowDayPoint.to_json())

# convert the object into a dict
cashflow_day_point_dict = cashflow_day_point_instance.to_dict()
# create an instance of CashflowDayPoint from a dict
cashflow_day_point_from_dict = CashflowDayPoint.from_dict(cashflow_day_point_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


