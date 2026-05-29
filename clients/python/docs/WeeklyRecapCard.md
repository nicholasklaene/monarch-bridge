# WeeklyRecapCard

One module-specific card within a weekly recap (cashflow, biggest spend, etc.).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**module** | **str** | Card module identifier (e.g. &#x60;cashflow&#x60;, &#x60;top_categories&#x60;). | 
**title** | **str** |  | [optional] 
**headline** | **str** |  | [optional] 
**message** | **str** |  | [optional] 
**sentiment** | **str** | Monarch&#39;s tone tag (e.g. &#x60;positive&#x60;, &#x60;neutral&#x60;, &#x60;warning&#x60;). | [optional] 
**title_markdown** | **str** |  | [optional] 
**headline_markdown** | **str** |  | [optional] 
**message_markdown** | **str** |  | [optional] 
**metrics** | **Dict[str, object]** | Free-form numeric metrics rendered inside the card. | [optional] 
**rich_blocks** | **Dict[str, object]** | Free-form rich-text block tree. | [optional] 

## Example

```python
from monarch_bridge_client.models.weekly_recap_card import WeeklyRecapCard

# TODO update the JSON string below
json = "{}"
# create an instance of WeeklyRecapCard from a JSON string
weekly_recap_card_instance = WeeklyRecapCard.from_json(json)
# print the JSON string representation of the object
print(WeeklyRecapCard.to_json())

# convert the object into a dict
weekly_recap_card_dict = weekly_recap_card_instance.to_dict()
# create an instance of WeeklyRecapCard from a dict
weekly_recap_card_from_dict = WeeklyRecapCard.from_dict(weekly_recap_card_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


