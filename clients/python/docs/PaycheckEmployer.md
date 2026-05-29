# PaycheckEmployer

A named employer associated with one or more paychecks.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**paycheck_count** | **int** | Number of paychecks currently attributed to this employer. | [optional] 
**created_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paycheck_employer import PaycheckEmployer

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckEmployer from a JSON string
paycheck_employer_instance = PaycheckEmployer.from_json(json)
# print the JSON string representation of the object
print(PaycheckEmployer.to_json())

# convert the object into a dict
paycheck_employer_dict = paycheck_employer_instance.to_dict()
# create an instance of PaycheckEmployer from a dict
paycheck_employer_from_dict = PaycheckEmployer.from_dict(paycheck_employer_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


