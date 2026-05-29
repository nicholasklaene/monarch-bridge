# SettingsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getAppearance**](SettingsApi.md#getAppearance) | **GET** /v1/me/appearance | Appearance preferences |
| [**getCookiePreferences**](SettingsApi.md#getCookiePreferences) | **GET** /v1/me/cookies | Cookie preferences |
| [**getCurrency**](SettingsApi.md#getCurrency) | **GET** /v1/me/currency | Currency preferences |
| [**getEmailNotificationPrefs**](SettingsApi.md#getEmailNotificationPrefs) | **GET** /v1/preferences/notifications/email | Email notification preferences |
| [**getFiscalYear**](SettingsApi.md#getFiscalYear) | **GET** /v1/household/fiscal-year | Fiscal year preferences |
| [**getHouseholdMembers**](SettingsApi.md#getHouseholdMembers) | **GET** /v1/household/members | Household members |
| [**getHouseholdPreferences**](SettingsApi.md#getHouseholdPreferences) | **GET** /v1/household/preferences | Household preferences |
| [**getMe**](SettingsApi.md#getMe) | **GET** /v1/me | Current authenticated user |
| [**getMyHousehold**](SettingsApi.md#getMyHousehold) | **GET** /v1/household | My household |
| [**getNotificationPreferences**](SettingsApi.md#getNotificationPreferences) | **GET** /v1/notifications/preferences | Notification preferences |
| [**getPushNotificationPrefs**](SettingsApi.md#getPushNotificationPrefs) | **GET** /v1/preferences/notifications/push | Push notification preferences |
| [**inviteHouseholdMember**](SettingsApi.md#inviteHouseholdMember) | **POST** /v1/household/members/invite | Invite a household member |
| [**removeHouseholdMember**](SettingsApi.md#removeHouseholdMember) | **DELETE** /v1/household/members/{id} | Remove a household member |
| [**setCurrency**](SettingsApi.md#setCurrency) | **PUT** /v1/me/currency | Update currency preferences |
| [**setEmailNotificationPrefs**](SettingsApi.md#setEmailNotificationPrefs) | **PUT** /v1/preferences/notifications/email | Update email notification preferences |
| [**setFiscalYear**](SettingsApi.md#setFiscalYear) | **PUT** /v1/household/fiscal-year | Update fiscal year preferences |
| [**setPushNotificationPrefs**](SettingsApi.md#setPushNotificationPrefs) | **PUT** /v1/preferences/notifications/push | Update push notification preferences |
| [**updateAppearance**](SettingsApi.md#updateAppearance) | **PATCH** /v1/me/appearance | Update appearance preferences |
| [**updateCookiePreferences**](SettingsApi.md#updateCookiePreferences) | **PATCH** /v1/me/cookies | Update cookie preferences |
| [**updateHouseholdName**](SettingsApi.md#updateHouseholdName) | **PUT** /v1/household/name | Update household name |
| [**updateHouseholdPreferences**](SettingsApi.md#updateHouseholdPreferences) | **PATCH** /v1/household/preferences | Update household preferences |
| [**updateMe**](SettingsApi.md#updateMe) | **PATCH** /v1/me | Update current user profile |
| [**updateNotificationPreferences**](SettingsApi.md#updateNotificationPreferences) | **PATCH** /v1/notifications/preferences | Update notification preferences |


<a id="getAppearance"></a>
# **getAppearance**
> GetAppearanceResponse getAppearance()

Appearance preferences

User-scoped appearance settings: theme (&#x60;light&#x60; / &#x60;dark&#x60; / &#x60;system&#x60;), accent color, compact-mode toggle. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetAppearanceResponse = apiInstance.getAppearance()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getAppearance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getAppearance")
    e.printStackTrace()
}
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

<a id="getCookiePreferences"></a>
# **getCookiePreferences**
> GetCookiePreferencesResponse getCookiePreferences()

Cookie preferences

Per-category cookie consent (analytics, marketing, functional). The web app fires this on first paint to decide what to gate behind the consent banner. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetCookiePreferencesResponse = apiInstance.getCookiePreferences()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getCookiePreferences")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getCookiePreferences")
    e.printStackTrace()
}
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

<a id="getCurrency"></a>
# **getCurrency**
> GetCurrencyResponse getCurrency()

Currency preferences

User&#39;s default display currency. Returns the ISO currency code plus Monarch&#39;s render hints (symbol + before/after position). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetCurrencyResponse = apiInstance.getCurrency()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getCurrency")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getCurrency")
    e.printStackTrace()
}
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

<a id="getEmailNotificationPrefs"></a>
# **getEmailNotificationPrefs**
> GetEmailNotificationPrefsResponse getEmailNotificationPrefs()

Email notification preferences

Per-topic email delivery toggles (weeklyRecap, budgetAlerts, billReminders, goalUpdates, marketingTips). Returned as a flat boolean map. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetEmailNotificationPrefsResponse = apiInstance.getEmailNotificationPrefs()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getEmailNotificationPrefs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getEmailNotificationPrefs")
    e.printStackTrace()
}
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

<a id="getFiscalYear"></a>
# **getFiscalYear**
> GetFiscalYearResponse getFiscalYear()

Fiscal year preferences

Household fiscal-year start month + day. Drives \&quot;year-to-date\&quot; rollups in reports for households on a non-calendar fiscal year. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetFiscalYearResponse = apiInstance.getFiscalYear()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getFiscalYear")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getFiscalYear")
    e.printStackTrace()
}
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

<a id="getHouseholdMembers"></a>
# **getHouseholdMembers**
> GetHouseholdMembersResponse getHouseholdMembers()

Household members

Every user who shares this household, plus the id of the caller (&#x60;meId&#x60;) so the client can highlight \&quot;you\&quot; in member lists. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetHouseholdMembersResponse = apiInstance.getHouseholdMembers()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getHouseholdMembers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getHouseholdMembers")
    e.printStackTrace()
}
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

<a id="getHouseholdPreferences"></a>
# **getHouseholdPreferences**
> GetHouseholdPreferencesResponse getHouseholdPreferences()

Household preferences

Household-wide feature flags + review settings. Examples: &#x60;newTransactionsNeedReview&#x60;, &#x60;aiAssistantEnabled&#x60;, &#x60;investmentTransactionsEnabled&#x60;, &#x60;excludeBusinessFromBudget&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetHouseholdPreferencesResponse = apiInstance.getHouseholdPreferences()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getHouseholdPreferences")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getHouseholdPreferences")
    e.printStackTrace()
}
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

<a id="getMe"></a>
# **getMe**
> GetMeResponse getMe()

Current authenticated user

Returns the Monarch user the bridge is authenticated as. Includes &#x60;email&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;timezone&#x60;, &#x60;birthday&#x60;, &#x60;householdRole&#x60;, plus auth-state flags (&#x60;hasPassword&#x60;, &#x60;hasMfaOn&#x60;).  Use for \&quot;who am I\&quot; checks and for profile-form pre-population. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetMeResponse = apiInstance.getMe()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getMe")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getMe")
    e.printStackTrace()
}
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

<a id="getMyHousehold"></a>
# **getMyHousehold**
> GetMyHouseholdResponse getMyHousehold()

My household

Household-level metadata (name, mailing address). One row per Monarch household; every member of the household sees the same value. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetMyHouseholdResponse = apiInstance.getMyHousehold()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getMyHousehold")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getMyHousehold")
    e.printStackTrace()
}
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

<a id="getNotificationPreferences"></a>
# **getNotificationPreferences**
> GetNotificationPreferencesResponse getNotificationPreferences()

Notification preferences

Per-channel notification preferences (email, push, in-app) grouped by notification type. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetNotificationPreferencesResponse = apiInstance.getNotificationPreferences()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getNotificationPreferences")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getNotificationPreferences")
    e.printStackTrace()
}
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

<a id="getPushNotificationPrefs"></a>
# **getPushNotificationPrefs**
> GetEmailNotificationPrefsResponse getPushNotificationPrefs()

Push notification preferences

Per-topic push delivery toggles (weeklyRecap, budgetAlerts, billReminders, goalUpdates, marketingTips). Returned as a flat boolean map. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
try {
    val result : GetEmailNotificationPrefsResponse = apiInstance.getPushNotificationPrefs()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#getPushNotificationPrefs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#getPushNotificationPrefs")
    e.printStackTrace()
}
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

<a id="inviteHouseholdMember"></a>
# **inviteHouseholdMember**
> InviteHouseholdMemberResponse inviteHouseholdMember(inviteHouseholdMemberRequest)

Invite a household member

Send a Monarch invitation email to a new household member. &#x60;email&#x60; is required; &#x60;role&#x60; is optional and defaults to &#x60;member&#x60; (one of &#x60;owner&#x60;, &#x60;member&#x60;, &#x60;viewer&#x60;). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val inviteHouseholdMemberRequest : InviteHouseholdMemberRequest =  // InviteHouseholdMemberRequest | 
try {
    val result : InviteHouseholdMemberResponse = apiInstance.inviteHouseholdMember(inviteHouseholdMemberRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#inviteHouseholdMember")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#inviteHouseholdMember")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **inviteHouseholdMemberRequest** | [**InviteHouseholdMemberRequest**](InviteHouseholdMemberRequest.md)|  | |

### Return type

[**InviteHouseholdMemberResponse**](InviteHouseholdMemberResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="removeHouseholdMember"></a>
# **removeHouseholdMember**
> RemoveHouseholdMemberResponse removeHouseholdMember(id)

Remove a household member

Remove a member from the household. Idempotent - re-calling with a member id that&#39;s already removed returns &#x60;removed&#x3D;true&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch household-member (user) id.
try {
    val result : RemoveHouseholdMemberResponse = apiInstance.removeHouseholdMember(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#removeHouseholdMember")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#removeHouseholdMember")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch household-member (user) id. | |

### Return type

[**RemoveHouseholdMemberResponse**](RemoveHouseholdMemberResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="setCurrency"></a>
# **setCurrency**
> SetCurrencyResponse setCurrency(setCurrencyRequest)

Update currency preferences

Set the user&#39;s default display currency. &#x60;currency&#x60; is required (ISO code, e.g. &#x60;USD&#x60;, &#x60;EUR&#x60;). &#x60;position&#x60; is optional (\&quot;before\&quot; / \&quot;after\&quot;). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val setCurrencyRequest : SetCurrencyRequest =  // SetCurrencyRequest | 
try {
    val result : SetCurrencyResponse = apiInstance.setCurrency(setCurrencyRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#setCurrency")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#setCurrency")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setCurrencyRequest** | [**SetCurrencyRequest**](SetCurrencyRequest.md)|  | |

### Return type

[**SetCurrencyResponse**](SetCurrencyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="setEmailNotificationPrefs"></a>
# **setEmailNotificationPrefs**
> GetEmailNotificationPrefsResponse setEmailNotificationPrefs(setEmailNotificationPrefsRequest)

Update email notification preferences

Patch any subset of the email-channel toggles. Omit a field to leave it untouched. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val setEmailNotificationPrefsRequest : SetEmailNotificationPrefsRequest =  // SetEmailNotificationPrefsRequest | 
try {
    val result : GetEmailNotificationPrefsResponse = apiInstance.setEmailNotificationPrefs(setEmailNotificationPrefsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#setEmailNotificationPrefs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#setEmailNotificationPrefs")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setEmailNotificationPrefsRequest** | [**SetEmailNotificationPrefsRequest**](SetEmailNotificationPrefsRequest.md)|  | |

### Return type

[**GetEmailNotificationPrefsResponse**](GetEmailNotificationPrefsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="setFiscalYear"></a>
# **setFiscalYear**
> SetFiscalYearResponse setFiscalYear(setFiscalYearRequest)

Update fiscal year preferences

Set the household fiscal-year start. &#x60;startMonth&#x60; is required (1-12); &#x60;startDay&#x60; is optional (1-31, defaults to 1). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val setFiscalYearRequest : SetFiscalYearRequest =  // SetFiscalYearRequest | 
try {
    val result : SetFiscalYearResponse = apiInstance.setFiscalYear(setFiscalYearRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#setFiscalYear")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#setFiscalYear")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setFiscalYearRequest** | [**SetFiscalYearRequest**](SetFiscalYearRequest.md)|  | |

### Return type

[**SetFiscalYearResponse**](SetFiscalYearResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="setPushNotificationPrefs"></a>
# **setPushNotificationPrefs**
> GetEmailNotificationPrefsResponse setPushNotificationPrefs(setEmailNotificationPrefsRequest)

Update push notification preferences

Patch any subset of the push-channel toggles. Omit a field to leave it untouched. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val setEmailNotificationPrefsRequest : SetEmailNotificationPrefsRequest =  // SetEmailNotificationPrefsRequest | 
try {
    val result : GetEmailNotificationPrefsResponse = apiInstance.setPushNotificationPrefs(setEmailNotificationPrefsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#setPushNotificationPrefs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#setPushNotificationPrefs")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setEmailNotificationPrefsRequest** | [**SetEmailNotificationPrefsRequest**](SetEmailNotificationPrefsRequest.md)|  | |

### Return type

[**GetEmailNotificationPrefsResponse**](GetEmailNotificationPrefsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateAppearance"></a>
# **updateAppearance**
> GetAppearanceResponse updateAppearance(updateAppearanceRequest)

Update appearance preferences

Patch one or more appearance preferences. Only populated fields are forwarded; omit a field to leave it untouched. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val updateAppearanceRequest : UpdateAppearanceRequest =  // UpdateAppearanceRequest | 
try {
    val result : GetAppearanceResponse = apiInstance.updateAppearance(updateAppearanceRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#updateAppearance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#updateAppearance")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateAppearanceRequest** | [**UpdateAppearanceRequest**](UpdateAppearanceRequest.md)|  | |

### Return type

[**GetAppearanceResponse**](GetAppearanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateCookiePreferences"></a>
# **updateCookiePreferences**
> GetCookiePreferencesResponse updateCookiePreferences(updateCookiePreferencesRequest)

Update cookie preferences

Patch any subset of cookie consents. Omit a field to leave it untouched. The web app calls this from the \&quot;Accept selected\&quot; button on the cookie banner and from the Settings → Privacy → Cookies page. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val updateCookiePreferencesRequest : UpdateCookiePreferencesRequest =  // UpdateCookiePreferencesRequest | 
try {
    val result : GetCookiePreferencesResponse = apiInstance.updateCookiePreferences(updateCookiePreferencesRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#updateCookiePreferences")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#updateCookiePreferences")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateCookiePreferencesRequest** | [**UpdateCookiePreferencesRequest**](UpdateCookiePreferencesRequest.md)|  | |

### Return type

[**GetCookiePreferencesResponse**](GetCookiePreferencesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateHouseholdName"></a>
# **updateHouseholdName**
> UpdateHouseholdNameResponse updateHouseholdName(updateHouseholdNameRequest)

Update household name

Rename the household. The new name appears in invitation emails and on every member&#39;s home screen. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val updateHouseholdNameRequest : UpdateHouseholdNameRequest =  // UpdateHouseholdNameRequest | 
try {
    val result : UpdateHouseholdNameResponse = apiInstance.updateHouseholdName(updateHouseholdNameRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#updateHouseholdName")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#updateHouseholdName")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateHouseholdNameRequest** | [**UpdateHouseholdNameRequest**](UpdateHouseholdNameRequest.md)|  | |

### Return type

[**UpdateHouseholdNameResponse**](UpdateHouseholdNameResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateHouseholdPreferences"></a>
# **updateHouseholdPreferences**
> UpdateHouseholdPreferencesResponse updateHouseholdPreferences(updateHouseholdPreferencesRequest)

Update household preferences

Patch any subset of household preference flags. All fields optional; omit to leave unchanged. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val updateHouseholdPreferencesRequest : UpdateHouseholdPreferencesRequest =  // UpdateHouseholdPreferencesRequest | 
try {
    val result : UpdateHouseholdPreferencesResponse = apiInstance.updateHouseholdPreferences(updateHouseholdPreferencesRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#updateHouseholdPreferences")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#updateHouseholdPreferences")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateHouseholdPreferencesRequest** | [**UpdateHouseholdPreferencesRequest**](UpdateHouseholdPreferencesRequest.md)|  | |

### Return type

[**UpdateHouseholdPreferencesResponse**](UpdateHouseholdPreferencesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateMe"></a>
# **updateMe**
> UpdateMeResponse updateMe(updateMeRequest)

Update current user profile

Patch the current user&#39;s profile fields. All fields optional; omit to leave unchanged. Updates &#x60;email&#x60;, &#x60;name&#x60;, &#x60;birthday&#x60;, or &#x60;timezone&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val updateMeRequest : UpdateMeRequest =  // UpdateMeRequest | 
try {
    val result : UpdateMeResponse = apiInstance.updateMe(updateMeRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#updateMe")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#updateMe")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateMeRequest** | [**UpdateMeRequest**](UpdateMeRequest.md)|  | |

### Return type

[**UpdateMeResponse**](UpdateMeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateNotificationPreferences"></a>
# **updateNotificationPreferences**
> UpdateNotificationPreferencesResponse updateNotificationPreferences(updateNotificationPreferencesRequest)

Update notification preferences

Toggle email / push / in-app delivery for one notification preference by id. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SettingsApi()
val updateNotificationPreferencesRequest : UpdateNotificationPreferencesRequest =  // UpdateNotificationPreferencesRequest | 
try {
    val result : UpdateNotificationPreferencesResponse = apiInstance.updateNotificationPreferences(updateNotificationPreferencesRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingsApi#updateNotificationPreferences")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingsApi#updateNotificationPreferences")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateNotificationPreferencesRequest** | [**UpdateNotificationPreferencesRequest**](UpdateNotificationPreferencesRequest.md)|  | |

### Return type

[**UpdateNotificationPreferencesResponse**](UpdateNotificationPreferencesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

