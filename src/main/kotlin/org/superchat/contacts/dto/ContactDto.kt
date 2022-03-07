package org.superchat.contacts.dto

data class ContactDto(
    val name: String,
    val email: String,
    val tgName: String = "",
    val phone: String = "")
