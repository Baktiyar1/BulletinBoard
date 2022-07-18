package com.baktiyar11.bulletinboard.domain.models.login

import com.baktiyar11.bulletinboard.domain.models.Image
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("objectId") var objectId: String? = null,
    @SerializedName("email") var userEmail: String?,
    @SerializedName("username") var username: String?,
    @SerializedName("password") var userPassword: String? = null,
    @SerializedName("phone") var userPhone: String?,
    @SerializedName("icon") var userIcon: Image? = null,
    @SerializedName("sessionToken") var sessionToken: String? = null,
) : Serializable