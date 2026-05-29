# LookupEntity

One semantic-search hit returned by `/v1/lookup`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | **str** | Entity kind - one of &#x60;account&#x60;, &#x60;category&#x60;, &#x60;tag&#x60;, &#x60;merchant&#x60;, etc. | 
**name** | **str** |  | 
**icon** | **str** |  | [optional] 
**logo_url** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.lookup_entity import LookupEntity

# TODO update the JSON string below
json = "{}"
# create an instance of LookupEntity from a JSON string
lookup_entity_instance = LookupEntity.from_json(json)
# print the JSON string representation of the object
print(LookupEntity.to_json())

# convert the object into a dict
lookup_entity_dict = lookup_entity_instance.to_dict()
# create an instance of LookupEntity from a dict
lookup_entity_from_dict = LookupEntity.from_dict(lookup_entity_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


