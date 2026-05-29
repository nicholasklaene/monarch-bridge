# NetWorthReportPoint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | 
**balance** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.net_worth_report_point import NetWorthReportPoint

# TODO update the JSON string below
json = "{}"
# create an instance of NetWorthReportPoint from a JSON string
net_worth_report_point_instance = NetWorthReportPoint.from_json(json)
# print the JSON string representation of the object
print(NetWorthReportPoint.to_json())

# convert the object into a dict
net_worth_report_point_dict = net_worth_report_point_instance.to_dict()
# create an instance of NetWorthReportPoint from a dict
net_worth_report_point_from_dict = NetWorthReportPoint.from_dict(net_worth_report_point_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


