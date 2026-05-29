# GetZestimateResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetZestimateResponseData**](GetZestimateResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_zestimate_response import GetZestimateResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetZestimateResponse from a JSON string
get_zestimate_response_instance = GetZestimateResponse.from_json(json)
# print the JSON string representation of the object
print(GetZestimateResponse.to_json())

# convert the object into a dict
get_zestimate_response_dict = get_zestimate_response_instance.to_dict()
# create an instance of GetZestimateResponse from a dict
get_zestimate_response_from_dict = GetZestimateResponse.from_dict(get_zestimate_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


