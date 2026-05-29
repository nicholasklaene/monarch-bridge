# TransactionAttachment

Monarch\'s representation of a file attached to a transaction.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**publicId** | **string** | Cloudinary public id; durable handle for the binary. | [optional] [default to undefined]
**extension** | **string** |  | [optional] [default to undefined]
**sizeBytes** | **number** |  | [optional] [default to undefined]
**filename** | **string** |  | [optional] [default to undefined]
**originalAssetUrl** | **string** | Signed URL clients can use to fetch the original binary. | [optional] [default to undefined]

## Example

```typescript
import { TransactionAttachment } from 'monarch-bridge-client';

const instance: TransactionAttachment = {
    id,
    publicId,
    extension,
    sizeBytes,
    filename,
    originalAssetUrl,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
