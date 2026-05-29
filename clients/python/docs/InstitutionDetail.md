# InstitutionDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**logo** | **str** |  | [optional] 
**new_connections_disabled** | **bool** |  | [optional] 
**has_issues_reported** | **bool** |  | [optional] 
**has_issues_reported_message** | **str** |  | [optional] 
**plaid_status** | **str** |  | [optional] 
**status** | **str** |  | [optional] 
**balance_status** | **str** |  | [optional] 
**transactions_status** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.institution_detail import InstitutionDetail

# TODO update the JSON string below
json = "{}"
# create an instance of InstitutionDetail from a JSON string
institution_detail_instance = InstitutionDetail.from_json(json)
# print the JSON string representation of the object
print(InstitutionDetail.to_json())

# convert the object into a dict
institution_detail_dict = institution_detail_instance.to_dict()
# create an instance of InstitutionDetail from a dict
institution_detail_from_dict = InstitutionDetail.from_dict(institution_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


