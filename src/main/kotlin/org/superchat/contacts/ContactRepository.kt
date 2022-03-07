package org.superchat.contacts

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ContactRepository: PanacheRepository<Contact> {
    fun findByEmail(email: String) =
        find("email", email).firstResult()

    fun findByMessangerId(messangerId: String) =
        find("telegram_id", messangerId).firstResult()
            ?: throw RuntimeException("Client with $messangerId nick not found")
}