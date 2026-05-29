# SecurityDividend


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | 
**amount** | **float** |  | [optional] 
**type** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.security_dividend import SecurityDividend

# TODO update the JSON string below
json = "{}"
# create an instance of SecurityDividend from a JSON string
security_dividend_instance = SecurityDividend.from_json(json)
# print the JSON string representation of the object
print(SecurityDividend.to_json())

# convert the object into a dict
security_dividend_dict = security_dividend_instance.to_dict()
# create an instance of SecurityDividend from a dict
security_dividend_from_dict = SecurityDividend.from_dict(security_dividend_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


