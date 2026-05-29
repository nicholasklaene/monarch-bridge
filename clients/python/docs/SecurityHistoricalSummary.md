# SecurityHistoricalSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**current_price** | **float** |  | [optional] 
**closing_price** | **float** |  | [optional] 
**current_price_updated_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.security_historical_summary import SecurityHistoricalSummary

# TODO update the JSON string below
json = "{}"
# create an instance of SecurityHistoricalSummary from a JSON string
security_historical_summary_instance = SecurityHistoricalSummary.from_json(json)
# print the JSON string representation of the object
print(SecurityHistoricalSummary.to_json())

# convert the object into a dict
security_historical_summary_dict = security_historical_summary_instance.to_dict()
# create an instance of SecurityHistoricalSummary from a dict
security_historical_summary_from_dict = SecurityHistoricalSummary.from_dict(security_historical_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


