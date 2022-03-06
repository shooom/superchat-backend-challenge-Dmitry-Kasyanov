package org.superchat.conversation.dto

data class ConversationDto(
    val specialistId: Long,
    val customerId: Long,
    val channel: String)