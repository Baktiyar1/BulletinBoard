package com.baktiyar11.bulletinboard.domain.models.login

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("objectId") var userId: String? = null,
    @SerializedName("email") var userEmail: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var userPassword: String? = null,
    @SerializedName("phone") var userPhone: String? = null,
) : Serializable