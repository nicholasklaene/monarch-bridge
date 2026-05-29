# GetZestimateResponseDataZestimatesInner


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**zpid** | **str** |  | [optional] 
**address_street** | **str** |  | [optional] 
**address_city** | **str** |  | [optional] 
**address_state_abbr** | **str** |  | [optional] 
**address_postal_code** | **str** |  | [optional] 
**zestimate** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_zestimate_response_data_zestimates_inner import GetZestimateResponseDataZestimatesInner

# TODO update the JSON string below
json = "{}"
# create an instance of GetZestimateResponseDataZestimatesInner from a JSON string
get_zestimate_response_data_zestimates_inner_instance = GetZestimateResponseDataZestimatesInner.from_json(json)
# print the JSON string representation of the object
print(GetZestimateResponseDataZestimatesInner.to_json())

# convert the object into a dict
get_zestimate_response_data_zestimates_inner_dict = get_zestimate_response_data_zestimates_inner_instance.to_dict()
# create an instance of GetZestimateResponseDataZestimatesInner from a dict
get_zestimate_response_data_zestimates_inner_from_dict = GetZestimateResponseDataZestimatesInner.from_dict(get_zestimate_response_data_zestimates_inner_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


