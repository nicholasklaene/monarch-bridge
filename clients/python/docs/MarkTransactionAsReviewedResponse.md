# MarkTransactionAsReviewedResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MarkTransactionAsReviewedResponseData**](MarkTransactionAsReviewedResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.mark_transaction_as_reviewed_response import MarkTransactionAsReviewedResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MarkTransactionAsReviewedResponse from a JSON string
mark_transaction_as_reviewed_response_instance = MarkTransactionAsReviewedResponse.from_json(json)
# print the JSON string representation of the object
print(MarkTransactionAsReviewedResponse.to_json())

# convert the object into a dict
mark_transaction_as_reviewed_response_dict = mark_transaction_as_reviewed_response_instance.to_dict()
# create an instance of MarkTransactionAsReviewedResponse from a dict
mark_transaction_as_reviewed_response_from_dict = MarkTransactionAsReviewedResponse.from_dict(mark_transaction_as_reviewed_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


