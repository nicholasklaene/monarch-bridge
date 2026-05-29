# ListTaxLotsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListTaxLotsResponseData**](ListTaxLotsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_tax_lots_response import ListTaxLotsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListTaxLotsResponse from a JSON string
list_tax_lots_response_instance = ListTaxLotsResponse.from_json(json)
# print the JSON string representation of the object
print(ListTaxLotsResponse.to_json())

# convert the object into a dict
list_tax_lots_response_dict = list_tax_lots_response_instance.to_dict()
# create an instance of ListTaxLotsResponse from a dict
list_tax_lots_response_from_dict = ListTaxLotsResponse.from_dict(list_tax_lots_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


