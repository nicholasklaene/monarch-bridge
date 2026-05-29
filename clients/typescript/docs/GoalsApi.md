# GoalsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**archiveGoal**](#archivegoal) | **DELETE** /v1/goals/{id} | Archive a savings goal|
|[**contributeToGoal**](#contributetogoal) | **POST** /v1/goals/{id}/contributions | Record a contribution to a savings goal|
|[**createGoal**](#creategoal) | **POST** /v1/goals | Create a new savings or debt-payoff goal|
|[**deleteGoalV2**](#deletegoalv2) | **DELETE** /v1/goals/{id}/v2-delete | Delete a goal (v2 mutation)|
|[**getGoal**](#getgoal) | **GET** /v1/goals/{id} | Get one savings goal|
|[**getGoalContributionHistory**](#getgoalcontributionhistory) | **GET** /v1/goals/{id}/contribution-history | Goal contribution history|
|[**getGoalProjection**](#getgoalprojection) | **GET** /v1/goals/{id}/projection | Goal projection chart|
|[**getGoalsCurrentMonthTotals**](#getgoalscurrentmonthtotals) | **GET** /v1/goals/totals/current-month | Current-month planned-contribution totals per goal|
|[**hardDeleteGoal**](#harddeletegoal) | **DELETE** /v1/goals/{id}/hard | Hard-delete a savings goal|
|[**linkTransactionToGoal**](#linktransactiontogoal) | **POST** /v1/transactions/{id}/goal-link | Link a transaction to a savings goal|
|[**listGoalEvents**](#listgoalevents) | **GET** /v1/goals/{id}/events | Event log for one savings goal|
|[**listGoals**](#listgoals) | **GET** /v1/goals | List all savings goals|
|[**markGoalComplete**](#markgoalcomplete) | **POST** /v1/goals/{id}/complete | Mark a goal complete|
|[**markGoalIncomplete**](#markgoalincomplete) | **POST** /v1/goals/{id}/incomplete | Mark a goal incomplete|
|[**setGoalBudgetAmount**](#setgoalbudgetamount) | **PUT** /v1/goals/{id}/budget | Set monthly budget allocation for a savings goal|
|[**spendFromGoal**](#spendfromgoal) | **POST** /v1/goals/{id}/spend | Spend from a savings goal|
|[**unarchiveGoal**](#unarchivegoal) | **POST** /v1/goals/{id}/unarchive | Un-archive a savings goal|
|[**unlinkTransactionGoalRecords**](#unlinktransactiongoalrecords) | **DELETE** /v1/transactions/{id}/goal-link | Unlink any goal-reconciliation records for a transaction|
|[**updateGoal**](#updategoal) | **PATCH** /v1/goals/{id} | Update a savings goal|
|[**updateGoalsPriorities**](#updategoalspriorities) | **PUT** /v1/goals/priorities | Re-order savings goals by priority|
|[**withdrawFromGoal**](#withdrawfromgoal) | **POST** /v1/goals/{id}/withdraw | Withdraw from a savings goal|

# **archiveGoal**
> CreateGoalResponse archiveGoal()

**Soft-deletes** the goal by setting its `archivedAt` timestamp. The goal remains visible via `GET /v1/goals` (filter on `archivedAt` to hide) but its `status` flips to `archived` and it drops out of active-goal aggregates.  Reversible via `POST /v1/goals/{id}/unarchive`. For permanent removal use `DELETE /v1/goals/{id}/hard` instead. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)

const { status, data } = await apiInstance.archiveGoal(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**CreateGoalResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | The archived goal. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **contributeToGoal**
> ContributeToGoalResponse contributeToGoal(contributeToGoalRequest)

Logs a contribution event against a goal from a specific account. Required: `accountId` and `amount` (in dollars, positive for a contribution, negative for a withdrawal). `date` defaults to today if omitted.  Use after a manual transfer the user wants attributed to the goal, or to backfill historical progress. Updates the goal\'s `currentAmount` and appends to its event log (visible via `GET /v1/goals/{id}/events`).  Distinct from `PUT /v1/goals/{id}/budget` which sets the planned monthly contribution (forecast) rather than logging an actual one. 

### Example

```typescript
import {
    GoalsApi,
    Configuration,
    ContributeToGoalRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)
let contributeToGoalRequest: ContributeToGoalRequest; //

const { status, data } = await apiInstance.contributeToGoal(
    id,
    contributeToGoalRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **contributeToGoalRequest** | **ContributeToGoalRequest**|  | |
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**ContributeToGoalResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated goal balance + event metadata. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createGoal**
> CreateGoalResponse createGoal(createGoalRequest)

Creates one savings goal. Wraps Monarch\'s `createSavingsGoals` batch mutation with a single-goal body for ergonomics.  Required: `name` and `targetAmount`. Optional: `targetDate`, `imageStorageProvider`/`imageStorageProviderId` for an icon, `accounts` to pre-link funding accounts. `type` defaults to `\"savings\"`; pass `\"debt\"` for a debt-payoff goal (sign convention flips: progress = paying it DOWN).  Once created, set up monthly contributions via `PUT /v1/goals/{id}/budget` and log actuals via `POST /v1/goals/{id}/contributions`. 

### Example

```typescript
import {
    GoalsApi,
    Configuration,
    CreateGoalRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let createGoalRequest: CreateGoalRequest; //

const { status, data } = await apiInstance.createGoal(
    createGoalRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createGoalRequest** | **CreateGoalRequest**|  | |


### Return type

**CreateGoalResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New goal. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteGoalV2**
> MarkTransactionStreamAsNotRecurringResponse deleteGoalV2()

Permanently delete a savings goal via the v2 `deleteGoalV2` mutation. Distinct from `DELETE /v1/goals/{id}/hard` (which uses the legacy `deleteSavingsGoal` path); the v2 path is preferred for goals created through the v2 flow.  Returns a flat `success` boolean and any payload errors. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)

const { status, data } = await apiInstance.deleteGoalV2(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**MarkTransactionStreamAsNotRecurringResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Deletion result. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getGoal**
> CreateGoalResponse getGoal()

Returns the full detail for a single v2 savings goal: name, target amount, current balance, target date, type (savings or debt), priority, linked accounts, and archive state.  Use to surface a goal in a detail view or to inspect state before a PATCH or contribution. For the contribution / withdrawal event log use `GET /v1/goals/{id}/events`. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)

const { status, data } = await apiInstance.getGoal(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**CreateGoalResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | The goal. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getGoalContributionHistory**
> GetGoalContributionHistoryResponse getGoalContributionHistory()

Ledger of contributions logged against one goal: date, amount, source account, optional notes. Distinct from `/v1/goals/{id}/events` which includes auto-linked transactions too; this endpoint returns only explicit contributions. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)

const { status, data } = await apiInstance.getGoalContributionHistory(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**GetGoalContributionHistoryResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Contribution ledger. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getGoalProjection**
> GetGoalProjectionResponse getGoalProjection()

Forward projection of a goal\'s balance at the current planned contribution rate. Returns the projected completion date, months to target, and a per-month projected-balance series. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)

const { status, data } = await apiInstance.getGoalProjection(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**GetGoalProjectionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Projection data. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getGoalsCurrentMonthTotals**
> GetGoalsCurrentMonthTotalsResponse getGoalsCurrentMonthTotals()

Returns the sum of `totalPlannedAmount` across the requested month window, broken out per goal. Used for \"how much am I planning to contribute this month and to which goals\" rollups without pulling each goal\'s full plan series.  Defaults to the current calendar month when both params are omitted (`startMonth = first-of-this-month`, `endMonth = first-of-this-month`). Pass a wider window to get a multi-month plan summary. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let startMonth: string; //First-of-month lower bound (`YYYY-MM-DD`). (optional) (default to undefined)
let endMonth: string; //First-of-month upper bound (`YYYY-MM-DD`). (optional) (default to undefined)

const { status, data } = await apiInstance.getGoalsCurrentMonthTotals(
    startMonth,
    endMonth
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **startMonth** | [**string**] | First-of-month lower bound (&#x60;YYYY-MM-DD&#x60;). | (optional) defaults to undefined|
| **endMonth** | [**string**] | First-of-month upper bound (&#x60;YYYY-MM-DD&#x60;). | (optional) defaults to undefined|


### Return type

**GetGoalsCurrentMonthTotalsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-goal totals for the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **hardDeleteGoal**
> HardDeleteGoalResponse hardDeleteGoal()

Permanently removes the goal. **No undo**. Distinct from `DELETE /v1/goals/{id}` (which archives / soft-deletes and is reversible via the unarchive endpoint).  After this call the goal disappears from `GET /v1/goals` entirely and its event log is no longer queryable. Use only when the user explicitly wants to purge a goal, not for routine cleanup. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)

const { status, data } = await apiInstance.hardDeleteGoal(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**HardDeleteGoalResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Confirmation of hard delete. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **linkTransactionToGoal**
> LinkTransactionToGoalResponse linkTransactionToGoal(linkTransactionToGoalRequest)

Create a goal-event that ties a single transaction to a goal. The transaction\'s `savingsGoalEvent` becomes non-null and the goal balance reconciliation picks it up. Used to credit a specific purchase (\"plane tickets\") against the matching goal (\"Vacation\").  Pair with `DELETE /v1/transactions/{id}/goal-link` to unlink. 

### Example

```typescript
import {
    GoalsApi,
    Configuration,
    LinkTransactionToGoalRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)
let linkTransactionToGoalRequest: LinkTransactionToGoalRequest; //

const { status, data } = await apiInstance.linkTransactionToGoal(
    id,
    linkTransactionToGoalRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **linkTransactionToGoalRequest** | **LinkTransactionToGoalRequest**|  | |
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**LinkTransactionToGoalResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Linkage created. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listGoalEvents**
> ListGoalEventsResponse listGoalEvents()

Returns the full event ledger for a single goal: every contribution, withdrawal, and transaction Monarch auto-linked to the goal. Each event has type, amount, date, account, and source transaction id (if any).  Use to surface a \"history\" tab on a goal detail view or to compute actual-vs-planned contribution totals over time. For a quick current-month rollup across all goals use `GET /v1/goals/current-month-totals`. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)

const { status, data } = await apiInstance.listGoalEvents(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**ListGoalEventsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All goal events, newest-first per upstream order. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listGoals**
> ListGoalsResponse listGoals()

Returns every v2 savings goal: active, archived, hard-deleted-but- soft-still-visible, debt and savings types together. Each entry carries name, target amount, current progress, priority, linked accounts, and `archivedAt`.  Filter client-side on `archivedAt == null` to hide archived. Sort on `priority` for the user\'s intended display order. For one goal\'s detail use `GET /v1/goals/{id}`; for the event log use `GET /v1/goals/{id}/events`. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

const { status, data } = await apiInstance.listGoals();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**ListGoalsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All savings goals. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **markGoalComplete**
> MarkGoalCompleteResponse markGoalComplete()

Stamp a savings goal `completedAt=now`. Surfaces a celebration in the UI and freezes the goal balance display. Idempotent - replays do not re-trigger the celebration.  Pair with `POST /v1/goals/{id}/incomplete` to un-mark a goal that was marked complete by mistake. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)

const { status, data } = await apiInstance.markGoalComplete(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**MarkGoalCompleteResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated completion state. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **markGoalIncomplete**
> MarkGoalCompleteResponse markGoalIncomplete()

Clear a savings goal\'s `completedAt`, reverting it back to \"in progress\". Used to undo a `POST /v1/goals/{id}/complete` performed in error. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)

const { status, data } = await apiInstance.markGoalIncomplete(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**MarkGoalCompleteResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated completion state. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setGoalBudgetAmount**
> MarkTransactionStreamAsNotRecurringResponse setGoalBudgetAmount(setGoalBudgetAmountRequest)

Sets the planned contribution amount for a goal for one month, or (with `applyToFuture: true`) cascades the same amount to every subsequent month. This is the FORECAST, not a recorded contribution: use `POST /v1/goals/{id}/contributions` to log actual money in.  Required: `startDate` (first-of-month) and `amount`. `accountId` is optional: omit to set the household-level planned amount; supply when the contribution comes from one specific account.  Pairs with `GET /v1/goals/current-month-totals` to read back the planned totals. 

### Example

```typescript
import {
    GoalsApi,
    Configuration,
    SetGoalBudgetAmountRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)
let setGoalBudgetAmountRequest: SetGoalBudgetAmountRequest; //

const { status, data } = await apiInstance.setGoalBudgetAmount(
    id,
    setGoalBudgetAmountRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **setGoalBudgetAmountRequest** | **SetGoalBudgetAmountRequest**|  | |
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**MarkTransactionStreamAsNotRecurringResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Confirmation flag from Monarch. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **spendFromGoal**
> SpendFromGoalResponse spendFromGoal(spendFromGoalRequest)

Record a spend event against a savings goal - i.e. \"I used some of my `Vacation` goal balance to pay for the flight\". Pair with `POST /v1/goals/{id}/contributions` (contributions) and `POST /v1/goals/{id}/withdraw` (withdrawals back to source account).  Returns the created goal-event id. 

### Example

```typescript
import {
    GoalsApi,
    Configuration,
    SpendFromGoalRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)
let spendFromGoalRequest: SpendFromGoalRequest; //

const { status, data } = await apiInstance.spendFromGoal(
    id,
    spendFromGoalRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **spendFromGoalRequest** | **SpendFromGoalRequest**|  | |
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**SpendFromGoalResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Created spend event. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unarchiveGoal**
> CreateGoalResponse unarchiveGoal()

Restores a previously archived goal back to active state. Inverse of `DELETE /v1/goals/{id}`: clears the upstream `archivedAt` timestamp and flips `status` back to `active`.  Use when a user accidentally archived a goal or wants to revive an old one. No-op if the goal is already active. For permanent removal use `DELETE /v1/goals/{id}/hard` (no undo). 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)

const { status, data } = await apiInstance.unarchiveGoal(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**CreateGoalResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | The restored goal. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unlinkTransactionGoalRecords**
> MarkTransactionStreamAsNotRecurringResponse unlinkTransactionGoalRecords()

Drops all goal-reconciliation records for one transaction (the inverse of `POST /v1/transactions/{id}/goal-link`). The transaction stops being credited against any goal. 

### Example

```typescript
import {
    GoalsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)

const { status, data } = await apiInstance.unlinkTransactionGoalRecords(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**MarkTransactionStreamAsNotRecurringResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Deletion result. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateGoal**
> CreateGoalResponse updateGoal(updateGoalRequest)

Patches one goal. Only populated fields are forwarded to Monarch; omit a field to leave it untouched.  Common edits: rename, change `targetAmount` or `targetDate`, re-link `accounts`, update the icon. To re-order priority across goals use `PUT /v1/goals/priorities` instead. To archive use `DELETE /v1/goals/{id}` (reversible) or `DELETE /v1/goals/{id}/hard` (permanent). 

### Example

```typescript
import {
    GoalsApi,
    Configuration,
    UpdateGoalRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)
let updateGoalRequest: UpdateGoalRequest; //

const { status, data } = await apiInstance.updateGoal(
    id,
    updateGoalRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateGoalRequest** | **UpdateGoalRequest**|  | |
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**CreateGoalResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | The updated goal. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateGoalsPriorities**
> UpdateGoalsPrioritiesResponse updateGoalsPriorities(updateGoalsPrioritiesRequest)

Reorders goals by sending the full id list in the desired order. The proxy assigns `priority = index` (0-based) to each id, then calls Monarch\'s batch priority mutation in one round-trip.  Send the COMPLETE goal id list, not a delta. Goals missing from the list keep their current priority but end up after all listed goals. Use after a drag-and-drop reorder in a goals UI. 

### Example

```typescript
import {
    GoalsApi,
    Configuration,
    UpdateGoalsPrioritiesRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let updateGoalsPrioritiesRequest: UpdateGoalsPrioritiesRequest; //

const { status, data } = await apiInstance.updateGoalsPriorities(
    updateGoalsPrioritiesRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateGoalsPrioritiesRequest** | **UpdateGoalsPrioritiesRequest**|  | |


### Return type

**UpdateGoalsPrioritiesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated &#x60;(goalId, priority)&#x60; pairs. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **withdrawFromGoal**
> WithdrawFromGoalResponse withdrawFromGoal(withdrawFromGoalRequest)

Withdraw money from a savings goal back into a source account. Reverses (in spirit) a prior contribution; the goal balance drops by `amount`, and Monarch updates the account\'s available-for-goals balance.  Pair with `POST /v1/goals/{id}/contributions` to deposit. 

### Example

```typescript
import {
    GoalsApi,
    Configuration,
    WithdrawFromGoalRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new GoalsApi(configuration);

let id: string; //Monarch savings-goal id. (default to undefined)
let withdrawFromGoalRequest: WithdrawFromGoalRequest; //

const { status, data } = await apiInstance.withdrawFromGoal(
    id,
    withdrawFromGoalRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **withdrawFromGoalRequest** | **WithdrawFromGoalRequest**|  | |
| **id** | [**string**] | Monarch savings-goal id. | defaults to undefined|


### Return type

**WithdrawFromGoalResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Created withdrawal event + updated goal + account snapshot. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

