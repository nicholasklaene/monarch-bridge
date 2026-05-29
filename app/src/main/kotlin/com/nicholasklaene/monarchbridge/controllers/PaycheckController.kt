package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.PaychecksApi
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckEmployerRequest
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckEmployerResponse
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckRequest
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckResponse
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponse
import com.nicholasklaene.monarchbridge.generated.model.GetPaychecksSummaryResponse
import com.nicholasklaene.monarchbridge.generated.model.ListPaycheckEmployersResponse
import com.nicholasklaene.monarchbridge.generated.model.ListPaychecksResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdatePaycheckEmployerRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdatePaycheckRequest
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.paychecks.CreatePaycheck
import com.nicholasklaene.monarchbridge.graphql.operations.paychecks.CreatePaycheckEmployer
import com.nicholasklaene.monarchbridge.graphql.operations.paychecks.DeletePaycheck
import com.nicholasklaene.monarchbridge.graphql.operations.paychecks.DeletePaycheckEmployer
import com.nicholasklaene.monarchbridge.graphql.operations.paychecks.GetPaycheck
import com.nicholasklaene.monarchbridge.graphql.operations.paychecks.GetPaycheckEmployers
import com.nicholasklaene.monarchbridge.graphql.operations.paychecks.GetPaychecks
import com.nicholasklaene.monarchbridge.graphql.operations.paychecks.GetPaychecksSummary
import com.nicholasklaene.monarchbridge.graphql.operations.paychecks.UpdatePaycheck
import com.nicholasklaene.monarchbridge.graphql.operations.paychecks.UpdatePaycheckEmployer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

/**
 * Paycheck CRUD plus the employer registry. All HTTP wiring comes from the spec-generated
 * [PaychecksApi]; this class dispatches each method to the matching GraphQL operation and
 * wraps the typed payload in the matching spec-generated `*Response` envelope.
 *
 * Several methods return envelopes named after sibling endpoints because the spec generator
 * dedupes responses with identical inner shapes under the first-seen name:
 *  - `getPaycheck` and `updatePaycheck` return `CreatePaycheckResponse` (`{paycheck: Paycheck}`)
 *  - `updatePaycheckEmployer` returns `CreatePaycheckEmployerResponse` (`{employer: PaycheckEmployer}`)
 *  - `deletePaycheck` and `deletePaycheckEmployer` return `DeleteAccountResponse` (`{deleted: Boolean}`)
 */
@RestController
class PaycheckController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    PaychecksApi {
    override fun listPaychecks(
        start: LocalDate?,
        end: LocalDate?,
        ownerId: String?,
        employerId: String?,
    ): ResponseEntity<ListPaychecksResponse> =
        ResponseEntity.ok(
            ListPaychecksResponse(
                data =
                    exec(
                        GetPaychecks,
                        GetPaychecks.Input(
                            startDate = start?.toString(),
                            endDate = end?.toString(),
                            ownerId = ownerId,
                            employerId = employerId,
                        ),
                    ),
            ),
        )

    override fun getPaycheck(id: String): ResponseEntity<CreatePaycheckResponse> =
        ResponseEntity.ok(CreatePaycheckResponse(data = exec(GetPaycheck, GetPaycheck.Input(id))))

    override fun getPaychecksSummary(
        start: LocalDate?,
        end: LocalDate?,
        ownerIds: List<String>?,
        employerId: String?,
    ): ResponseEntity<GetPaychecksSummaryResponse> =
        ResponseEntity.ok(
            GetPaychecksSummaryResponse(
                data =
                    exec(
                        GetPaychecksSummary,
                        GetPaychecksSummary.Input(
                            startDate = start?.toString(),
                            endDate = end?.toString(),
                            ownerIds = ownerIds,
                            employerId = employerId,
                        ),
                    ),
            ),
        )

    override fun createPaycheck(createPaycheckRequest: CreatePaycheckRequest): ResponseEntity<CreatePaycheckResponse> =
        ResponseEntity.ok(CreatePaycheckResponse(data = exec(CreatePaycheck, CreatePaycheck.Input.from(createPaycheckRequest))))

    override fun updatePaycheck(
        id: String,
        updatePaycheckRequest: UpdatePaycheckRequest,
    ): ResponseEntity<CreatePaycheckResponse> =
        ResponseEntity.ok(
            CreatePaycheckResponse(
                data = exec(UpdatePaycheck, UpdatePaycheck.Input.from(id, updatePaycheckRequest)),
            ),
        )

    override fun deletePaycheck(id: String): ResponseEntity<DeleteAccountResponse> =
        ResponseEntity.ok(DeleteAccountResponse(data = exec(DeletePaycheck, DeletePaycheck.Input(id))))

    override fun listPaycheckEmployers(
        search: String?,
        limit: Int?,
        offset: Int?,
    ): ResponseEntity<ListPaycheckEmployersResponse> =
        ResponseEntity.ok(
            ListPaycheckEmployersResponse(
                data = exec(GetPaycheckEmployers, GetPaycheckEmployers.Input(search = search, limit = limit, offset = offset)),
            ),
        )

    override fun createPaycheckEmployer(
        createPaycheckEmployerRequest: CreatePaycheckEmployerRequest,
    ): ResponseEntity<CreatePaycheckEmployerResponse> =
        ResponseEntity.ok(
            CreatePaycheckEmployerResponse(
                data = exec(CreatePaycheckEmployer, CreatePaycheckEmployer.Input.from(createPaycheckEmployerRequest)),
            ),
        )

    override fun updatePaycheckEmployer(
        id: String,
        updatePaycheckEmployerRequest: UpdatePaycheckEmployerRequest,
    ): ResponseEntity<CreatePaycheckEmployerResponse> =
        ResponseEntity.ok(
            CreatePaycheckEmployerResponse(
                data = exec(UpdatePaycheckEmployer, UpdatePaycheckEmployer.Input.from(id, updatePaycheckEmployerRequest)),
            ),
        )

    override fun deletePaycheckEmployer(id: String): ResponseEntity<DeleteAccountResponse> =
        ResponseEntity.ok(DeleteAccountResponse(data = exec(DeletePaycheckEmployer, DeletePaycheckEmployer.Input(id))))
}
