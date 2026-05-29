# LongTailResponse

Envelope for every `/v1/x/*` long-tail endpoint. `data.result` holds the raw Monarch GraphQL `data` payload as a free-form map; clients should not pin to deep field paths since upstream shape can change. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**LongTailResponseData**](LongTailResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.long_tail_response import LongTailResponse

# TODO update the JSON string below
json = "{}"
# create an instance of LongTailResponse from a JSON string
long_tail_response_instance = LongTailResponse.from_json(json)
# print the JSON string representation of the object
print(LongTailResponse.to_json())

# convert the object into a dict
long_tail_response_dict = long_tail_response_instance.to_dict()
# create an instance of LongTailResponse from a dict
long_tail_response_from_dict = LongTailResponse.from_dict(long_tail_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


