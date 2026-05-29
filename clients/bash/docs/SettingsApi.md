# SettingsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAppearance**](SettingsApi.md#getAppearance) | **GET** /v1/me/appearance | Appearance preferences
[**getCookiePreferences**](SettingsApi.md#getCookiePreferences) | **GET** /v1/me/cookies | Cookie preferences
[**getCurrency**](SettingsApi.md#getCurrency) | **GET** /v1/me/currency | Currency preferences
[**getEmailNotificationPrefs**](SettingsApi.md#getEmailNotificationPrefs) | **GET** /v1/preferences/notifications/email | Email notification preferences
[**getFiscalYear**](SettingsApi.md#getFiscalYear) | **GET** /v1/household/fiscal-year | Fiscal year preferences
[**getHouseholdMembers**](SettingsApi.md#getHouseholdMembers) | **GET** /v1/household/members | Household members
[**getHouseholdPreferences**](SettingsApi.md#getHouseholdPreferences) | **GET** /v1/household/preferences | Household preferences
[**getMe**](SettingsApi.md#getMe) | **GET** /v1/me | Current authenticated user
[**getMyHousehold**](SettingsApi.md#getMyHousehold) | **GET** /v1/household | My household
[**getNotificationPreferences**](SettingsApi.md#getNotificationPreferences) | **GET** /v1/notifications/preferences | Notification preferences
[**getPushNotificationPrefs**](SettingsApi.md#getPushNotificationPrefs) | **GET** /v1/preferences/notifications/push | Push notification preferences
[**inviteHouseholdMember**](SettingsApi.md#inviteHouseholdMember) | **POST** /v1/household/members/invite | Invite a household member
[**removeHouseholdMember**](SettingsApi.md#removeHouseholdMember) | **DELETE** /v1/household/members/{id} | Remove a household member
[**setCurrency**](SettingsApi.md#setCurrency) | **PUT** /v1/me/currency | Update currency preferences
[**setEmailNotificationPrefs**](SettingsApi.md#setEmailNotificationPrefs) | **PUT** /v1/preferences/notifications/email | Update email notification preferences
[**setFiscalYear**](SettingsApi.md#setFiscalYear) | **PUT** /v1/household/fiscal-year | Update fiscal year preferences
[**setPushNotificationPrefs**](SettingsApi.md#setPushNotificationPrefs) | **PUT** /v1/preferences/notifications/push | Update push notification preferences
[**updateAppearance**](SettingsApi.md#updateAppearance) | **PATCH** /v1/me/appearance | Update appearance preferences
[**updateCookiePreferences**](SettingsApi.md#updateCookiePreferences) | **PATCH** /v1/me/cookies | Update cookie preferences
[**updateHouseholdName**](SettingsApi.md#updateHouseholdName) | **PUT** /v1/household/name | Update household name
[**updateHouseholdPreferences**](SettingsApi.md#updateHouseholdPreferences) | **PATCH** /v1/household/preferences | Update household preferences
[**updateMe**](SettingsApi.md#updateMe) | **PATCH** /v1/me | Update current user profile
[**updateNotificationPreferences**](SettingsApi.md#updateNotificationPreferences) | **PATCH** /v1/notifications/preferences | Update notification preferences



## getAppearance

Appearance preferences

User-scoped appearance settings: theme ('light' / 'dark' / 'system'),
accent color, compact-mode toggle.

### Example

```bash
monarch-api getAppearance
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetAppearance200Response**](GetAppearance200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCookiePreferences

Cookie preferences

Per-category cookie consent (analytics, marketing, functional).
The web app fires this on first paint to decide what to gate behind
the consent banner.

### Example

```bash
monarch-api getCookiePreferences
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetCookiePreferences200Response**](GetCookiePreferences200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCurrency

Currency preferences

User's default display currency. Returns the ISO currency code plus
Monarch's render hints (symbol + before/after position).

### Example

```bash
monarch-api getCurrency
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetCurrency200Response**](GetCurrency200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getEmailNotificationPrefs

Email notification preferences

Per-topic email delivery toggles (weeklyRecap, budgetAlerts,
billReminders, goalUpdates, marketingTips). Returned as a flat
boolean map.

### Example

```bash
monarch-api getEmailNotificationPrefs
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetEmailNotificationPrefs200Response**](GetEmailNotificationPrefs200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getFiscalYear

Fiscal year preferences

Household fiscal-year start month + day. Drives \"year-to-date\" rollups
in reports for households on a non-calendar fiscal year.

### Example

```bash
monarch-api getFiscalYear
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetFiscalYear200Response**](GetFiscalYear200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getHouseholdMembers

Household members

Every user who shares this household, plus the id of the caller
('meId') so the client can highlight \"you\" in member lists.

### Example

```bash
monarch-api getHouseholdMembers
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetHouseholdMembers200Response**](GetHouseholdMembers200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getHouseholdPreferences

Household preferences

Household-wide feature flags + review settings. Examples:
'newTransactionsNeedReview', 'aiAssistantEnabled',
'investmentTransactionsEnabled', 'excludeBusinessFromBudget'.

### Example

```bash
monarch-api getHouseholdPreferences
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetHouseholdPreferences200Response**](GetHouseholdPreferences200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getMe

Current authenticated user

Returns the Monarch user the bridge is authenticated as. Includes
'email', 'name', 'displayName', 'timezone', 'birthday', 'householdRole',
plus auth-state flags ('hasPassword', 'hasMfaOn').

Use for \"who am I\" checks and for profile-form pre-population.

### Example

```bash
monarch-api getMe
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetMe200Response**](GetMe200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getMyHousehold

My household

Household-level metadata (name, mailing address). One row per Monarch
household; every member of the household sees the same value.

### Example

```bash
monarch-api getMyHousehold
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetMyHousehold200Response**](GetMyHousehold200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getNotificationPreferences

Notification preferences

Per-channel notification preferences (email, push, in-app) grouped
by notification type.

### Example

```bash
monarch-api getNotificationPreferences
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetNotificationPreferences200Response**](GetNotificationPreferences200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getPushNotificationPrefs

Push notification preferences

Per-topic push delivery toggles (weeklyRecap, budgetAlerts,
billReminders, goalUpdates, marketingTips). Returned as a flat
boolean map.

### Example

```bash
monarch-api getPushNotificationPrefs
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetEmailNotificationPrefs200Response**](GetEmailNotificationPrefs200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## inviteHouseholdMember

Invite a household member

Send a Monarch invitation email to a new household member. 'email' is
required; 'role' is optional and defaults to 'member' (one of 'owner',
'member', 'viewer').

### Example

```bash
monarch-api inviteHouseholdMember
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inviteHouseholdMemberRequest** | [**InviteHouseholdMemberRequest**](InviteHouseholdMemberRequest.md) |  |

### Return type

[**InviteHouseholdMember200Response**](InviteHouseholdMember200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## removeHouseholdMember

Remove a household member

Remove a member from the household. Idempotent - re-calling with a
member id that's already removed returns 'removed=true'.

### Example

```bash
monarch-api removeHouseholdMember id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch household-member (user) id. | [default to null]

### Return type

[**RemoveHouseholdMember200Response**](RemoveHouseholdMember200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## setCurrency

Update currency preferences

Set the user's default display currency. 'currency' is required (ISO
code, e.g. 'USD', 'EUR'). 'position' is optional (\"before\" / \"after\").

### Example

```bash
monarch-api setCurrency
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **setCurrencyRequest** | [**SetCurrencyRequest**](SetCurrencyRequest.md) |  |

### Return type

[**SetCurrency200Response**](SetCurrency200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## setEmailNotificationPrefs

Update email notification preferences

Patch any subset of the email-channel toggles. Omit a field to leave
it untouched.

### Example

```bash
monarch-api setEmailNotificationPrefs
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **setEmailNotificationPrefsRequest** | [**SetEmailNotificationPrefsRequest**](SetEmailNotificationPrefsRequest.md) |  |

### Return type

[**GetEmailNotificationPrefs200Response**](GetEmailNotificationPrefs200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## setFiscalYear

Update fiscal year preferences

Set the household fiscal-year start. 'startMonth' is required (1-12);
'startDay' is optional (1-31, defaults to 1).

### Example

```bash
monarch-api setFiscalYear
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **setFiscalYearRequest** | [**SetFiscalYearRequest**](SetFiscalYearRequest.md) |  |

### Return type

[**SetFiscalYear200Response**](SetFiscalYear200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## setPushNotificationPrefs

Update push notification preferences

Patch any subset of the push-channel toggles. Omit a field to leave
it untouched.

### Example

```bash
monarch-api setPushNotificationPrefs
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **setEmailNotificationPrefsRequest** | [**SetEmailNotificationPrefsRequest**](SetEmailNotificationPrefsRequest.md) |  |

### Return type

[**GetEmailNotificationPrefs200Response**](GetEmailNotificationPrefs200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateAppearance

Update appearance preferences

Patch one or more appearance preferences. Only populated fields are
forwarded; omit a field to leave it untouched.

### Example

```bash
monarch-api updateAppearance
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateAppearanceRequest** | [**UpdateAppearanceRequest**](UpdateAppearanceRequest.md) |  |

### Return type

[**GetAppearance200Response**](GetAppearance200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateCookiePreferences

Update cookie preferences

Patch any subset of cookie consents. Omit a field to leave it
untouched. The web app calls this from the \"Accept selected\" button
on the cookie banner and from the Settings → Privacy → Cookies page.

### Example

```bash
monarch-api updateCookiePreferences
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateCookiePreferencesRequest** | [**UpdateCookiePreferencesRequest**](UpdateCookiePreferencesRequest.md) |  |

### Return type

[**GetCookiePreferences200Response**](GetCookiePreferences200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateHouseholdName

Update household name

Rename the household. The new name appears in invitation emails and
on every member's home screen.

### Example

```bash
monarch-api updateHouseholdName
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateHouseholdNameRequest** | [**UpdateHouseholdNameRequest**](UpdateHouseholdNameRequest.md) |  |

### Return type

[**UpdateHouseholdName200Response**](UpdateHouseholdName200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateHouseholdPreferences

Update household preferences

Patch any subset of household preference flags. All fields optional;
omit to leave unchanged.

### Example

```bash
monarch-api updateHouseholdPreferences
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateHouseholdPreferencesRequest** | [**UpdateHouseholdPreferencesRequest**](UpdateHouseholdPreferencesRequest.md) |  |

### Return type

[**UpdateHouseholdPreferences200Response**](UpdateHouseholdPreferences200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateMe

Update current user profile

Patch the current user's profile fields. All fields optional; omit to
leave unchanged. Updates 'email', 'name', 'birthday', or 'timezone'.

### Example

```bash
monarch-api updateMe
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateMeRequest** | [**UpdateMeRequest**](UpdateMeRequest.md) |  |

### Return type

[**UpdateMe200Response**](UpdateMe200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateNotificationPreferences

Update notification preferences

Toggle email / push / in-app delivery for one notification
preference by id.

### Example

```bash
monarch-api updateNotificationPreferences
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateNotificationPreferencesRequest** | [**UpdateNotificationPreferencesRequest**](UpdateNotificationPreferencesRequest.md) |  |

### Return type

[**UpdateNotificationPreferences200Response**](UpdateNotificationPreferences200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

