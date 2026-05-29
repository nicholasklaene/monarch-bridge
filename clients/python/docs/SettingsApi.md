# monarch_bridge_client.SettingsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_appearance**](SettingsApi.md#get_appearance) | **GET** /v1/me/appearance | Appearance preferences
[**get_cookie_preferences**](SettingsApi.md#get_cookie_preferences) | **GET** /v1/me/cookies | Cookie preferences
[**get_currency**](SettingsApi.md#get_currency) | **GET** /v1/me/currency | Currency preferences
[**get_email_notification_prefs**](SettingsApi.md#get_email_notification_prefs) | **GET** /v1/preferences/notifications/email | Email notification preferences
[**get_fiscal_year**](SettingsApi.md#get_fiscal_year) | **GET** /v1/household/fiscal-year | Fiscal year preferences
[**get_household_members**](SettingsApi.md#get_household_members) | **GET** /v1/household/members | Household members
[**get_household_preferences**](SettingsApi.md#get_household_preferences) | **GET** /v1/household/preferences | Household preferences
[**get_me**](SettingsApi.md#get_me) | **GET** /v1/me | Current authenticated user
[**get_my_household**](SettingsApi.md#get_my_household) | **GET** /v1/household | My household
[**get_notification_preferences**](SettingsApi.md#get_notification_preferences) | **GET** /v1/notifications/preferences | Notification preferences
[**get_push_notification_prefs**](SettingsApi.md#get_push_notification_prefs) | **GET** /v1/preferences/notifications/push | Push notification preferences
[**invite_household_member**](SettingsApi.md#invite_household_member) | **POST** /v1/household/members/invite | Invite a household member
[**remove_household_member**](SettingsApi.md#remove_household_member) | **DELETE** /v1/household/members/{id} | Remove a household member
[**set_currency**](SettingsApi.md#set_currency) | **PUT** /v1/me/currency | Update currency preferences
[**set_email_notification_prefs**](SettingsApi.md#set_email_notification_prefs) | **PUT** /v1/preferences/notifications/email | Update email notification preferences
[**set_fiscal_year**](SettingsApi.md#set_fiscal_year) | **PUT** /v1/household/fiscal-year | Update fiscal year preferences
[**set_push_notification_prefs**](SettingsApi.md#set_push_notification_prefs) | **PUT** /v1/preferences/notifications/push | Update push notification preferences
[**update_appearance**](SettingsApi.md#update_appearance) | **PATCH** /v1/me/appearance | Update appearance preferences
[**update_cookie_preferences**](SettingsApi.md#update_cookie_preferences) | **PATCH** /v1/me/cookies | Update cookie preferences
[**update_household_name**](SettingsApi.md#update_household_name) | **PUT** /v1/household/name | Update household name
[**update_household_preferences**](SettingsApi.md#update_household_preferences) | **PATCH** /v1/household/preferences | Update household preferences
[**update_me**](SettingsApi.md#update_me) | **PATCH** /v1/me | Update current user profile
[**update_notification_preferences**](SettingsApi.md#update_notification_preferences) | **PATCH** /v1/notifications/preferences | Update notification preferences


# **get_appearance**
> GetAppearanceResponse get_appearance()

Appearance preferences

User-scoped appearance settings: theme (`light` / `dark` / `system`),
accent color, compact-mode toggle.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_appearance_response import GetAppearanceResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # Appearance preferences
        api_response = api_instance.get_appearance()
        print("The response of SettingsApi->get_appearance:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_appearance: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetAppearanceResponse**](GetAppearanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Appearance preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_cookie_preferences**
> GetCookiePreferencesResponse get_cookie_preferences()

Cookie preferences

Per-category cookie consent (analytics, marketing, functional).
The web app fires this on first paint to decide what to gate behind
the consent banner.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_cookie_preferences_response import GetCookiePreferencesResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # Cookie preferences
        api_response = api_instance.get_cookie_preferences()
        print("The response of SettingsApi->get_cookie_preferences:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_cookie_preferences: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetCookiePreferencesResponse**](GetCookiePreferencesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Current cookie consents. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_currency**
> GetCurrencyResponse get_currency()

Currency preferences

User's default display currency. Returns the ISO currency code plus
Monarch's render hints (symbol + before/after position).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_currency_response import GetCurrencyResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # Currency preferences
        api_response = api_instance.get_currency()
        print("The response of SettingsApi->get_currency:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_currency: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetCurrencyResponse**](GetCurrencyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Current currency preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_email_notification_prefs**
> GetEmailNotificationPrefsResponse get_email_notification_prefs()

Email notification preferences

Per-topic email delivery toggles (weeklyRecap, budgetAlerts,
billReminders, goalUpdates, marketingTips). Returned as a flat
boolean map.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_email_notification_prefs_response import GetEmailNotificationPrefsResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # Email notification preferences
        api_response = api_instance.get_email_notification_prefs()
        print("The response of SettingsApi->get_email_notification_prefs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_email_notification_prefs: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetEmailNotificationPrefsResponse**](GetEmailNotificationPrefsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Email notification preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_fiscal_year**
> GetFiscalYearResponse get_fiscal_year()

Fiscal year preferences

Household fiscal-year start month + day. Drives "year-to-date" rollups
in reports for households on a non-calendar fiscal year.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_fiscal_year_response import GetFiscalYearResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # Fiscal year preferences
        api_response = api_instance.get_fiscal_year()
        print("The response of SettingsApi->get_fiscal_year:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_fiscal_year: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetFiscalYearResponse**](GetFiscalYearResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Current fiscal-year settings. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_household_members**
> GetHouseholdMembersResponse get_household_members()

Household members

Every user who shares this household, plus the id of the caller
(`meId`) so the client can highlight "you" in member lists.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_household_members_response import GetHouseholdMembersResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # Household members
        api_response = api_instance.get_household_members()
        print("The response of SettingsApi->get_household_members:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_household_members: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetHouseholdMembersResponse**](GetHouseholdMembersResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Member list + caller id. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_household_preferences**
> GetHouseholdPreferencesResponse get_household_preferences()

Household preferences

Household-wide feature flags + review settings. Examples:
`newTransactionsNeedReview`, `aiAssistantEnabled`,
`investmentTransactionsEnabled`, `excludeBusinessFromBudget`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_household_preferences_response import GetHouseholdPreferencesResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # Household preferences
        api_response = api_instance.get_household_preferences()
        print("The response of SettingsApi->get_household_preferences:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_household_preferences: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetHouseholdPreferencesResponse**](GetHouseholdPreferencesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Preferences object. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_me**
> GetMeResponse get_me()

Current authenticated user

Returns the Monarch user the bridge is authenticated as. Includes
`email`, `name`, `displayName`, `timezone`, `birthday`, `householdRole`,
plus auth-state flags (`hasPassword`, `hasMfaOn`).

Use for "who am I" checks and for profile-form pre-population.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_me_response import GetMeResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # Current authenticated user
        api_response = api_instance.get_me()
        print("The response of SettingsApi->get_me:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_me: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetMeResponse**](GetMeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The current user profile. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_my_household**
> GetMyHouseholdResponse get_my_household()

My household

Household-level metadata (name, mailing address). One row per Monarch
household; every member of the household sees the same value.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_my_household_response import GetMyHouseholdResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # My household
        api_response = api_instance.get_my_household()
        print("The response of SettingsApi->get_my_household:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_my_household: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetMyHouseholdResponse**](GetMyHouseholdResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Household record. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_notification_preferences**
> GetNotificationPreferencesResponse get_notification_preferences()

Notification preferences

Per-channel notification preferences (email, push, in-app) grouped
by notification type.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_notification_preferences_response import GetNotificationPreferencesResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # Notification preferences
        api_response = api_instance.get_notification_preferences()
        print("The response of SettingsApi->get_notification_preferences:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_notification_preferences: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetNotificationPreferencesResponse**](GetNotificationPreferencesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Preferences list. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_push_notification_prefs**
> GetEmailNotificationPrefsResponse get_push_notification_prefs()

Push notification preferences

Per-topic push delivery toggles (weeklyRecap, budgetAlerts,
billReminders, goalUpdates, marketingTips). Returned as a flat
boolean map.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_email_notification_prefs_response import GetEmailNotificationPrefsResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)

    try:
        # Push notification preferences
        api_response = api_instance.get_push_notification_prefs()
        print("The response of SettingsApi->get_push_notification_prefs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->get_push_notification_prefs: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetEmailNotificationPrefsResponse**](GetEmailNotificationPrefsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Push notification preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **invite_household_member**
> InviteHouseholdMemberResponse invite_household_member(invite_household_member_request)

Invite a household member

Send a Monarch invitation email to a new household member. `email` is
required; `role` is optional and defaults to `member` (one of `owner`,
`member`, `viewer`).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.invite_household_member_response import InviteHouseholdMemberResponse
from monarch_bridge_client.models.invite_household_member_request import InviteHouseholdMemberRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    invite_household_member_request = monarch_bridge_client.InviteHouseholdMemberRequest() # InviteHouseholdMemberRequest | 

    try:
        # Invite a household member
        api_response = api_instance.invite_household_member(invite_household_member_request)
        print("The response of SettingsApi->invite_household_member:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->invite_household_member: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invite_household_member_request** | [**InviteHouseholdMemberRequest**](InviteHouseholdMemberRequest.md)|  | 

### Return type

[**InviteHouseholdMemberResponse**](InviteHouseholdMemberResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Invitation queued. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **remove_household_member**
> RemoveHouseholdMemberResponse remove_household_member(id)

Remove a household member

Remove a member from the household. Idempotent - re-calling with a
member id that's already removed returns `removed=true`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.remove_household_member_response import RemoveHouseholdMemberResponse
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    id = 'id_example' # str | Monarch household-member (user) id.

    try:
        # Remove a household member
        api_response = api_instance.remove_household_member(id)
        print("The response of SettingsApi->remove_household_member:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->remove_household_member: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch household-member (user) id. | 

### Return type

[**RemoveHouseholdMemberResponse**](RemoveHouseholdMemberResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Removal confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_currency**
> SetCurrencyResponse set_currency(set_currency_request)

Update currency preferences

Set the user's default display currency. `currency` is required (ISO
code, e.g. `USD`, `EUR`). `position` is optional ("before" / "after").


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.set_currency_response import SetCurrencyResponse
from monarch_bridge_client.models.set_currency_request import SetCurrencyRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    set_currency_request = monarch_bridge_client.SetCurrencyRequest() # SetCurrencyRequest | 

    try:
        # Update currency preferences
        api_response = api_instance.set_currency(set_currency_request)
        print("The response of SettingsApi->set_currency:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->set_currency: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **set_currency_request** | [**SetCurrencyRequest**](SetCurrencyRequest.md)|  | 

### Return type

[**SetCurrencyResponse**](SetCurrencyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated currency preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_email_notification_prefs**
> GetEmailNotificationPrefsResponse set_email_notification_prefs(set_email_notification_prefs_request)

Update email notification preferences

Patch any subset of the email-channel toggles. Omit a field to leave
it untouched.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_email_notification_prefs_response import GetEmailNotificationPrefsResponse
from monarch_bridge_client.models.set_email_notification_prefs_request import SetEmailNotificationPrefsRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    set_email_notification_prefs_request = monarch_bridge_client.SetEmailNotificationPrefsRequest() # SetEmailNotificationPrefsRequest | 

    try:
        # Update email notification preferences
        api_response = api_instance.set_email_notification_prefs(set_email_notification_prefs_request)
        print("The response of SettingsApi->set_email_notification_prefs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->set_email_notification_prefs: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **set_email_notification_prefs_request** | [**SetEmailNotificationPrefsRequest**](SetEmailNotificationPrefsRequest.md)|  | 

### Return type

[**GetEmailNotificationPrefsResponse**](GetEmailNotificationPrefsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated email notification preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_fiscal_year**
> SetFiscalYearResponse set_fiscal_year(set_fiscal_year_request)

Update fiscal year preferences

Set the household fiscal-year start. `startMonth` is required (1-12);
`startDay` is optional (1-31, defaults to 1).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.set_fiscal_year_response import SetFiscalYearResponse
from monarch_bridge_client.models.set_fiscal_year_request import SetFiscalYearRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    set_fiscal_year_request = monarch_bridge_client.SetFiscalYearRequest() # SetFiscalYearRequest | 

    try:
        # Update fiscal year preferences
        api_response = api_instance.set_fiscal_year(set_fiscal_year_request)
        print("The response of SettingsApi->set_fiscal_year:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->set_fiscal_year: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **set_fiscal_year_request** | [**SetFiscalYearRequest**](SetFiscalYearRequest.md)|  | 

### Return type

[**SetFiscalYearResponse**](SetFiscalYearResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated fiscal-year settings. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_push_notification_prefs**
> GetEmailNotificationPrefsResponse set_push_notification_prefs(set_email_notification_prefs_request)

Update push notification preferences

Patch any subset of the push-channel toggles. Omit a field to leave
it untouched.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_email_notification_prefs_response import GetEmailNotificationPrefsResponse
from monarch_bridge_client.models.set_email_notification_prefs_request import SetEmailNotificationPrefsRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    set_email_notification_prefs_request = monarch_bridge_client.SetEmailNotificationPrefsRequest() # SetEmailNotificationPrefsRequest | 

    try:
        # Update push notification preferences
        api_response = api_instance.set_push_notification_prefs(set_email_notification_prefs_request)
        print("The response of SettingsApi->set_push_notification_prefs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->set_push_notification_prefs: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **set_email_notification_prefs_request** | [**SetEmailNotificationPrefsRequest**](SetEmailNotificationPrefsRequest.md)|  | 

### Return type

[**GetEmailNotificationPrefsResponse**](GetEmailNotificationPrefsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated push notification preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_appearance**
> GetAppearanceResponse update_appearance(update_appearance_request)

Update appearance preferences

Patch one or more appearance preferences. Only populated fields are
forwarded; omit a field to leave it untouched.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_appearance_response import GetAppearanceResponse
from monarch_bridge_client.models.update_appearance_request import UpdateAppearanceRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    update_appearance_request = monarch_bridge_client.UpdateAppearanceRequest() # UpdateAppearanceRequest | 

    try:
        # Update appearance preferences
        api_response = api_instance.update_appearance(update_appearance_request)
        print("The response of SettingsApi->update_appearance:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->update_appearance: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_appearance_request** | [**UpdateAppearanceRequest**](UpdateAppearanceRequest.md)|  | 

### Return type

[**GetAppearanceResponse**](GetAppearanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated appearance. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_cookie_preferences**
> GetCookiePreferencesResponse update_cookie_preferences(update_cookie_preferences_request)

Update cookie preferences

Patch any subset of cookie consents. Omit a field to leave it
untouched. The web app calls this from the "Accept selected" button
on the cookie banner and from the Settings → Privacy → Cookies page.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_cookie_preferences_response import GetCookiePreferencesResponse
from monarch_bridge_client.models.update_cookie_preferences_request import UpdateCookiePreferencesRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    update_cookie_preferences_request = monarch_bridge_client.UpdateCookiePreferencesRequest() # UpdateCookiePreferencesRequest | 

    try:
        # Update cookie preferences
        api_response = api_instance.update_cookie_preferences(update_cookie_preferences_request)
        print("The response of SettingsApi->update_cookie_preferences:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->update_cookie_preferences: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_cookie_preferences_request** | [**UpdateCookiePreferencesRequest**](UpdateCookiePreferencesRequest.md)|  | 

### Return type

[**GetCookiePreferencesResponse**](GetCookiePreferencesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated cookie consents. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_household_name**
> UpdateHouseholdNameResponse update_household_name(update_household_name_request)

Update household name

Rename the household. The new name appears in invitation emails and
on every member's home screen.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_household_name_response import UpdateHouseholdNameResponse
from monarch_bridge_client.models.update_household_name_request import UpdateHouseholdNameRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    update_household_name_request = monarch_bridge_client.UpdateHouseholdNameRequest() # UpdateHouseholdNameRequest | 

    try:
        # Update household name
        api_response = api_instance.update_household_name(update_household_name_request)
        print("The response of SettingsApi->update_household_name:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->update_household_name: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_household_name_request** | [**UpdateHouseholdNameRequest**](UpdateHouseholdNameRequest.md)|  | 

### Return type

[**UpdateHouseholdNameResponse**](UpdateHouseholdNameResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated household record. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_household_preferences**
> UpdateHouseholdPreferencesResponse update_household_preferences(update_household_preferences_request)

Update household preferences

Patch any subset of household preference flags. All fields optional;
omit to leave unchanged.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_household_preferences_response import UpdateHouseholdPreferencesResponse
from monarch_bridge_client.models.update_household_preferences_request import UpdateHouseholdPreferencesRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    update_household_preferences_request = monarch_bridge_client.UpdateHouseholdPreferencesRequest() # UpdateHouseholdPreferencesRequest | 

    try:
        # Update household preferences
        api_response = api_instance.update_household_preferences(update_household_preferences_request)
        print("The response of SettingsApi->update_household_preferences:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->update_household_preferences: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_household_preferences_request** | [**UpdateHouseholdPreferencesRequest**](UpdateHouseholdPreferencesRequest.md)|  | 

### Return type

[**UpdateHouseholdPreferencesResponse**](UpdateHouseholdPreferencesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_me**
> UpdateMeResponse update_me(update_me_request)

Update current user profile

Patch the current user's profile fields. All fields optional; omit to
leave unchanged. Updates `email`, `name`, `birthday`, or `timezone`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_me_response import UpdateMeResponse
from monarch_bridge_client.models.update_me_request import UpdateMeRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    update_me_request = monarch_bridge_client.UpdateMeRequest() # UpdateMeRequest | 

    try:
        # Update current user profile
        api_response = api_instance.update_me(update_me_request)
        print("The response of SettingsApi->update_me:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->update_me: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_me_request** | [**UpdateMeRequest**](UpdateMeRequest.md)|  | 

### Return type

[**UpdateMeResponse**](UpdateMeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated user profile. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_notification_preferences**
> UpdateNotificationPreferencesResponse update_notification_preferences(update_notification_preferences_request)

Update notification preferences

Toggle email / push / in-app delivery for one notification
preference by id.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_notification_preferences_response import UpdateNotificationPreferencesResponse
from monarch_bridge_client.models.update_notification_preferences_request import UpdateNotificationPreferencesRequest
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
    api_instance = monarch_bridge_client.SettingsApi(api_client)
    update_notification_preferences_request = monarch_bridge_client.UpdateNotificationPreferencesRequest() # UpdateNotificationPreferencesRequest | 

    try:
        # Update notification preferences
        api_response = api_instance.update_notification_preferences(update_notification_preferences_request)
        print("The response of SettingsApi->update_notification_preferences:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SettingsApi->update_notification_preferences: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_notification_preferences_request** | [**UpdateNotificationPreferencesRequest**](UpdateNotificationPreferencesRequest.md)|  | 

### Return type

[**UpdateNotificationPreferencesResponse**](UpdateNotificationPreferencesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated preference. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

