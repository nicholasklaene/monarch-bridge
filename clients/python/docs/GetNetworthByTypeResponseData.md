# GetNetworthByTypeResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**snapshots_by_account_type** | [**List[SnapshotByAccountType]**](SnapshotByAccountType.md) |  | 
**account_types** | [**List[AccountTypeReference]**](AccountTypeReference.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_networth_by_type_response_data import GetNetworthByTypeResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetNetworthByTypeResponseData from a JSON string
get_networth_by_type_response_data_instance = GetNetworthByTypeResponseData.from_json(json)
# print the JSON string representation of the object
print(GetNetworthByTypeResponseData.to_json())

# convert the object into a dict
get_networth_by_type_response_data_dict = get_networth_by_type_response_data_instance.to_dict()
# create an instance of GetNetworthByTypeResponseData from a dict
get_networth_by_type_response_data_from_dict = GetNetworthByTypeResponseData.from_dict(get_networth_by_type_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


