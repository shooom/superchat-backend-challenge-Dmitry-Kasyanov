package org.superchat.conversation

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ConversationRepository: PanacheRepository<Conversation> {
    //TODO: add chanel as a query param
    fun findByContacts(corpId: Long, custId: Long) =
        find("corp_contact_id = ?1 and cust_contact_id = ?2", corpId, custId)
            .firstResult() ?: throw Exception("Conversation not found")
}