# PaycheckCreatedBy

User who entered the paycheck (matters for shared households).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paycheck_created_by import PaycheckCreatedBy

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckCreatedBy from a JSON string
paycheck_created_by_instance = PaycheckCreatedBy.from_json(json)
# print the JSON string representation of the object
print(PaycheckCreatedBy.to_json())

# convert the object into a dict
paycheck_created_by_dict = paycheck_created_by_instance.to_dict()
# create an instance of PaycheckCreatedBy from a dict
paycheck_created_by_from_dict = PaycheckCreatedBy.from_dict(paycheck_created_by_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


