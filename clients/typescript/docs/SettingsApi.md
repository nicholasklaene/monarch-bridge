# SettingsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**getAppearance**](#getappearance) | **GET** /v1/me/appearance | Appearance preferences|
|[**getCookiePreferences**](#getcookiepreferences) | **GET** /v1/me/cookies | Cookie preferences|
|[**getCurrency**](#getcurrency) | **GET** /v1/me/currency | Currency preferences|
|[**getEmailNotificationPrefs**](#getemailnotificationprefs) | **GET** /v1/preferences/notifications/email | Email notification preferences|
|[**getFiscalYear**](#getfiscalyear) | **GET** /v1/household/fiscal-year | Fiscal year preferences|
|[**getHouseholdMembers**](#gethouseholdmembers) | **GET** /v1/household/members | Household members|
|[**getHouseholdPreferences**](#gethouseholdpreferences) | **GET** /v1/household/preferences | Household preferences|
|[**getMe**](#getme) | **GET** /v1/me | Current authenticated user|
|[**getMyHousehold**](#getmyhousehold) | **GET** /v1/household | My household|
|[**getNotificationPreferences**](#getnotificationpreferences) | **GET** /v1/notifications/preferences | Notification preferences|
|[**getPushNotificationPrefs**](#getpushnotificationprefs) | **GET** /v1/preferences/notifications/push | Push notification preferences|
|[**inviteHouseholdMember**](#invitehouseholdmember) | **POST** /v1/household/members/invite | Invite a household member|
|[**removeHouseholdMember**](#removehouseholdmember) | **DELETE** /v1/household/members/{id} | Remove a household member|
|[**setCurrency**](#setcurrency) | **PUT** /v1/me/currency | Update currency preferences|
|[**setEmailNotificationPrefs**](#setemailnotificationprefs) | **PUT** /v1/preferences/notifications/email | Update email notification preferences|
|[**setFiscalYear**](#setfiscalyear) | **PUT** /v1/household/fiscal-year | Update fiscal year preferences|
|[**setPushNotificationPrefs**](#setpushnotificationprefs) | **PUT** /v1/preferences/notifications/push | Update push notification preferences|
|[**updateAppearance**](#updateappearance) | **PATCH** /v1/me/appearance | Update appearance preferences|
|[**updateCookiePreferences**](#updatecookiepreferences) | **PATCH** /v1/me/cookies | Update cookie preferences|
|[**updateHouseholdName**](#updatehouseholdname) | **PUT** /v1/household/name | Update household name|
|[**updateHouseholdPreferences**](#updatehouseholdpreferences) | **PATCH** /v1/household/preferences | Update household preferences|
|[**updateMe**](#updateme) | **PATCH** /v1/me | Update current user profile|
|[**updateNotificationPreferences**](#updatenotificationpreferences) | **PATCH** /v1/notifications/preferences | Update notification preferences|

# **getAppearance**
> GetAppearanceResponse getAppearance()

User-scoped appearance settings: theme (`light` / `dark` / `system`), accent color, compact-mode toggle. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getAppearance();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetAppearanceResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Appearance preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCookiePreferences**
> GetCookiePreferencesResponse getCookiePreferences()

Per-category cookie consent (analytics, marketing, functional). The web app fires this on first paint to decide what to gate behind the consent banner. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getCookiePreferences();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetCookiePreferencesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Current cookie consents. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCurrency**
> GetCurrencyResponse getCurrency()

User\'s default display currency. Returns the ISO currency code plus Monarch\'s render hints (symbol + before/after position). 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getCurrency();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetCurrencyResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Current currency preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getEmailNotificationPrefs**
> GetEmailNotificationPrefsResponse getEmailNotificationPrefs()

Per-topic email delivery toggles (weeklyRecap, budgetAlerts, billReminders, goalUpdates, marketingTips). Returned as a flat boolean map. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getEmailNotificationPrefs();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetEmailNotificationPrefsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Email notification preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getFiscalYear**
> GetFiscalYearResponse getFiscalYear()

Household fiscal-year start month + day. Drives \"year-to-date\" rollups in reports for households on a non-calendar fiscal year. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getFiscalYear();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetFiscalYearResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Current fiscal-year settings. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getHouseholdMembers**
> GetHouseholdMembersResponse getHouseholdMembers()

Every user who shares this household, plus the id of the caller (`meId`) so the client can highlight \"you\" in member lists. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getHouseholdMembers();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetHouseholdMembersResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Member list + caller id. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getHouseholdPreferences**
> GetHouseholdPreferencesResponse getHouseholdPreferences()

Household-wide feature flags + review settings. Examples: `newTransactionsNeedReview`, `aiAssistantEnabled`, `investmentTransactionsEnabled`, `excludeBusinessFromBudget`. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getHouseholdPreferences();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetHouseholdPreferencesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Preferences object. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMe**
> GetMeResponse getMe()

Returns the Monarch user the bridge is authenticated as. Includes `email`, `name`, `displayName`, `timezone`, `birthday`, `householdRole`, plus auth-state flags (`hasPassword`, `hasMfaOn`).  Use for \"who am I\" checks and for profile-form pre-population. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getMe();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetMeResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | The current user profile. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMyHousehold**
> GetMyHouseholdResponse getMyHousehold()

Household-level metadata (name, mailing address). One row per Monarch household; every member of the household sees the same value. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getMyHousehold();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetMyHouseholdResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Household record. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getNotificationPreferences**
> GetNotificationPreferencesResponse getNotificationPreferences()

Per-channel notification preferences (email, push, in-app) grouped by notification type. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getNotificationPreferences();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetNotificationPreferencesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Preferences list. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getPushNotificationPrefs**
> GetEmailNotificationPrefsResponse getPushNotificationPrefs()

Per-topic push delivery toggles (weeklyRecap, budgetAlerts, billReminders, goalUpdates, marketingTips). Returned as a flat boolean map. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

const { status, data } = await apiInstance.getPushNotificationPrefs();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetEmailNotificationPrefsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Push notification preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **inviteHouseholdMember**
> InviteHouseholdMemberResponse inviteHouseholdMember(inviteHouseholdMemberRequest)

Send a Monarch invitation email to a new household member. `email` is required; `role` is optional and defaults to `member` (one of `owner`, `member`, `viewer`). 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    InviteHouseholdMemberRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let inviteHouseholdMemberRequest: InviteHouseholdMemberRequest; //

const { status, data } = await apiInstance.inviteHouseholdMember(
    inviteHouseholdMemberRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **inviteHouseholdMemberRequest** | **InviteHouseholdMemberRequest**|  | |


### Return type

**InviteHouseholdMemberResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Invitation queued. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **removeHouseholdMember**
> RemoveHouseholdMemberResponse removeHouseholdMember()

Remove a member from the household. Idempotent - re-calling with a member id that\'s already removed returns `removed=true`. 

### Example

```typescript
import {
    SettingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let id: string; //Monarch household-member (user) id. (default to undefined)

const { status, data } = await apiInstance.removeHouseholdMember(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch household-member (user) id. | defaults to undefined|


### Return type

**RemoveHouseholdMemberResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Removal confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setCurrency**
> SetCurrencyResponse setCurrency(setCurrencyRequest)

Set the user\'s default display currency. `currency` is required (ISO code, e.g. `USD`, `EUR`). `position` is optional (\"before\" / \"after\"). 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    SetCurrencyRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let setCurrencyRequest: SetCurrencyRequest; //

const { status, data } = await apiInstance.setCurrency(
    setCurrencyRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **setCurrencyRequest** | **SetCurrencyRequest**|  | |


### Return type

**SetCurrencyResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated currency preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setEmailNotificationPrefs**
> GetEmailNotificationPrefsResponse setEmailNotificationPrefs(setEmailNotificationPrefsRequest)

Patch any subset of the email-channel toggles. Omit a field to leave it untouched. 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    SetEmailNotificationPrefsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let setEmailNotificationPrefsRequest: SetEmailNotificationPrefsRequest; //

const { status, data } = await apiInstance.setEmailNotificationPrefs(
    setEmailNotificationPrefsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **setEmailNotificationPrefsRequest** | **SetEmailNotificationPrefsRequest**|  | |


### Return type

**GetEmailNotificationPrefsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated email notification preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setFiscalYear**
> SetFiscalYearResponse setFiscalYear(setFiscalYearRequest)

Set the household fiscal-year start. `startMonth` is required (1-12); `startDay` is optional (1-31, defaults to 1). 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    SetFiscalYearRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let setFiscalYearRequest: SetFiscalYearRequest; //

const { status, data } = await apiInstance.setFiscalYear(
    setFiscalYearRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **setFiscalYearRequest** | **SetFiscalYearRequest**|  | |


### Return type

**SetFiscalYearResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated fiscal-year settings. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setPushNotificationPrefs**
> GetEmailNotificationPrefsResponse setPushNotificationPrefs(setEmailNotificationPrefsRequest)

Patch any subset of the push-channel toggles. Omit a field to leave it untouched. 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    SetEmailNotificationPrefsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let setEmailNotificationPrefsRequest: SetEmailNotificationPrefsRequest; //

const { status, data } = await apiInstance.setPushNotificationPrefs(
    setEmailNotificationPrefsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **setEmailNotificationPrefsRequest** | **SetEmailNotificationPrefsRequest**|  | |


### Return type

**GetEmailNotificationPrefsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated push notification preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateAppearance**
> GetAppearanceResponse updateAppearance(updateAppearanceRequest)

Patch one or more appearance preferences. Only populated fields are forwarded; omit a field to leave it untouched. 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    UpdateAppearanceRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let updateAppearanceRequest: UpdateAppearanceRequest; //

const { status, data } = await apiInstance.updateAppearance(
    updateAppearanceRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateAppearanceRequest** | **UpdateAppearanceRequest**|  | |


### Return type

**GetAppearanceResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated appearance. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateCookiePreferences**
> GetCookiePreferencesResponse updateCookiePreferences(updateCookiePreferencesRequest)

Patch any subset of cookie consents. Omit a field to leave it untouched. The web app calls this from the \"Accept selected\" button on the cookie banner and from the Settings → Privacy → Cookies page. 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    UpdateCookiePreferencesRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let updateCookiePreferencesRequest: UpdateCookiePreferencesRequest; //

const { status, data } = await apiInstance.updateCookiePreferences(
    updateCookiePreferencesRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateCookiePreferencesRequest** | **UpdateCookiePreferencesRequest**|  | |


### Return type

**GetCookiePreferencesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated cookie consents. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateHouseholdName**
> UpdateHouseholdNameResponse updateHouseholdName(updateHouseholdNameRequest)

Rename the household. The new name appears in invitation emails and on every member\'s home screen. 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    UpdateHouseholdNameRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let updateHouseholdNameRequest: UpdateHouseholdNameRequest; //

const { status, data } = await apiInstance.updateHouseholdName(
    updateHouseholdNameRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateHouseholdNameRequest** | **UpdateHouseholdNameRequest**|  | |


### Return type

**UpdateHouseholdNameResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated household record. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateHouseholdPreferences**
> UpdateHouseholdPreferencesResponse updateHouseholdPreferences(updateHouseholdPreferencesRequest)

Patch any subset of household preference flags. All fields optional; omit to leave unchanged. 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    UpdateHouseholdPreferencesRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let updateHouseholdPreferencesRequest: UpdateHouseholdPreferencesRequest; //

const { status, data } = await apiInstance.updateHouseholdPreferences(
    updateHouseholdPreferencesRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateHouseholdPreferencesRequest** | **UpdateHouseholdPreferencesRequest**|  | |


### Return type

**UpdateHouseholdPreferencesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated preferences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateMe**
> UpdateMeResponse updateMe(updateMeRequest)

Patch the current user\'s profile fields. All fields optional; omit to leave unchanged. Updates `email`, `name`, `birthday`, or `timezone`. 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    UpdateMeRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let updateMeRequest: UpdateMeRequest; //

const { status, data } = await apiInstance.updateMe(
    updateMeRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateMeRequest** | **UpdateMeRequest**|  | |


### Return type

**UpdateMeResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated user profile. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateNotificationPreferences**
> UpdateNotificationPreferencesResponse updateNotificationPreferences(updateNotificationPreferencesRequest)

Toggle email / push / in-app delivery for one notification preference by id. 

### Example

```typescript
import {
    SettingsApi,
    Configuration,
    UpdateNotificationPreferencesRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SettingsApi(configuration);

let updateNotificationPreferencesRequest: UpdateNotificationPreferencesRequest; //

const { status, data } = await apiInstance.updateNotificationPreferences(
    updateNotificationPreferencesRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateNotificationPreferencesRequest** | **UpdateNotificationPreferencesRequest**|  | |


### Return type

**UpdateNotificationPreferencesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated preference. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

