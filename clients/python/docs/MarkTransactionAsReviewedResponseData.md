# MarkTransactionAsReviewedResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**reviewed_at** | **str** | ISO timestamp when Monarch flipped the review flag. | [optional] 
**needs_review** | **bool** |  | 

## Example

```python
from monarch_bridge_client.models.mark_transaction_as_reviewed_response_data import MarkTransactionAsReviewedResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of MarkTransactionAsReviewedResponseData from a JSON string
mark_transaction_as_reviewed_response_data_instance = MarkTransactionAsReviewedResponseData.from_json(json)
# print the JSON string representation of the object
print(MarkTransactionAsReviewedResponseData.to_json())

# convert the object into a dict
mark_transaction_as_reviewed_response_data_dict = mark_transaction_as_reviewed_response_data_instance.to_dict()
# create an instance of MarkTransactionAsReviewedResponseData from a dict
mark_transaction_as_reviewed_response_data_from_dict = MarkTransactionAsReviewedResponseData.from_dict(mark_transaction_as_reviewed_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


