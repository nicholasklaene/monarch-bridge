# ListTaxLotsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tax_lots** | [**List[TaxLot]**](TaxLot.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_tax_lots_response_data import ListTaxLotsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListTaxLotsResponseData from a JSON string
list_tax_lots_response_data_instance = ListTaxLotsResponseData.from_json(json)
# print the JSON string representation of the object
print(ListTaxLotsResponseData.to_json())

# convert the object into a dict
list_tax_lots_response_data_dict = list_tax_lots_response_data_instance.to_dict()
# create an instance of ListTaxLotsResponseData from a dict
list_tax_lots_response_data_from_dict = ListTaxLotsResponseData.from_dict(list_tax_lots_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


