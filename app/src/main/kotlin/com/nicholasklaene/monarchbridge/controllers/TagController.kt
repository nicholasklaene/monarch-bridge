package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.TagsApi
import com.nicholasklaene.monarchbridge.generated.model.CreateTagRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateTagResponse
import com.nicholasklaene.monarchbridge.generated.model.DeleteTagResponse
import com.nicholasklaene.monarchbridge.generated.model.ListTagsResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.tags.CreateTransactionTag
import com.nicholasklaene.monarchbridge.graphql.operations.tags.DeleteHouseholdTransactionTag
import com.nicholasklaene.monarchbridge.graphql.operations.tags.GetTransactionTags
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/** Transaction tags. HTTP wiring from spec-generated [TagsApi]. */
@RestController
class TagController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    TagsApi {
    override fun listTags(): ResponseEntity<ListTagsResponse> = ResponseEntity.ok(ListTagsResponse(data = exec(GetTransactionTags, Unit)))

    override fun createTag(createTagRequest: CreateTagRequest): ResponseEntity<CreateTagResponse> =
        ResponseEntity.ok(CreateTagResponse(data = exec(CreateTransactionTag, CreateTransactionTag.Input.from(createTagRequest))))

    override fun deleteTag(id: String): ResponseEntity<DeleteTagResponse> =
        ResponseEntity.ok(
            DeleteTagResponse(data = exec(DeleteHouseholdTransactionTag, DeleteHouseholdTransactionTag.Input(tagId = id))),
        )
}
