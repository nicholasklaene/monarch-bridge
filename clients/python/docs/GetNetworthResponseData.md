# GetNetworthResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**aggregate_snapshots** | [**List[AggregateSnapshot]**](AggregateSnapshot.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_networth_response_data import GetNetworthResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetNetworthResponseData from a JSON string
get_networth_response_data_instance = GetNetworthResponseData.from_json(json)
# print the JSON string representation of the object
print(GetNetworthResponseData.to_json())

# convert the object into a dict
get_networth_response_data_dict = get_networth_response_data_instance.to_dict()
# create an instance of GetNetworthResponseData from a dict
get_networth_response_data_from_dict = GetNetworthResponseData.from_dict(get_networth_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


