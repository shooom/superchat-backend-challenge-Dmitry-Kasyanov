package org.superchat.webhook.dto

data class WebhookDto(
    val channel: String,
    val fromName: String,
    val toName: String,
    val body: String)