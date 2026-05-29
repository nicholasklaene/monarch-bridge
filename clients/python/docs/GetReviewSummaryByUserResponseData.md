# GetReviewSummaryByUserResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rows** | [**List[ReviewSummaryByUserRow]**](ReviewSummaryByUserRow.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_review_summary_by_user_response_data import GetReviewSummaryByUserResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetReviewSummaryByUserResponseData from a JSON string
get_review_summary_by_user_response_data_instance = GetReviewSummaryByUserResponseData.from_json(json)
# print the JSON string representation of the object
print(GetReviewSummaryByUserResponseData.to_json())

# convert the object into a dict
get_review_summary_by_user_response_data_dict = get_review_summary_by_user_response_data_instance.to_dict()
# create an instance of GetReviewSummaryByUserResponseData from a dict
get_review_summary_by_user_response_data_from_dict = GetReviewSummaryByUserResponseData.from_dict(get_review_summary_by_user_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


