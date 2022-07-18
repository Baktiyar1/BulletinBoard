package com.baktiyar11.bulletinboard.domain.models.login

import com.baktiyar11.bulletinboard.domain.models.Image

data class SignInResponse(
    val createdAt: String,
    val objectId: String,
    val email: String,
    val password: String,
    val phone: String,
    val sessionToken: String,
    val updatedAt: String,
    val username: String,
    val icon: Image?,
)