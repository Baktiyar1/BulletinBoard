package com.baktiyar11.bulletinboard.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.baktiyar11.bulletinboard.data.database.category.CategoryDao
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.domain.models.category.transport.Transport

@Database(entities = [Category::class, Transport::class], version = 1)
abstract class AppDB : RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDao?

//    abstract fun getSubTransportCategoryDao(): SubTransportCategoryDao?

}