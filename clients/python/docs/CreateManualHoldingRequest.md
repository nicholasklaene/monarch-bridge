# CreateManualHoldingRequest

Body for `POST /v1/account/{id}/holdings`. `securityId` comes from `GET /v1/securities/search`; `quantity` is the number of shares/units. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**security_id** | **str** | Monarch security id (resolve via securities search). | 
**quantity** | **float** | Number of shares/units to record. | 

## Example

```python
from monarch_bridge_client.models.create_manual_holding_request import CreateManualHoldingRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualHoldingRequest from a JSON string
create_manual_holding_request_instance = CreateManualHoldingRequest.from_json(json)
# print the JSON string representation of the object
print(CreateManualHoldingRequest.to_json())

# convert the object into a dict
create_manual_holding_request_dict = create_manual_holding_request_instance.to_dict()
# create an instance of CreateManualHoldingRequest from a dict
create_manual_holding_request_from_dict = CreateManualHoldingRequest.from_dict(create_manual_holding_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


