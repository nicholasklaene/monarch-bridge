# SearchMerchantsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**SearchMerchantsResponseData**](SearchMerchantsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.search_merchants_response import SearchMerchantsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SearchMerchantsResponse from a JSON string
search_merchants_response_instance = SearchMerchantsResponse.from_json(json)
# print the JSON string representation of the object
print(SearchMerchantsResponse.to_json())

# convert the object into a dict
search_merchants_response_dict = search_merchants_response_instance.to_dict()
# create an instance of SearchMerchantsResponse from a dict
search_merchants_response_from_dict = SearchMerchantsResponse.from_dict(search_merchants_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


