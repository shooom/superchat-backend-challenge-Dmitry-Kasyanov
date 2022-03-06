package org.superchat.contacts

import org.superchat.contacts.dto.ContactDto
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/contacts")
class ContactResource {

    @Inject
    lateinit var contactService: ContactService

    @POST
    fun createContact(contact: ContactDto) {
        contactService.addContact(contact)
    }

    @GET
    fun getAllContacts(): List<Contact> {
        return contactService.getAllContacts()
    }
}