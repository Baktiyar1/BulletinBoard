package com.baktiyar11.bulletinboard.domain.models.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @SerializedName("objectId") var userId: String? = null,
    @SerializedName("email") var userEmail: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var userPassword: String? = null,
    @SerializedName("phone") var userPhone: String? = null,
) : Parcelable