# AccountTypeReference

Reference entry naming an account type that appears in the by-type series.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**display** | **str** |  | [optional] 
**group** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.account_type_reference import AccountTypeReference

# TODO update the JSON string below
json = "{}"
# create an instance of AccountTypeReference from a JSON string
account_type_reference_instance = AccountTypeReference.from_json(json)
# print the JSON string representation of the object
print(AccountTypeReference.to_json())

# convert the object into a dict
account_type_reference_dict = account_type_reference_instance.to_dict()
# create an instance of AccountTypeReference from a dict
account_type_reference_from_dict = AccountTypeReference.from_dict(account_type_reference_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


