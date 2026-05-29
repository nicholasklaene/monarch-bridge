# GetMerchantStatsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetMerchantStatsResponseData**](GetMerchantStatsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_merchant_stats_response import GetMerchantStatsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetMerchantStatsResponse from a JSON string
get_merchant_stats_response_instance = GetMerchantStatsResponse.from_json(json)
# print the JSON string representation of the object
print(GetMerchantStatsResponse.to_json())

# convert the object into a dict
get_merchant_stats_response_dict = get_merchant_stats_response_instance.to_dict()
# create an instance of GetMerchantStatsResponse from a dict
get_merchant_stats_response_from_dict = GetMerchantStatsResponse.from_dict(get_merchant_stats_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


