package org.superchat.conversation

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "conversation")
class Conversation {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "corp_contact_id")
    var corpContactId: Long? = null

    @Column(name = "cust_contact_id")
    var custContactId: Long? = null

    lateinit var channel: String

    @CreationTimestamp
    @Column(name = "created_at")
    lateinit var createdAt: Timestamp

    @UpdateTimestamp
    @Column(name = "updated_at")
    lateinit var updatedAt: Timestamp
}