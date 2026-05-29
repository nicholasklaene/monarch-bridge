# FinancialInsightPlaybook


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**diy_steps** | **str** | Plain-text DIY walkthrough; markdown-flavored. | [optional] 

## Example

```python
from monarch_bridge_client.models.financial_insight_playbook import FinancialInsightPlaybook

# TODO update the JSON string below
json = "{}"
# create an instance of FinancialInsightPlaybook from a JSON string
financial_insight_playbook_instance = FinancialInsightPlaybook.from_json(json)
# print the JSON string representation of the object
print(FinancialInsightPlaybook.to_json())

# convert the object into a dict
financial_insight_playbook_dict = financial_insight_playbook_instance.to_dict()
# create an instance of FinancialInsightPlaybook from a dict
financial_insight_playbook_from_dict = FinancialInsightPlaybook.from_dict(financial_insight_playbook_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


