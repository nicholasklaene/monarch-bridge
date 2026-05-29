# WeeklyRecapCard

One module-specific card within a weekly recap (cashflow, biggest spend, etc.).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**module** | **string** | Card module identifier (e.g. &#x60;cashflow&#x60;, &#x60;top_categories&#x60;). | [default to undefined]
**title** | **string** |  | [optional] [default to undefined]
**headline** | **string** |  | [optional] [default to undefined]
**message** | **string** |  | [optional] [default to undefined]
**sentiment** | **string** | Monarch\&#39;s tone tag (e.g. &#x60;positive&#x60;, &#x60;neutral&#x60;, &#x60;warning&#x60;). | [optional] [default to undefined]
**titleMarkdown** | **string** |  | [optional] [default to undefined]
**headlineMarkdown** | **string** |  | [optional] [default to undefined]
**messageMarkdown** | **string** |  | [optional] [default to undefined]
**metrics** | **{ [key: string]: any; }** | Free-form numeric metrics rendered inside the card. | [optional] [default to undefined]
**richBlocks** | **{ [key: string]: any; }** | Free-form rich-text block tree. | [optional] [default to undefined]

## Example

```typescript
import { WeeklyRecapCard } from 'monarch-bridge-client';

const instance: WeeklyRecapCard = {
    module,
    title,
    headline,
    message,
    sentiment,
    titleMarkdown,
    headlineMarkdown,
    messageMarkdown,
    metrics,
    richBlocks,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
