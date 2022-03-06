package org.superchat.message

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "message")
class Message {

    @Id
    @GeneratedValue
    var id: Long? = null

    lateinit var author: String

    lateinit var body: String

    @Column(name = "conversation_id")
    var conversationId: Long? = null

    @Column(name = "created_at")
    @CreationTimestamp
    lateinit var createdAt: Timestamp

    @Column(name = "updated_at")
    @UpdateTimestamp
    lateinit var updatedAt: Timestamp
}