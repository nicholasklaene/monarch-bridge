package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.RecurringApi
import com.nicholasklaene.monarchbridge.generated.model.GetRecurringDashboardResponse
import com.nicholasklaene.monarchbridge.generated.model.GetRecurringForecastResponse
import com.nicholasklaene.monarchbridge.generated.model.ListAllRecurringResponse
import com.nicholasklaene.monarchbridge.generated.model.ListRecurringAggregateResponse
import com.nicholasklaene.monarchbridge.generated.model.ListRecurringResponse
import com.nicholasklaene.monarchbridge.generated.model.ListRecurringStreamsResponse
import com.nicholasklaene.monarchbridge.generated.model.MergeRecurringStreamsRequest
import com.nicholasklaene.monarchbridge.generated.model.MergeRecurringStreamsResponse
import com.nicholasklaene.monarchbridge.generated.model.SkipRecurringInstanceRequest
import com.nicholasklaene.monarchbridge.generated.model.SkipRecurringInstanceResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateMerchantRecurrenceRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateMerchantRecurrenceResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.GetAggregatedRecurringItems
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.GetAllRecurringTransactionItems
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.GetRecurringDashboard
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.GetRecurringForecast
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.GetRecurringStreams
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.GetRecurringTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.MergeRecurringStreams
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.SkipRecurringInstance
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.UpdateMerchantRecurrence
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

/** Upcoming recurring-transaction occurrences + per-merchant recurrence rule edits. */
@RestController
@Suppress("TooManyFunctions")
class RecurringController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    RecurringApi {
    override fun listRecurring(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<ListRecurringResponse> =
        ResponseEntity.ok(
            ListRecurringResponse(
                data =
                    exec(
                        GetRecurringTransactions,
                        GetRecurringTransactions.Input(
                            startDate = (start ?: LocalDate.now().withDayOfMonth(1)).toString(),
                            endDate = (end ?: LocalDate.now().withDayOfMonth(1).plusMonths(1)).toString(),
                        ),
                    ),
            ),
        )

    override fun listAllRecurring(
        includeLiabilities: Boolean?,
        includePending: Boolean?,
    ): ResponseEntity<ListAllRecurringResponse> =
        ResponseEntity.ok(
            ListAllRecurringResponse(
                data =
                    exec(
                        GetAllRecurringTransactionItems,
                        GetAllRecurringTransactionItems.Input(
                            includeLiabilities = includeLiabilities,
                            includePending = includePending,
                        ),
                    ),
            ),
        )

    override fun listRecurringStreams(includeLiabilities: Boolean?): ResponseEntity<ListRecurringStreamsResponse> =
        ResponseEntity.ok(
            ListRecurringStreamsResponse(
                data = exec(GetRecurringStreams, GetRecurringStreams.Input(includeLiabilities = includeLiabilities)),
            ),
        )

    override fun listRecurringAggregate(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<ListRecurringAggregateResponse> =
        ResponseEntity.ok(
            ListRecurringAggregateResponse(
                data =
                    exec(
                        GetAggregatedRecurringItems,
                        GetAggregatedRecurringItems.Input(
                            startDate = (start ?: LocalDate.now().withDayOfMonth(1)).toString(),
                            endDate = (end ?: LocalDate.now().withDayOfMonth(1).plusMonths(1)).toString(),
                        ),
                    ),
            ),
        )

    override fun updateMerchantRecurrence(
        id: String,
        updateMerchantRecurrenceRequest: UpdateMerchantRecurrenceRequest,
    ): ResponseEntity<UpdateMerchantRecurrenceResponse> =
        ResponseEntity.ok(
            UpdateMerchantRecurrenceResponse(
                data = exec(UpdateMerchantRecurrence, UpdateMerchantRecurrence.Input.from(id, updateMerchantRecurrenceRequest)),
            ),
        )

    /** Upcoming recurring items plus a `remainingDueAmount` for a "bills due" widget. */
    override fun getRecurringDashboard(
        start: LocalDate?,
        end: LocalDate?,
        includeLiabilities: Boolean?,
    ): ResponseEntity<GetRecurringDashboardResponse> =
        ResponseEntity.ok(
            GetRecurringDashboardResponse(
                data =
                    exec(
                        GetRecurringDashboard,
                        GetRecurringDashboard.Input(
                            startDate = start ?: LocalDate.now().withDayOfMonth(1),
                            endDate = end ?: LocalDate.now().withDayOfMonth(1).plusMonths(1),
                            includeLiabilities = includeLiabilities,
                        ),
                    ),
            ),
        )

    /** Forward calendar of forecasted recurring occurrences across a date window. */
    override fun getRecurringForecast(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetRecurringForecastResponse> =
        ResponseEntity.ok(
            GetRecurringForecastResponse(
                data = exec(GetRecurringForecast, GetRecurringForecast.Input(startDate = start, endDate = end)),
            ),
        )

    /** Collapse two or more recurring streams into one (the `primaryStreamId` survives). */
    override fun mergeRecurringStreams(
        mergeRecurringStreamsRequest: MergeRecurringStreamsRequest,
    ): ResponseEntity<MergeRecurringStreamsResponse> =
        ResponseEntity.ok(
            MergeRecurringStreamsResponse(
                data = exec(MergeRecurringStreams, MergeRecurringStreams.Input.from(mergeRecurringStreamsRequest)),
            ),
        )

    /** Skip one expected occurrence of a recurring stream on the given date. */
    override fun skipRecurringInstance(
        id: String,
        skipRecurringInstanceRequest: SkipRecurringInstanceRequest,
    ): ResponseEntity<SkipRecurringInstanceResponse> =
        ResponseEntity.ok(
            SkipRecurringInstanceResponse(
                data = exec(SkipRecurringInstance, SkipRecurringInstance.Input.from(id, skipRecurringInstanceRequest)),
            ),
        )
}
