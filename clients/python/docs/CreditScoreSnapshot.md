# CreditScoreSnapshot

One Spinwheel credit-score snapshot.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**reported_date** | **date** |  | 
**score** | **int** |  | 
**user_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.credit_score_snapshot import CreditScoreSnapshot

# TODO update the JSON string below
json = "{}"
# create an instance of CreditScoreSnapshot from a JSON string
credit_score_snapshot_instance = CreditScoreSnapshot.from_json(json)
# print the JSON string representation of the object
print(CreditScoreSnapshot.to_json())

# convert the object into a dict
credit_score_snapshot_dict = credit_score_snapshot_instance.to_dict()
# create an instance of CreditScoreSnapshot from a dict
credit_score_snapshot_from_dict = CreditScoreSnapshot.from_dict(credit_score_snapshot_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


