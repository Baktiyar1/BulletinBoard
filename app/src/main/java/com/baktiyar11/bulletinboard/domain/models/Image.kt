package com.baktiyar11.bulletinboard.domain.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    @SerializedName("__type")
    var type: String = "File",
    var name: String? = null,
    var url: String? = null,
) : Parcelable