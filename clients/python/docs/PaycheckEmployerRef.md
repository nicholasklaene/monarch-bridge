# PaycheckEmployerRef

Minimal employer reference embedded in a paycheck.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paycheck_employer_ref import PaycheckEmployerRef

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckEmployerRef from a JSON string
paycheck_employer_ref_instance = PaycheckEmployerRef.from_json(json)
# print the JSON string representation of the object
print(PaycheckEmployerRef.to_json())

# convert the object into a dict
paycheck_employer_ref_dict = paycheck_employer_ref_instance.to_dict()
# create an instance of PaycheckEmployerRef from a dict
paycheck_employer_ref_from_dict = PaycheckEmployerRef.from_dict(paycheck_employer_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


