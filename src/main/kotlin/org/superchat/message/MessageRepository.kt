package org.superchat.message

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import io.quarkus.panache.common.Sort
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MessageRepository: PanacheRepository<Message> {

    fun findByConversationId(convId: Long) =
        find(
            "conversation_id = ?1",
            Sort.ascending("conversation_id"),
            convId)
}