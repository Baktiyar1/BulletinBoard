package com.baktiyar11.bulletinboard.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Image(
    @SerializedName("__type") var type: String = "File",
    var name: String = "icon.png",
    var url: String? = null,
) : Serializable