# NetWorthReport


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**current_net_worth** | **float** |  | [optional] 
**starting_net_worth** | **float** |  | [optional] 
**change_amount** | **float** |  | [optional] 
**change_percent** | **float** |  | [optional] 
**series** | [**List[NetWorthReportPoint]**](NetWorthReportPoint.md) |  | 

## Example

```python
from monarch_bridge_client.models.net_worth_report import NetWorthReport

# TODO update the JSON string below
json = "{}"
# create an instance of NetWorthReport from a JSON string
net_worth_report_instance = NetWorthReport.from_json(json)
# print the JSON string representation of the object
print(NetWorthReport.to_json())

# convert the object into a dict
net_worth_report_dict = net_worth_report_instance.to_dict()
# create an instance of NetWorthReport from a dict
net_worth_report_from_dict = NetWorthReport.from_dict(net_worth_report_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


