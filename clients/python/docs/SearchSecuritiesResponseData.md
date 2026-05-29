# SearchSecuritiesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**securities** | [**List[Security]**](Security.md) |  | 

## Example

```python
from monarch_bridge_client.models.search_securities_response_data import SearchSecuritiesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSecuritiesResponseData from a JSON string
search_securities_response_data_instance = SearchSecuritiesResponseData.from_json(json)
# print the JSON string representation of the object
print(SearchSecuritiesResponseData.to_json())

# convert the object into a dict
search_securities_response_data_dict = search_securities_response_data_instance.to_dict()
# create an instance of SearchSecuritiesResponseData from a dict
search_securities_response_data_from_dict = SearchSecuritiesResponseData.from_dict(search_securities_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


