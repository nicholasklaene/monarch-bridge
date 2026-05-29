# SplitsRequest

Replace the splits on a transaction. Sum of `amount` must equal parent transaction amount.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**split_data** | [**List[Split]**](Split.md) |  | 

## Example

```python
from monarch_bridge_client.models.splits_request import SplitsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SplitsRequest from a JSON string
splits_request_instance = SplitsRequest.from_json(json)
# print the JSON string representation of the object
print(SplitsRequest.to_json())

# convert the object into a dict
splits_request_dict = splits_request_instance.to_dict()
# create an instance of SplitsRequest from a dict
splits_request_from_dict = SplitsRequest.from_dict(splits_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


