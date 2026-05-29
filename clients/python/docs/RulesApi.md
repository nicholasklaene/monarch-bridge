# monarch_bridge_client.RulesApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_transaction_rule**](RulesApi.md#create_transaction_rule) | **POST** /v1/transaction-rules | Create a transaction rule
[**delete_transaction_rule**](RulesApi.md#delete_transaction_rule) | **DELETE** /v1/transaction-rules/{id} | Delete a transaction rule
[**list_transaction_rules**](RulesApi.md#list_transaction_rules) | **GET** /v1/transaction-rules | List all transaction rules
[**preview_transaction_rule**](RulesApi.md#preview_transaction_rule) | **POST** /v1/transaction-rules/preview | Preview transactions a rule would match (dry-run, no persistence)
[**update_transaction_rule**](RulesApi.md#update_transaction_rule) | **PATCH** /v1/transaction-rules/{id} | Update a transaction rule


# **create_transaction_rule**
> CreateTransactionRuleResponse create_transaction_rule(create_transaction_rule_request)

Create a transaction rule

Persists a new auto-categorization rule. Criteria and actions are
both partial: omit any field to leave it unset (e.g. omit
`merchantName` to match on amount-range only).

Criteria support: merchant name, amount range, account, current
category. Actions support: set category, add tags, set merchant
name, hide from reports, split. Rules apply to incoming
transactions on next sync (Monarch does not retroactively
categorize unless the user runs the rule from the UI).

To dry-run a rule shape before saving, use
`POST /v1/transaction-rules/preview` (same body, no persistence).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_transaction_rule_response import CreateTransactionRuleResponse
from monarch_bridge_client.models.create_transaction_rule_request import CreateTransactionRuleRequest
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.RulesApi(api_client)
    create_transaction_rule_request = monarch_bridge_client.CreateTransactionRuleRequest() # CreateTransactionRuleRequest | 

    try:
        # Create a transaction rule
        api_response = api_instance.create_transaction_rule(create_transaction_rule_request)
        print("The response of RulesApi->create_transaction_rule:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RulesApi->create_transaction_rule: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_transaction_rule_request** | [**CreateTransactionRuleRequest**](CreateTransactionRuleRequest.md)|  | 

### Return type

[**CreateTransactionRuleResponse**](CreateTransactionRuleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Rule created (Monarch&#39;s mutation does not return the saved rule body; fetch via list to see the persisted form). |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_transaction_rule**
> DeleteAccountResponse delete_transaction_rule(id)

Delete a transaction rule

Removes one auto-categorization rule. **Destructive** but
non-cascading: existing transactions that the rule previously
categorized keep their assigned category (Monarch does not
re-evaluate categories on rule delete).

To temporarily disable a rule without deleting it, use
`PATCH /v1/transaction-rules/{id}` with the rule paused/disabled
in the criteria.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.delete_account_response import DeleteAccountResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.RulesApi(api_client)
    id = 'id_example' # str | Transaction rule id.

    try:
        # Delete a transaction rule
        api_response = api_instance.delete_transaction_rule(id)
        print("The response of RulesApi->delete_transaction_rule:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RulesApi->delete_transaction_rule: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Transaction rule id. | 

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Rule deleted. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_transaction_rules**
> ListTransactionRulesResponse list_transaction_rules()

List all transaction rules

Auto-categorization rules. Each rule has matching criteria (merchant,
amount range, account, category, etc.) and a set of actions to apply
(set category, add tags, hide from reports, split, etc.) whenever a
transaction matches. Returned in display order.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_transaction_rules_response import ListTransactionRulesResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.RulesApi(api_client)

    try:
        # List all transaction rules
        api_response = api_instance.list_transaction_rules()
        print("The response of RulesApi->list_transaction_rules:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RulesApi->list_transaction_rules: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All transaction rules, in display order. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **preview_transaction_rule**
> PreviewTransactionRuleResponse preview_transaction_rule(create_transaction_rule_request, offset=offset)

Preview transactions a rule would match (dry-run, no persistence)

Send a tentative rule shape and get back the transactions that *would* match
it if the rule were saved, with the proposed new values (newCategory, newTags,
newName, etc.). Useful for building rules interactively without polluting your
rule set with throwaway saves.

Returns up to 30 results per call; page with `offset` to walk the full set.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_transaction_rule_request import CreateTransactionRuleRequest
from monarch_bridge_client.models.preview_transaction_rule_response import PreviewTransactionRuleResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.RulesApi(api_client)
    create_transaction_rule_request = monarch_bridge_client.CreateTransactionRuleRequest() # CreateTransactionRuleRequest | 
    offset = 56 # int | Page offset. (optional)

    try:
        # Preview transactions a rule would match (dry-run, no persistence)
        api_response = api_instance.preview_transaction_rule(create_transaction_rule_request, offset=offset)
        print("The response of RulesApi->preview_transaction_rule:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RulesApi->preview_transaction_rule: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_transaction_rule_request** | [**CreateTransactionRuleRequest**](CreateTransactionRuleRequest.md)|  | 
 **offset** | **int**| Page offset. | [optional] 

### Return type

[**PreviewTransactionRuleResponse**](PreviewTransactionRuleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Matching transactions + proposed values. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_transaction_rule**
> UpdateTransactionRuleResponse update_transaction_rule(id, create_transaction_rule_request)

Update a transaction rule

Replaces the criteria and actions on an existing rule.

**Gotcha**: Monarch's mutation takes the full rule shape, NOT a
partial patch. The proxy forwards exactly what you send. Omit any
sub-tree you want to clear, but be aware that omitting an array
you wanted to keep will wipe it. Fetch the current rule via
`GET /v1/transaction-rules` first if in doubt.

To dry-run a rule shape before saving use
`POST /v1/transaction-rules/preview`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_transaction_rule_request import CreateTransactionRuleRequest
from monarch_bridge_client.models.update_transaction_rule_response import UpdateTransactionRuleResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.RulesApi(api_client)
    id = 'id_example' # str | Transaction rule id.
    create_transaction_rule_request = monarch_bridge_client.CreateTransactionRuleRequest() # CreateTransactionRuleRequest | 

    try:
        # Update a transaction rule
        api_response = api_instance.update_transaction_rule(id, create_transaction_rule_request)
        print("The response of RulesApi->update_transaction_rule:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RulesApi->update_transaction_rule: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Transaction rule id. | 
 **create_transaction_rule_request** | [**CreateTransactionRuleRequest**](CreateTransactionRuleRequest.md)|  | 

### Return type

[**UpdateTransactionRuleResponse**](UpdateTransactionRuleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Rule updated. |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

