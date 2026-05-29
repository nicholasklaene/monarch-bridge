# UpdateHoldingRequest

Body for `PATCH /v1/holdings/{id}`. All fields optional; only non-null fields are forwarded to Monarch. Pass `userCostBasis` to override the data-provider basis for display purposes (stored separately from any synced basis). 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**quantity** | **float** |  | [optional] 
**security_type** | **str** | Monarch security type string (e.g. &#x60;equity&#x60;, &#x60;etf&#x60;, &#x60;cryptocurrency&#x60;). | [optional] 
**user_cost_basis** | **float** | User-provided cost basis. Stored separately from the data-provider value. | [optional] 

## Example

```python
from monarch_bridge_client.models.update_holding_request import UpdateHoldingRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateHoldingRequest from a JSON string
update_holding_request_instance = UpdateHoldingRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateHoldingRequest.to_json())

# convert the object into a dict
update_holding_request_dict = update_holding_request_instance.to_dict()
# create an instance of UpdateHoldingRequest from a dict
update_holding_request_from_dict = UpdateHoldingRequest.from_dict(update_holding_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


