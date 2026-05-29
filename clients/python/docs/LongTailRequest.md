# LongTailRequest

Generic request body for `/v1/x/*` long-tail endpoints. Pass operation variables under `variables`; the proxy forwards them verbatim to Monarch as the GraphQL `variables` map. Omit for operations that take no input. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**variables** | **Dict[str, object]** | GraphQL variables map for the wrapped operation. | [optional] 

## Example

```python
from monarch_bridge_client.models.long_tail_request import LongTailRequest

# TODO update the JSON string below
json = "{}"
# create an instance of LongTailRequest from a JSON string
long_tail_request_instance = LongTailRequest.from_json(json)
# print the JSON string representation of the object
print(LongTailRequest.to_json())

# convert the object into a dict
long_tail_request_dict = long_tail_request_instance.to_dict()
# create an instance of LongTailRequest from a dict
long_tail_request_from_dict = LongTailRequest.from_dict(long_tail_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


