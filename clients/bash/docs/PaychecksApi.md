# PaychecksApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPaycheck**](PaychecksApi.md#createPaycheck) | **POST** /v1/paychecks | Record a new paycheck
[**createPaycheckEmployer**](PaychecksApi.md#createPaycheckEmployer) | **POST** /v1/paycheck-employers | Register a new employer
[**deletePaycheck**](PaychecksApi.md#deletePaycheck) | **DELETE** /v1/paychecks/{id} | Delete a paycheck
[**deletePaycheckEmployer**](PaychecksApi.md#deletePaycheckEmployer) | **DELETE** /v1/paycheck-employers/{id} | Delete an employer
[**getPaycheck**](PaychecksApi.md#getPaycheck) | **GET** /v1/paychecks/{id} | Single-paycheck full detail
[**getPaychecksSummary**](PaychecksApi.md#getPaychecksSummary) | **GET** /v1/paychecks/summary | Aggregate paycheck stats over a window
[**listPaycheckEmployers**](PaychecksApi.md#listPaycheckEmployers) | **GET** /v1/paycheck-employers | List paycheck employers
[**listPaychecks**](PaychecksApi.md#listPaychecks) | **GET** /v1/paychecks | List paychecks (with optional date + owner + employer filter)
[**updatePaycheck**](PaychecksApi.md#updatePaycheck) | **PATCH** /v1/paychecks/{id} | Partial-update a paycheck
[**updatePaycheckEmployer**](PaychecksApi.md#updatePaycheckEmployer) | **PATCH** /v1/paycheck-employers/{id} | Rename an employer



## createPaycheck

Record a new paycheck

Creates a paycheck record from scratch. Required: 'employerId',
'ownerId', 'payDate', 'gross', 'net'. Optional: 'deductions[]'
(per-line: taxes, retirement, insurance, etc.) and 'deposits[]'
(per-account splits of the net amount).

'employerId' must already exist; register it via
'POST /v1/paycheck-employers' first. Deductions and deposits can be
omitted on create and filled in later via 'PATCH /v1/paychecks/{id}'.

### Example

```bash
monarch-api createPaycheck
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createPaycheckRequest** | [**CreatePaycheckRequest**](CreatePaycheckRequest.md) |  |

### Return type

[**CreatePaycheck200Response**](CreatePaycheck200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## createPaycheckEmployer

Register a new employer

Adds an employer to the registry so it can be attached to
paycheck records. Required: 'name'. The returned id is the
'employerId' to pass when creating a paycheck via
'POST /v1/paychecks'.

Use once per employer per household member - subsequent paychecks
reference the same id.

### Example

```bash
monarch-api createPaycheckEmployer
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createPaycheckEmployerRequest** | [**CreatePaycheckEmployerRequest**](CreatePaycheckEmployerRequest.md) |  |

### Return type

[**CreatePaycheckEmployer200Response**](CreatePaycheckEmployer200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deletePaycheck

Delete a paycheck

Removes one paycheck and its deductions/deposits. **Destructive** -
drops the row, future summary calls will no longer count it.

The underlying transaction (the actual paycheck deposit on the bank
side) is not deleted by this call - only the Monarch paycheck
record that links the gross + deductions + deposit structure.

### Example

```bash
monarch-api deletePaycheck id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch paycheck id. | [default to null]

### Return type

[**DeleteAccount200Response**](DeleteAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deletePaycheckEmployer

Delete an employer

Removes an employer from the registry. **Refuses with 422** if
any paycheck records are still attributed to this employer -
reassign or delete those first.

Use to clean up stale employer entries (e.g. after switching
jobs and deleting the old paychecks). For renames use
'PATCH /v1/paycheck-employers/{id}' instead.

### Example

```bash
monarch-api deletePaycheckEmployer id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch paycheck-employer id. | [default to null]

### Return type

[**DeleteAccount200Response**](DeleteAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getPaycheck

Single-paycheck full detail

Returns the full breakdown for one paycheck: pay date, gross,
net, employer, owner (household member), per-line 'deductions'
(taxes, retirement, insurance, etc.) and per-account 'deposits'.

Use when surfacing a paycheck in a detail view or before a PATCH
to inspect current state. For the list view use
'GET /v1/paychecks'; for window-level rollups use
'GET /v1/paychecks/summary'.

### Example

```bash
monarch-api getPaycheck id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch paycheck id. | [default to null]

### Return type

[**CreatePaycheck200Response**](CreatePaycheck200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getPaychecksSummary

Aggregate paycheck stats over a window

Returns one rollup row over the filtered paycheck set: 'count',
'totalGross', 'totalDeductions', 'totalNet', 'deductionRate'
(deductions divided by gross), plus a breakdown by deduction type
(federal tax, state tax, 401k, health insurance, etc.).

Window is 'start' to 'end' inclusive on 'payDate'. Defaults to
all-time when both omitted. Optional 'employerId' scopes to one
employer; optional 'ownerIds[]' scopes to one or more household
members.

Use for YTD income/deduction dashboards or to answer \"how much have
I contributed to 401k this year\". For per-paycheck detail use
'GET /v1/paychecks'.

### Example

```bash
monarch-api getPaychecksSummary  start=value  end=value  Specify as:  ownerIds=value1 ownerIds=value2 ownerIds=...  employerId=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **ownerIds** | [**array[string]**](string.md) | Restrict to one or more household-member ids. | [optional] [default to null]
 **employerId** | **string** | Filter to one employer id. | [optional] [default to null]

### Return type

[**GetPaychecksSummary200Response**](GetPaychecksSummary200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listPaycheckEmployers

List paycheck employers

Returns the named-employer registry. Each entry is a reusable
employer id that paycheck records reference via 'employerId'.

Optional free-text 'search' matches by name (case-insensitive).
'limit' / 'offset' paginate. Use to populate an employer picker
or to resolve a name before creating a paycheck via
'POST /v1/paychecks'.

To add a new employer use 'POST /v1/paycheck-employers'; to rename
use 'PATCH /v1/paycheck-employers/{id}'.

### Example

```bash
monarch-api listPaycheckEmployers  search=value  limit=value  offset=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **search** | **string** | Free-text search against merchant / notes / category. | [optional] [default to null]
 **limit** | **integer** | Page size. | [optional] [default to null]
 **offset** | **integer** | Page offset. | [optional] [default to null]

### Return type

[**ListPaycheckEmployers200Response**](ListPaycheckEmployers200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listPaychecks

List paychecks (with optional date + owner + employer filter)

Returns paycheck records (Monarch's structured paycheck model, not
raw transactions). Each entry has 'payDate', gross, net, employer,
owner (household member), plus the deductions and deposits arrays.

Filter on 'payDate' via 'start' / 'end'; omit both for full
history. Use 'ownerId' to scope to one household member,
'employerId' to scope to one employer.

For window-level rollups use 'GET /v1/paychecks/summary'. For full
detail on one paycheck use 'GET /v1/paychecks/{id}'.

### Example

```bash
monarch-api listPaychecks  start=value  end=value  ownerId=value  employerId=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **ownerId** | **string** | Filter to one household-member id. | [optional] [default to null]
 **employerId** | **string** | Filter to one employer id. | [optional] [default to null]

### Return type

[**ListPaychecks200Response**](ListPaychecks200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updatePaycheck

Partial-update a paycheck

Patches one paycheck. Only fields present in the body are forwarded
to Monarch; omit a field to leave it untouched.

**Gotcha**: the 'deductions' and 'deposits' arrays are NOT delta
updates. When either array is present in the body it WHOLESALE
REPLACES the existing list (Monarch's 'UpdatePaycheckInput'
semantics). To add a single deduction, fetch the current list via
'GET /v1/paychecks/{id}' first then send the merged list back.

Common edits: rename via 'description', change 'payDate' if logged
on the wrong day, or fill in deductions/deposits after creating
with a bare gross+net.

### Example

```bash
monarch-api updatePaycheck id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch paycheck id. | [default to null]
 **updatePaycheckRequest** | [**UpdatePaycheckRequest**](UpdatePaycheckRequest.md) |  |

### Return type

[**CreatePaycheck200Response**](CreatePaycheck200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updatePaycheckEmployer

Rename an employer

Updates the display name on a registered employer. The new name
propagates to every paycheck record attributed to this employer
(since paychecks reference employer by id, not by name).

Required: 'name' in the request body. Use when a company rebrands
or when normalizing names imported from payroll data.

### Example

```bash
monarch-api updatePaycheckEmployer id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch paycheck-employer id. | [default to null]
 **updatePaycheckEmployerRequest** | [**UpdatePaycheckEmployerRequest**](UpdatePaycheckEmployerRequest.md) |  |

### Return type

[**CreatePaycheckEmployer200Response**](CreatePaycheckEmployer200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

