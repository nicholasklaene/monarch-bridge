# SkippedRecurringInstance


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**stream_id** | **str** |  | 
**skipped_date** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.skipped_recurring_instance import SkippedRecurringInstance

# TODO update the JSON string below
json = "{}"
# create an instance of SkippedRecurringInstance from a JSON string
skipped_recurring_instance_instance = SkippedRecurringInstance.from_json(json)
# print the JSON string representation of the object
print(SkippedRecurringInstance.to_json())

# convert the object into a dict
skipped_recurring_instance_dict = skipped_recurring_instance_instance.to_dict()
# create an instance of SkippedRecurringInstance from a dict
skipped_recurring_instance_from_dict = SkippedRecurringInstance.from_dict(skipped_recurring_instance_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


