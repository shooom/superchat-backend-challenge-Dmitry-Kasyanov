package org.superchat.message

data class MessageDto(
    val conversationId: Long,
    val author: String,
    val body: String)
