# GetInstitutionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**credentials** | **List[Dict[str, object]]** |  | 
**accounts** | **List[Dict[str, object]]** |  | 
**subscription** | **Dict[str, object]** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_institutions_response_data import GetInstitutionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetInstitutionsResponseData from a JSON string
get_institutions_response_data_instance = GetInstitutionsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetInstitutionsResponseData.to_json())

# convert the object into a dict
get_institutions_response_data_dict = get_institutions_response_data_instance.to_dict()
# create an instance of GetInstitutionsResponseData from a dict
get_institutions_response_data_from_dict = GetInstitutionsResponseData.from_dict(get_institutions_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


