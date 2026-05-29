# SavingsRateMonth


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**month** | **str** |  | [optional] 
**savings_rate** | **float** |  | [optional] 
**income** | **float** |  | [optional] 
**expense** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.savings_rate_month import SavingsRateMonth

# TODO update the JSON string below
json = "{}"
# create an instance of SavingsRateMonth from a JSON string
savings_rate_month_instance = SavingsRateMonth.from_json(json)
# print the JSON string representation of the object
print(SavingsRateMonth.to_json())

# convert the object into a dict
savings_rate_month_dict = savings_rate_month_instance.to_dict()
# create an instance of SavingsRateMonth from a dict
savings_rate_month_from_dict = SavingsRateMonth.from_dict(savings_rate_month_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


