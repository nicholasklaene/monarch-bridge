# UpdateHouseholdPreferencesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**new_transactions_need_review** | **bool** |  | [optional] 
**uncategorized_transactions_need_review** | **bool** |  | [optional] 
**pending_transactions_can_be_edited** | **bool** |  | [optional] 
**ai_assistant_enabled** | **bool** |  | [optional] 
**llm_enrichment_enabled** | **bool** |  | [optional] 
**investment_transactions_enabled** | **bool** |  | [optional] 
**budget_apply_to_future_months_default** | **bool** |  | [optional] 
**hidden_transactions_beta_enabled** | **bool** |  | [optional] 
**collaboration_tools_enabled** | **bool** |  | [optional] 
**agg_data_sharing_enabled** | **bool** |  | [optional] 
**ai_model_training_on_user_data_enabled** | **bool** |  | [optional] 
**exclude_business_from_budget** | **bool** |  | [optional] 
**continuous_financial_monitoring_enabled** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_household_preferences_response_data import UpdateHouseholdPreferencesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateHouseholdPreferencesResponseData from a JSON string
update_household_preferences_response_data_instance = UpdateHouseholdPreferencesResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateHouseholdPreferencesResponseData.to_json())

# convert the object into a dict
update_household_preferences_response_data_dict = update_household_preferences_response_data_instance.to_dict()
# create an instance of UpdateHouseholdPreferencesResponseData from a dict
update_household_preferences_response_data_from_dict = UpdateHouseholdPreferencesResponseData.from_dict(update_household_preferences_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


