package org.superchat.placeholderHandler

import org.superchat.contacts.ContactService
import org.superchat.conversation.ConversationService
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class NamePlaceholder {

    @Inject
    lateinit var contactService: ContactService
    @Inject
    lateinit var convService: ConversationService

    fun handle(convId: Long): String {
        val conv = convService.findById(convId)
        return contactService.findById(conv.custContactId!!).name
    }
}