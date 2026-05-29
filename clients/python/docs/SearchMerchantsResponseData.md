# SearchMerchantsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchants** | [**List[Merchant]**](Merchant.md) |  | 

## Example

```python
from monarch_bridge_client.models.search_merchants_response_data import SearchMerchantsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of SearchMerchantsResponseData from a JSON string
search_merchants_response_data_instance = SearchMerchantsResponseData.from_json(json)
# print the JSON string representation of the object
print(SearchMerchantsResponseData.to_json())

# convert the object into a dict
search_merchants_response_data_dict = search_merchants_response_data_instance.to_dict()
# create an instance of SearchMerchantsResponseData from a dict
search_merchants_response_data_from_dict = SearchMerchantsResponseData.from_dict(search_merchants_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


