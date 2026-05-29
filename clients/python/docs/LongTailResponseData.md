# LongTailResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**result** | **Dict[str, object]** | Raw Monarch GraphQL &#x60;data&#x60; payload, untyped. | 

## Example

```python
from monarch_bridge_client.models.long_tail_response_data import LongTailResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of LongTailResponseData from a JSON string
long_tail_response_data_instance = LongTailResponseData.from_json(json)
# print the JSON string representation of the object
print(LongTailResponseData.to_json())

# convert the object into a dict
long_tail_response_data_dict = long_tail_response_data_instance.to_dict()
# create an instance of LongTailResponseData from a dict
long_tail_response_data_from_dict = LongTailResponseData.from_dict(long_tail_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


