package com.baktiyar11.bulletinboard.domain.models.login

data class ServerResponse(
    val createdAt: String,
    val objectId: String,
    val sessionToken: String
)