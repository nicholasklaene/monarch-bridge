# SearchSecuritiesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**SearchSecuritiesResponseData**](SearchSecuritiesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.search_securities_response import SearchSecuritiesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSecuritiesResponse from a JSON string
search_securities_response_instance = SearchSecuritiesResponse.from_json(json)
# print the JSON string representation of the object
print(SearchSecuritiesResponse.to_json())

# convert the object into a dict
search_securities_response_dict = search_securities_response_instance.to_dict()
# create an instance of SearchSecuritiesResponse from a dict
search_securities_response_from_dict = SearchSecuritiesResponse.from_dict(search_securities_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


