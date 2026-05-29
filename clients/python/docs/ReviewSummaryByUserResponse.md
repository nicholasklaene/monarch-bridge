# ReviewSummaryByUserResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetReviewSummaryByUserResponseData**](GetReviewSummaryByUserResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.review_summary_by_user_response import ReviewSummaryByUserResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ReviewSummaryByUserResponse from a JSON string
review_summary_by_user_response_instance = ReviewSummaryByUserResponse.from_json(json)
# print the JSON string representation of the object
print(ReviewSummaryByUserResponse.to_json())

# convert the object into a dict
review_summary_by_user_response_dict = review_summary_by_user_response_instance.to_dict()
# create an instance of ReviewSummaryByUserResponse from a dict
review_summary_by_user_response_from_dict = ReviewSummaryByUserResponse.from_dict(review_summary_by_user_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


