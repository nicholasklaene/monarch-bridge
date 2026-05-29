# PaycheckOwner

The household member who received the paycheck.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**profile_picture_url** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paycheck_owner import PaycheckOwner

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckOwner from a JSON string
paycheck_owner_instance = PaycheckOwner.from_json(json)
# print the JSON string representation of the object
print(PaycheckOwner.to_json())

# convert the object into a dict
paycheck_owner_dict = paycheck_owner_instance.to_dict()
# create an instance of PaycheckOwner from a dict
paycheck_owner_from_dict = PaycheckOwner.from_dict(paycheck_owner_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


