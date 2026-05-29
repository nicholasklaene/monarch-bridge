# CreateManualInvestmentsAccountRequest

Body for `POST /v1/accounts/manual-investments`. Two tracking methods:    - `balances` - single account-level balance (set via `initialBalance`).   - `holdings` - per-security positions (seed via `initialHoldings`).  `trackingMethod` is optional; if omitted Monarch infers from which seed field is present. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**subtype** | **str** | Account subtype string (e.g. &#x60;401k&#x60;, &#x60;ira&#x60;, &#x60;brokerage&#x60;). | 
**tracking_method** | **str** | One of &#x60;balances&#x60;, &#x60;holdings&#x60;. Maps to Monarch&#39;s &#x60;manualInvestmentsTrackingMethod&#x60;. | [optional] 
**initial_balance** | **float** | Seed balance for balance-tracked accounts. | [optional] 
**initial_holdings** | [**List[InitialHoldingInput]**](InitialHoldingInput.md) | Seed holdings for holdings-tracked accounts. | [optional] 

## Example

```python
from monarch_bridge_client.models.create_manual_investments_account_request import CreateManualInvestmentsAccountRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualInvestmentsAccountRequest from a JSON string
create_manual_investments_account_request_instance = CreateManualInvestmentsAccountRequest.from_json(json)
# print the JSON string representation of the object
print(CreateManualInvestmentsAccountRequest.to_json())

# convert the object into a dict
create_manual_investments_account_request_dict = create_manual_investments_account_request_instance.to_dict()
# create an instance of CreateManualInvestmentsAccountRequest from a dict
create_manual_investments_account_request_from_dict = CreateManualInvestmentsAccountRequest.from_dict(create_manual_investments_account_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


