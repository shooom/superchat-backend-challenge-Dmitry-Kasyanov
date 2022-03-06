package org.superchat.webhook

import org.superchat.contacts.ContactRepository
import org.superchat.conversation.ConversationRepository
import org.superchat.message.MessageDto
import org.superchat.message.MessageService
import org.superchat.webhook.dto.WebhookDto
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class WebhookService {

    @Inject
    lateinit var contactRepo: ContactRepository
    @Inject
    lateinit var conversationRepo:  ConversationRepository
    @Inject
    lateinit var messageService: MessageService

    @Transactional
    fun persistMessage(dto: WebhookDto) {
        val custContact = contactRepo.findByMessangerId(dto.fromName)
        val corpContact = contactRepo.findByMessangerId(dto.toName)
        val convId = conversationRepo.findByContacts(corpContact.id!!, custContact.id!!)

        messageService.saveMessage(MessageDto(convId.id!!, custContact.name, dto.body))
    }
}