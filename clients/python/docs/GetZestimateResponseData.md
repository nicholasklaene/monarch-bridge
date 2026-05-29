# GetZestimateResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**zestimates** | [**List[GetZestimateResponseDataZestimatesInner]**](GetZestimateResponseDataZestimatesInner.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_zestimate_response_data import GetZestimateResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetZestimateResponseData from a JSON string
get_zestimate_response_data_instance = GetZestimateResponseData.from_json(json)
# print the JSON string representation of the object
print(GetZestimateResponseData.to_json())

# convert the object into a dict
get_zestimate_response_data_dict = get_zestimate_response_data_instance.to_dict()
# create an instance of GetZestimateResponseData from a dict
get_zestimate_response_data_from_dict = GetZestimateResponseData.from_dict(get_zestimate_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


