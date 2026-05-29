# GetReviewSummaryByUserResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetReviewSummaryByUserResponseData**](GetReviewSummaryByUserResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_review_summary_by_user_response import GetReviewSummaryByUserResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetReviewSummaryByUserResponse from a JSON string
get_review_summary_by_user_response_instance = GetReviewSummaryByUserResponse.from_json(json)
# print the JSON string representation of the object
print(GetReviewSummaryByUserResponse.to_json())

# convert the object into a dict
get_review_summary_by_user_response_dict = get_review_summary_by_user_response_instance.to_dict()
# create an instance of GetReviewSummaryByUserResponse from a dict
get_review_summary_by_user_response_from_dict = GetReviewSummaryByUserResponse.from_dict(get_review_summary_by_user_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


