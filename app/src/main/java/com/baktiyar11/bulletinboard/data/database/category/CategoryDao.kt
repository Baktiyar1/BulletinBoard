package com.baktiyar11.bulletinboard.data.database.category

import androidx.room.*
import com.baktiyar11.bulletinboard.domain.models.category.Category

@Dao
interface CategoryDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    fun addNewCategory(category: Category)

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)

    @Query("select * from category_database")
    fun getAllCategories(): MutableList<Category>

    @Query("select * from category_database where idCategoryRoom ==:categoryId")
    fun getCategory(categoryId: Int): Category
}