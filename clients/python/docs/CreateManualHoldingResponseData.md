# CreateManualHoldingResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**holding_id** | **str** | Id of the newly-created holding. | 
**ticker** | **str** | Echoed back from Monarch when the security has a ticker symbol. | [optional] 

## Example

```python
from monarch_bridge_client.models.create_manual_holding_response_data import CreateManualHoldingResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualHoldingResponseData from a JSON string
create_manual_holding_response_data_instance = CreateManualHoldingResponseData.from_json(json)
# print the JSON string representation of the object
print(CreateManualHoldingResponseData.to_json())

# convert the object into a dict
create_manual_holding_response_data_dict = create_manual_holding_response_data_instance.to_dict()
# create an instance of CreateManualHoldingResponseData from a dict
create_manual_holding_response_data_from_dict = CreateManualHoldingResponseData.from_dict(create_manual_holding_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


