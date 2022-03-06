package org.superchat.contacts

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "contacts")
class Contact: PanacheEntity() {
    @Column(name = "superchat_name")
    lateinit var superChatName: String
    lateinit var name: String
    lateinit var phone: String
    lateinit var email: String
    @Column(name = "telegram_id")
    lateinit var telegramId: String
    lateinit var description: String
}
