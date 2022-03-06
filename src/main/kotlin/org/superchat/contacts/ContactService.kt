package org.superchat.contacts

import org.superchat.contacts.dto.ContactDto
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class ContactService {

    @Inject
    lateinit var repo: ContactRepository

    @Transactional
    fun addContact(dto: ContactDto) {
        var newContact = Contact()
        newContact.name = dto.name
        newContact.superChatName = "sp_" + dto.name.replace(" ", "")
        newContact.email = dto.email
        newContact.phone = dto.phone
        newContact.telegramId = dto.tgName
        newContact.description = ""
        repo.persist(newContact)
    }

    fun getAllContacts(): List<Contact> {
        return repo.findAll().list().orEmpty()
    }

    fun findById(id: Long) = repo.findById(id) ?: throw RuntimeException("Client not found")
}