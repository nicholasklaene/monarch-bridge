# SpendingTrends


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**timeframe** | **str** |  | [optional] 
**current_period_total** | **float** |  | [optional] 
**previous_period_total** | **float** |  | [optional] 
**delta_amount** | **float** |  | [optional] 
**delta_percent** | **float** |  | [optional] 
**rising_categories** | [**List[SpendingTrendCategory]**](SpendingTrendCategory.md) |  | 
**falling_categories** | [**List[SpendingTrendCategory]**](SpendingTrendCategory.md) |  | 

## Example

```python
from monarch_bridge_client.models.spending_trends import SpendingTrends

# TODO update the JSON string below
json = "{}"
# create an instance of SpendingTrends from a JSON string
spending_trends_instance = SpendingTrends.from_json(json)
# print the JSON string representation of the object
print(SpendingTrends.to_json())

# convert the object into a dict
spending_trends_dict = spending_trends_instance.to_dict()
# create an instance of SpendingTrends from a dict
spending_trends_from_dict = SpendingTrends.from_dict(spending_trends_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


