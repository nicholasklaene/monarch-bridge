# CreateManualHoldingResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateManualHoldingResponseData**](CreateManualHoldingResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_manual_holding_response import CreateManualHoldingResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualHoldingResponse from a JSON string
create_manual_holding_response_instance = CreateManualHoldingResponse.from_json(json)
# print the JSON string representation of the object
print(CreateManualHoldingResponse.to_json())

# convert the object into a dict
create_manual_holding_response_dict = create_manual_holding_response_instance.to_dict()
# create an instance of CreateManualHoldingResponse from a dict
create_manual_holding_response_from_dict = CreateManualHoldingResponse.from_dict(create_manual_holding_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


