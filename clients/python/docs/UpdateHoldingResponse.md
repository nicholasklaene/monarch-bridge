# UpdateHoldingResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateHoldingResponseData**](UpdateHoldingResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_holding_response import UpdateHoldingResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateHoldingResponse from a JSON string
update_holding_response_instance = UpdateHoldingResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateHoldingResponse.to_json())

# convert the object into a dict
update_holding_response_dict = update_holding_response_instance.to_dict()
# create an instance of UpdateHoldingResponse from a dict
update_holding_response_from_dict = UpdateHoldingResponse.from_dict(update_holding_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


