# RulesApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createTransactionRule**](#createtransactionrule) | **POST** /v1/transaction-rules | Create a transaction rule|
|[**deleteTransactionRule**](#deletetransactionrule) | **DELETE** /v1/transaction-rules/{id} | Delete a transaction rule|
|[**listTransactionRules**](#listtransactionrules) | **GET** /v1/transaction-rules | List all transaction rules|
|[**previewTransactionRule**](#previewtransactionrule) | **POST** /v1/transaction-rules/preview | Preview transactions a rule would match (dry-run, no persistence)|
|[**updateTransactionRule**](#updatetransactionrule) | **PATCH** /v1/transaction-rules/{id} | Update a transaction rule|

# **createTransactionRule**
> CreateTransactionRuleResponse createTransactionRule(createTransactionRuleRequest)

Persists a new auto-categorization rule. Criteria and actions are both partial: omit any field to leave it unset (e.g. omit `merchantName` to match on amount-range only).  Criteria support: merchant name, amount range, account, current category. Actions support: set category, add tags, set merchant name, hide from reports, split. Rules apply to incoming transactions on next sync (Monarch does not retroactively categorize unless the user runs the rule from the UI).  To dry-run a rule shape before saving, use `POST /v1/transaction-rules/preview` (same body, no persistence). 

### Example

```typescript
import {
    RulesApi,
    Configuration,
    CreateTransactionRuleRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RulesApi(configuration);

let createTransactionRuleRequest: CreateTransactionRuleRequest; //

const { status, data } = await apiInstance.createTransactionRule(
    createTransactionRuleRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createTransactionRuleRequest** | **CreateTransactionRuleRequest**|  | |


### Return type

**CreateTransactionRuleResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Rule created (Monarch\&#39;s mutation does not return the saved rule body; fetch via list to see the persisted form). |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteTransactionRule**
> DeleteAccountResponse deleteTransactionRule()

Removes one auto-categorization rule. **Destructive** but non-cascading: existing transactions that the rule previously categorized keep their assigned category (Monarch does not re-evaluate categories on rule delete).  To temporarily disable a rule without deleting it, use `PATCH /v1/transaction-rules/{id}` with the rule paused/disabled in the criteria. 

### Example

```typescript
import {
    RulesApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RulesApi(configuration);

let id: string; //Transaction rule id. (default to undefined)

const { status, data } = await apiInstance.deleteTransactionRule(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Transaction rule id. | defaults to undefined|


### Return type

**DeleteAccountResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Rule deleted. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listTransactionRules**
> ListTransactionRulesResponse listTransactionRules()

Auto-categorization rules. Each rule has matching criteria (merchant, amount range, account, category, etc.) and a set of actions to apply (set category, add tags, hide from reports, split, etc.) whenever a transaction matches. Returned in display order. 

### Example

```typescript
import {
    RulesApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RulesApi(configuration);

const { status, data } = await apiInstance.listTransactionRules();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**ListTransactionRulesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All transaction rules, in display order. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **previewTransactionRule**
> PreviewTransactionRuleResponse previewTransactionRule(createTransactionRuleRequest)

Send a tentative rule shape and get back the transactions that *would* match it if the rule were saved, with the proposed new values (newCategory, newTags, newName, etc.). Useful for building rules interactively without polluting your rule set with throwaway saves.  Returns up to 30 results per call; page with `offset` to walk the full set. 

### Example

```typescript
import {
    RulesApi,
    Configuration,
    CreateTransactionRuleRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RulesApi(configuration);

let createTransactionRuleRequest: CreateTransactionRuleRequest; //
let offset: number; //Page offset. (optional) (default to undefined)

const { status, data } = await apiInstance.previewTransactionRule(
    createTransactionRuleRequest,
    offset
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createTransactionRuleRequest** | **CreateTransactionRuleRequest**|  | |
| **offset** | [**number**] | Page offset. | (optional) defaults to undefined|


### Return type

**PreviewTransactionRuleResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Matching transactions + proposed values. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateTransactionRule**
> UpdateTransactionRuleResponse updateTransactionRule(createTransactionRuleRequest)

Replaces the criteria and actions on an existing rule.  **Gotcha**: Monarch\'s mutation takes the full rule shape, NOT a partial patch. The proxy forwards exactly what you send. Omit any sub-tree you want to clear, but be aware that omitting an array you wanted to keep will wipe it. Fetch the current rule via `GET /v1/transaction-rules` first if in doubt.  To dry-run a rule shape before saving use `POST /v1/transaction-rules/preview`. 

### Example

```typescript
import {
    RulesApi,
    Configuration,
    CreateTransactionRuleRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RulesApi(configuration);

let id: string; //Transaction rule id. (default to undefined)
let createTransactionRuleRequest: CreateTransactionRuleRequest; //

const { status, data } = await apiInstance.updateTransactionRule(
    id,
    createTransactionRuleRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createTransactionRuleRequest** | **CreateTransactionRuleRequest**|  | |
| **id** | [**string**] | Transaction rule id. | defaults to undefined|


### Return type

**UpdateTransactionRuleResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Rule updated. |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

