# InitialHoldingInput

One seed holding for a new holdings-tracked manual investments account.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**security_id** | **str** |  | 
**quantity** | **float** |  | 

## Example

```python
from monarch_bridge_client.models.initial_holding_input import InitialHoldingInput

# TODO update the JSON string below
json = "{}"
# create an instance of InitialHoldingInput from a JSON string
initial_holding_input_instance = InitialHoldingInput.from_json(json)
# print the JSON string representation of the object
print(InitialHoldingInput.to_json())

# convert the object into a dict
initial_holding_input_dict = initial_holding_input_instance.to_dict()
# create an instance of InitialHoldingInput from a dict
initial_holding_input_from_dict = InitialHoldingInput.from_dict(initial_holding_input_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


