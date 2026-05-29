# User


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**email** | **string** |  | [optional] [default to undefined]
**name** | **string** |  | [optional] [default to undefined]
**displayName** | **string** |  | [optional] [default to undefined]
**birthday** | **string** |  | [optional] [default to undefined]
**timezone** | **string** |  | [optional] [default to undefined]
**hasPassword** | **boolean** |  | [optional] [default to undefined]
**hasMfaOn** | **boolean** |  | [optional] [default to undefined]
**isSuperuser** | **boolean** |  | [optional] [default to undefined]
**householdRole** | **string** |  | [optional] [default to undefined]
**externalAuthProviderNames** | **Array&lt;string&gt;** |  | [optional] [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]
**profilePictureUrl** | **string** |  | [optional] [default to undefined]
**profile** | [**UserProfileFlags**](UserProfileFlags.md) |  | [optional] [default to undefined]

## Example

```typescript
import { User } from 'monarch-bridge-client';

const instance: User = {
    id,
    email,
    name,
    displayName,
    birthday,
    timezone,
    hasPassword,
    hasMfaOn,
    isSuperuser,
    householdRole,
    externalAuthProviderNames,
    createdAt,
    profilePictureUrl,
    profile,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
