package org.superchat.message

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class MessageService {

    @Inject
    lateinit var repo: MessageRepository

    @Transactional
    fun saveMessage(dto: MessageDto) {
        var msg = Message()
        msg.author = dto.author
        msg.body = dto.body
        msg.conversationId = dto.conversationId

        repo.persist(msg)
    }

    fun getByConversationId(convId: Long): List<Message> =
        repo.findByConversationId(convId).list()
}