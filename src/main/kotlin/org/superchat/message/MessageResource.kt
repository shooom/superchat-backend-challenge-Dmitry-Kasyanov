package org.superchat.message

import org.superchat.placeholderHandler.PlaceholderService
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/message")
class MessageResource {

    @Inject
    lateinit var msgService: MessageService
    @Inject
    lateinit var placeholderService: PlaceholderService

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun saveMessage(dto: MessageDto) =
        msgService.saveMessage(placeholderService.replacePlaceholders(dto))

    @POST
    @Path("/{msgId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun updateMessage(@PathParam("msgId") msgId:Long, dto: MessageDto): Message {
        TODO("Realize it")
    }

    @GET
    @Path("/{convId}")
    fun loadDialog(@PathParam("convId") convId: Long): List<Message> =
        msgService.getByConversationId(convId)

}