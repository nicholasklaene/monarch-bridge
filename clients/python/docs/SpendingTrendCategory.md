# SpendingTrendCategory


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_id** | **str** |  | 
**name** | **str** |  | [optional] 
**delta_percent** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.spending_trend_category import SpendingTrendCategory

# TODO update the JSON string below
json = "{}"
# create an instance of SpendingTrendCategory from a JSON string
spending_trend_category_instance = SpendingTrendCategory.from_json(json)
# print the JSON string representation of the object
print(SpendingTrendCategory.to_json())

# convert the object into a dict
spending_trend_category_dict = spending_trend_category_instance.to_dict()
# create an instance of SpendingTrendCategory from a dict
spending_trend_category_from_dict = SpendingTrendCategory.from_dict(spending_trend_category_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


