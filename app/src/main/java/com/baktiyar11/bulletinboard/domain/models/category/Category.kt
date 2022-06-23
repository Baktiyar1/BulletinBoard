package com.baktiyar11.bulletinboard.domain.models.category

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity(tableName = "category_database")
data class Category(
    @PrimaryKey val idCategoryRoom: Int,
    var categoryName: String,
    var categoryDescription: String,
    var categoryIcon: Int,
) : Serializable