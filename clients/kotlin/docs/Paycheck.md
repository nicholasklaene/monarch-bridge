
# Paycheck

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.String** |  |  |
| **payDate** | **kotlin.String** | Day the funds hit the bank, &#x60;YYYY-MM-DD&#x60;. |  |
| **grossAmount** | **kotlin.Double** | Total gross pay before deductions, in dollars. |  |
| **employer** | [**PaycheckEmployerRef**](PaycheckEmployerRef.md) | Reference to the persisted employer; null for legacy paychecks before the registry shipped. |  [optional] |
| **employerName** | **kotlin.String** | Denormalized employer label. Always present even when &#x60;employer&#x60; is null (Monarch keeps it on the row for historical paychecks).  |  [optional] |
| **payrollProvider** | **kotlin.String** | One of Monarch&#39;s &#x60;PayrollProvider&#x60; enum values (e.g. &#x60;adp&#x60;, &#x60;gusto&#x60;, &#x60;paychex&#x60;, &#x60;rippling&#x60;, &#x60;other&#x60;). Null for manually-entered paychecks.  |  [optional] |
| **payPeriodStart** | **kotlin.String** | First day of the period this paycheck covers, &#x60;YYYY-MM-DD&#x60;. |  [optional] |
| **payPeriodEnd** | **kotlin.String** | Last day of the period this paycheck covers, &#x60;YYYY-MM-DD&#x60;. |  [optional] |
| **createdAt** | **kotlin.String** |  |  [optional] |
| **isMagicImported** | **kotlin.Boolean** | True when the paycheck was auto-imported from Monarch&#39;s Magic Import. |  [optional] |
| **owner** | [**PaycheckOwner**](PaycheckOwner.md) |  |  [optional] |
| **createdBy** | [**PaycheckCreatedBy**](PaycheckCreatedBy.md) |  |  [optional] |
| **deductions** | [**kotlin.collections.List&lt;PaycheckDeduction&gt;**](PaycheckDeduction.md) |  |  [optional] |
| **deposits** | [**kotlin.collections.List&lt;PaycheckDeposit&gt;**](PaycheckDeposit.md) |  |  [optional] |



