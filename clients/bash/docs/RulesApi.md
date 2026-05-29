# RulesApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTransactionRule**](RulesApi.md#createTransactionRule) | **POST** /v1/transaction-rules | Create a transaction rule
[**deleteTransactionRule**](RulesApi.md#deleteTransactionRule) | **DELETE** /v1/transaction-rules/{id} | Delete a transaction rule
[**listTransactionRules**](RulesApi.md#listTransactionRules) | **GET** /v1/transaction-rules | List all transaction rules
[**previewTransactionRule**](RulesApi.md#previewTransactionRule) | **POST** /v1/transaction-rules/preview | Preview transactions a rule would match (dry-run, no persistence)
[**updateTransactionRule**](RulesApi.md#updateTransactionRule) | **PATCH** /v1/transaction-rules/{id} | Update a transaction rule



## createTransactionRule

Create a transaction rule

Persists a new auto-categorization rule. Criteria and actions are
both partial: omit any field to leave it unset (e.g. omit
'merchantName' to match on amount-range only).

Criteria support: merchant name, amount range, account, current
category. Actions support: set category, add tags, set merchant
name, hide from reports, split. Rules apply to incoming
transactions on next sync (Monarch does not retroactively
categorize unless the user runs the rule from the UI).

To dry-run a rule shape before saving, use
'POST /v1/transaction-rules/preview' (same body, no persistence).

### Example

```bash
monarch-api createTransactionRule
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createTransactionRuleRequest** | [**CreateTransactionRuleRequest**](CreateTransactionRuleRequest.md) |  |

### Return type

[**CreateTransactionRule200Response**](CreateTransactionRule200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deleteTransactionRule

Delete a transaction rule

Removes one auto-categorization rule. **Destructive** but
non-cascading: existing transactions that the rule previously
categorized keep their assigned category (Monarch does not
re-evaluate categories on rule delete).

To temporarily disable a rule without deleting it, use
'PATCH /v1/transaction-rules/{id}' with the rule paused/disabled
in the criteria.

### Example

```bash
monarch-api deleteTransactionRule id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Transaction rule id. | [default to null]

### Return type

[**DeleteAccount200Response**](DeleteAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listTransactionRules

List all transaction rules

Auto-categorization rules. Each rule has matching criteria (merchant,
amount range, account, category, etc.) and a set of actions to apply
(set category, add tags, hide from reports, split, etc.) whenever a
transaction matches. Returned in display order.

### Example

```bash
monarch-api listTransactionRules
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**ListTransactionRules200Response**](ListTransactionRules200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## previewTransactionRule

Preview transactions a rule would match (dry-run, no persistence)

Send a tentative rule shape and get back the transactions that *would* match
it if the rule were saved, with the proposed new values (newCategory, newTags,
newName, etc.). Useful for building rules interactively without polluting your
rule set with throwaway saves.

Returns up to 30 results per call; page with 'offset' to walk the full set.

### Example

```bash
monarch-api previewTransactionRule  offset=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createTransactionRuleRequest** | [**CreateTransactionRuleRequest**](CreateTransactionRuleRequest.md) |  |
 **offset** | **integer** | Page offset. | [optional] [default to null]

### Return type

[**PreviewTransactionRule200Response**](PreviewTransactionRule200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateTransactionRule

Update a transaction rule

Replaces the criteria and actions on an existing rule.

**Gotcha**: Monarch's mutation takes the full rule shape, NOT a
partial patch. The proxy forwards exactly what you send. Omit any
sub-tree you want to clear, but be aware that omitting an array
you wanted to keep will wipe it. Fetch the current rule via
'GET /v1/transaction-rules' first if in doubt.

To dry-run a rule shape before saving use
'POST /v1/transaction-rules/preview'.

### Example

```bash
monarch-api updateTransactionRule id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Transaction rule id. | [default to null]
 **createTransactionRuleRequest** | [**CreateTransactionRuleRequest**](CreateTransactionRuleRequest.md) |  |

### Return type

[**UpdateTransactionRule200Response**](UpdateTransactionRule200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

