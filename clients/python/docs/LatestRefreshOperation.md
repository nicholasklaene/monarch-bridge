# LatestRefreshOperation

Most-recent global force-refresh request.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**state** | **str** | e.g. &#x60;IN_PROGRESS&#x60;, &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;. | [optional] 

## Example

```python
from monarch_bridge_client.models.latest_refresh_operation import LatestRefreshOperation

# TODO update the JSON string below
json = "{}"
# create an instance of LatestRefreshOperation from a JSON string
latest_refresh_operation_instance = LatestRefreshOperation.from_json(json)
# print the JSON string representation of the object
print(LatestRefreshOperation.to_json())

# convert the object into a dict
latest_refresh_operation_dict = latest_refresh_operation_instance.to_dict()
# create an instance of LatestRefreshOperation from a dict
latest_refresh_operation_from_dict = LatestRefreshOperation.from_dict(latest_refresh_operation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


