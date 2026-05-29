# AggregateSnapshot

Aggregate net-worth snapshot for one day.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | [optional] 
**balance** | **float** |  | [optional] 
**assets_balance** | **float** |  | [optional] 
**liabilities_balance** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.aggregate_snapshot import AggregateSnapshot

# TODO update the JSON string below
json = "{}"
# create an instance of AggregateSnapshot from a JSON string
aggregate_snapshot_instance = AggregateSnapshot.from_json(json)
# print the JSON string representation of the object
print(AggregateSnapshot.to_json())

# convert the object into a dict
aggregate_snapshot_dict = aggregate_snapshot_instance.to_dict()
# create an instance of AggregateSnapshot from a dict
aggregate_snapshot_from_dict = AggregateSnapshot.from_dict(aggregate_snapshot_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


