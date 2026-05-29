# RulesApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createTransactionRule**](RulesApi.md#createTransactionRule) | **POST** /v1/transaction-rules | Create a transaction rule |
| [**deleteTransactionRule**](RulesApi.md#deleteTransactionRule) | **DELETE** /v1/transaction-rules/{id} | Delete a transaction rule |
| [**listTransactionRules**](RulesApi.md#listTransactionRules) | **GET** /v1/transaction-rules | List all transaction rules |
| [**previewTransactionRule**](RulesApi.md#previewTransactionRule) | **POST** /v1/transaction-rules/preview | Preview transactions a rule would match (dry-run, no persistence) |
| [**updateTransactionRule**](RulesApi.md#updateTransactionRule) | **PATCH** /v1/transaction-rules/{id} | Update a transaction rule |


<a id="createTransactionRule"></a>
# **createTransactionRule**
> CreateTransactionRuleResponse createTransactionRule(createTransactionRuleRequest)

Create a transaction rule

Persists a new auto-categorization rule. Criteria and actions are both partial: omit any field to leave it unset (e.g. omit &#x60;merchantName&#x60; to match on amount-range only).  Criteria support: merchant name, amount range, account, current category. Actions support: set category, add tags, set merchant name, hide from reports, split. Rules apply to incoming transactions on next sync (Monarch does not retroactively categorize unless the user runs the rule from the UI).  To dry-run a rule shape before saving, use &#x60;POST /v1/transaction-rules/preview&#x60; (same body, no persistence). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RulesApi()
val createTransactionRuleRequest : CreateTransactionRuleRequest =  // CreateTransactionRuleRequest | 
try {
    val result : CreateTransactionRuleResponse = apiInstance.createTransactionRule(createTransactionRuleRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RulesApi#createTransactionRule")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RulesApi#createTransactionRule")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createTransactionRuleRequest** | [**CreateTransactionRuleRequest**](CreateTransactionRuleRequest.md)|  | |

### Return type

[**CreateTransactionRuleResponse**](CreateTransactionRuleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteTransactionRule"></a>
# **deleteTransactionRule**
> DeleteAccountResponse deleteTransactionRule(id)

Delete a transaction rule

Removes one auto-categorization rule. **Destructive** but non-cascading: existing transactions that the rule previously categorized keep their assigned category (Monarch does not re-evaluate categories on rule delete).  To temporarily disable a rule without deleting it, use &#x60;PATCH /v1/transaction-rules/{id}&#x60; with the rule paused/disabled in the criteria. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RulesApi()
val id : kotlin.String = id_example // kotlin.String | Transaction rule id.
try {
    val result : DeleteAccountResponse = apiInstance.deleteTransactionRule(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RulesApi#deleteTransactionRule")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RulesApi#deleteTransactionRule")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Transaction rule id. | |

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listTransactionRules"></a>
# **listTransactionRules**
> ListTransactionRulesResponse listTransactionRules()

List all transaction rules

Auto-categorization rules. Each rule has matching criteria (merchant, amount range, account, category, etc.) and a set of actions to apply (set category, add tags, hide from reports, split, etc.) whenever a transaction matches. Returned in display order. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RulesApi()
try {
    val result : ListTransactionRulesResponse = apiInstance.listTransactionRules()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RulesApi#listTransactionRules")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RulesApi#listTransactionRules")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListTransactionRulesResponse**](ListTransactionRulesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="previewTransactionRule"></a>
# **previewTransactionRule**
> PreviewTransactionRuleResponse previewTransactionRule(createTransactionRuleRequest, offset)

Preview transactions a rule would match (dry-run, no persistence)

Send a tentative rule shape and get back the transactions that *would* match it if the rule were saved, with the proposed new values (newCategory, newTags, newName, etc.). Useful for building rules interactively without polluting your rule set with throwaway saves.  Returns up to 30 results per call; page with &#x60;offset&#x60; to walk the full set. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RulesApi()
val createTransactionRuleRequest : CreateTransactionRuleRequest =  // CreateTransactionRuleRequest | 
val offset : kotlin.Int = 56 // kotlin.Int | Page offset.
try {
    val result : PreviewTransactionRuleResponse = apiInstance.previewTransactionRule(createTransactionRuleRequest, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RulesApi#previewTransactionRule")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RulesApi#previewTransactionRule")
    e.printStackTrace()
}
```

### Parameters
| **createTransactionRuleRequest** | [**CreateTransactionRuleRequest**](CreateTransactionRuleRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **offset** | **kotlin.Int**| Page offset. | [optional] |

### Return type

[**PreviewTransactionRuleResponse**](PreviewTransactionRuleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateTransactionRule"></a>
# **updateTransactionRule**
> UpdateTransactionRuleResponse updateTransactionRule(id, createTransactionRuleRequest)

Update a transaction rule

Replaces the criteria and actions on an existing rule.  **Gotcha**: Monarch&#39;s mutation takes the full rule shape, NOT a partial patch. The proxy forwards exactly what you send. Omit any sub-tree you want to clear, but be aware that omitting an array you wanted to keep will wipe it. Fetch the current rule via &#x60;GET /v1/transaction-rules&#x60; first if in doubt.  To dry-run a rule shape before saving use &#x60;POST /v1/transaction-rules/preview&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RulesApi()
val id : kotlin.String = id_example // kotlin.String | Transaction rule id.
val createTransactionRuleRequest : CreateTransactionRuleRequest =  // CreateTransactionRuleRequest | 
try {
    val result : UpdateTransactionRuleResponse = apiInstance.updateTransactionRule(id, createTransactionRuleRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RulesApi#updateTransactionRule")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RulesApi#updateTransactionRule")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Transaction rule id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createTransactionRuleRequest** | [**CreateTransactionRuleRequest**](CreateTransactionRuleRequest.md)|  | |

### Return type

[**UpdateTransactionRuleResponse**](UpdateTransactionRuleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

