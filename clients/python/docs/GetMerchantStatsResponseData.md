# GetMerchantStatsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**stats** | [**MerchantStats**](MerchantStats.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_merchant_stats_response_data import GetMerchantStatsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetMerchantStatsResponseData from a JSON string
get_merchant_stats_response_data_instance = GetMerchantStatsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetMerchantStatsResponseData.to_json())

# convert the object into a dict
get_merchant_stats_response_data_dict = get_merchant_stats_response_data_instance.to_dict()
# create an instance of GetMerchantStatsResponseData from a dict
get_merchant_stats_response_data_from_dict = GetMerchantStatsResponseData.from_dict(get_merchant_stats_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


