# SecurityDetails


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**ticker** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**type** | **str** |  | [optional] 
**current_price** | **float** |  | [optional] 
**closing_price** | **float** |  | [optional] 
**sector** | **str** |  | [optional] 
**industry** | **str** |  | [optional] 
**market_cap** | **float** |  | [optional] 
**pe_ratio** | **float** |  | [optional] 
**dividend_yield** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.security_details import SecurityDetails

# TODO update the JSON string below
json = "{}"
# create an instance of SecurityDetails from a JSON string
security_details_instance = SecurityDetails.from_json(json)
# print the JSON string representation of the object
print(SecurityDetails.to_json())

# convert the object into a dict
security_details_dict = security_details_instance.to_dict()
# create an instance of SecurityDetails from a dict
security_details_from_dict = SecurityDetails.from_dict(security_details_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


