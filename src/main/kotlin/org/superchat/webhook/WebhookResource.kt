package org.superchat.webhook

import org.superchat.webhook.dto.WebhookDto
import javax.inject.Inject
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/messanger_webhook")
class WebhookResource {

    @Inject
    lateinit var webhookService: WebhookService

    @POST
    fun saveMessage(dto: WebhookDto) = webhookService.persistMessage(dto)

}