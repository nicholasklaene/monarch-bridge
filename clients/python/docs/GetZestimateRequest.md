# GetZestimateRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**address** | **str** | Free-form street address (single line). | 

## Example

```python
from monarch_bridge_client.models.get_zestimate_request import GetZestimateRequest

# TODO update the JSON string below
json = "{}"
# create an instance of GetZestimateRequest from a JSON string
get_zestimate_request_instance = GetZestimateRequest.from_json(json)
# print the JSON string representation of the object
print(GetZestimateRequest.to_json())

# convert the object into a dict
get_zestimate_request_dict = get_zestimate_request_instance.to_dict()
# create an instance of GetZestimateRequest from a dict
get_zestimate_request_from_dict = GetZestimateRequest.from_dict(get_zestimate_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


