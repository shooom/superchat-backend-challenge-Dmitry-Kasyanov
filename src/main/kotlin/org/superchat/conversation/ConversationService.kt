package org.superchat.conversation

import org.superchat.conversation.dto.ConversationDto
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class ConversationService {

    @Inject
    lateinit var repo: ConversationRepository

    @Transactional
    fun createNewConv(dto: ConversationDto): Conversation {
        var newConv = Conversation()
        newConv.corpContactId = dto.specialistId
        newConv.custContactId = dto.customerId
        newConv.channel = dto.channel
        newConv.let {
            repo.persist(newConv)
            return newConv
        }
    }

    fun loadByCorpClientId(contactId: Long): List<Conversation> =
        repo.list("corpContactId", contactId).orEmpty()

    fun findById(id: Long) = repo.findById(id) ?: throw RuntimeException("Conversation not found")
}