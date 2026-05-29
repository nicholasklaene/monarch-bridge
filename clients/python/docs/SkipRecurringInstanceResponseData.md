# SkipRecurringInstanceResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instance** | [**SkippedRecurringInstance**](SkippedRecurringInstance.md) |  | 

## Example

```python
from monarch_bridge_client.models.skip_recurring_instance_response_data import SkipRecurringInstanceResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of SkipRecurringInstanceResponseData from a JSON string
skip_recurring_instance_response_data_instance = SkipRecurringInstanceResponseData.from_json(json)
# print the JSON string representation of the object
print(SkipRecurringInstanceResponseData.to_json())

# convert the object into a dict
skip_recurring_instance_response_data_dict = skip_recurring_instance_response_data_instance.to_dict()
# create an instance of SkipRecurringInstanceResponseData from a dict
skip_recurring_instance_response_data_from_dict = SkipRecurringInstanceResponseData.from_dict(skip_recurring_instance_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


