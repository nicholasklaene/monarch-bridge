# ReviewSummaryByUserRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**user_id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**count** | **int** |  | 

## Example

```python
from monarch_bridge_client.models.review_summary_by_user_row import ReviewSummaryByUserRow

# TODO update the JSON string below
json = "{}"
# create an instance of ReviewSummaryByUserRow from a JSON string
review_summary_by_user_row_instance = ReviewSummaryByUserRow.from_json(json)
# print the JSON string representation of the object
print(ReviewSummaryByUserRow.to_json())

# convert the object into a dict
review_summary_by_user_row_dict = review_summary_by_user_row_instance.to_dict()
# create an instance of ReviewSummaryByUserRow from a dict
review_summary_by_user_row_from_dict = ReviewSummaryByUserRow.from_dict(review_summary_by_user_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


