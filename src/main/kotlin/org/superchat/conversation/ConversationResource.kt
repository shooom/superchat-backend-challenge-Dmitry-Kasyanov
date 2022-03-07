package org.superchat.conversation

import org.superchat.conversation.dto.ConversationDto
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/conversations")
class ConversationResource {

    @Inject
    lateinit var convService: ConversationService

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createConversation(convDto: ConversationDto): Conversation {
        return convService.createNewConv(convDto)
    }

    @GET
    @Path("/user/{contactId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun loadConversationsByCorpContact(@PathParam("contactId") contactId: Long): List<Conversation> =
        convService.loadByCorpClientId(contactId)


}