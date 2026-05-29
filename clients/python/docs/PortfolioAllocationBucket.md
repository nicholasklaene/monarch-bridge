# PortfolioAllocationBucket

One row in a portfolio allocation breakdown.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** | Bucket key (security type, account id, etc.). | 
**type_display** | **str** |  | [optional] 
**allocation_percent** | **float** |  | 
**total_value** | **float** |  | 

## Example

```python
from monarch_bridge_client.models.portfolio_allocation_bucket import PortfolioAllocationBucket

# TODO update the JSON string below
json = "{}"
# create an instance of PortfolioAllocationBucket from a JSON string
portfolio_allocation_bucket_instance = PortfolioAllocationBucket.from_json(json)
# print the JSON string representation of the object
print(PortfolioAllocationBucket.to_json())

# convert the object into a dict
portfolio_allocation_bucket_dict = portfolio_allocation_bucket_instance.to_dict()
# create an instance of PortfolioAllocationBucket from a dict
portfolio_allocation_bucket_from_dict = PortfolioAllocationBucket.from_dict(portfolio_allocation_bucket_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


