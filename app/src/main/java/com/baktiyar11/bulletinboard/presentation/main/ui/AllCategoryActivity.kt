package com.baktiyar11.bulletinboard.presentation.main.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baktiyar11.bulletinboard.databinding.ActivityAllCategoryBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.presentation.GetListClass
import com.baktiyar11.bulletinboard.presentation.details.ui.DetailsCategoryActivity
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.AddCategoryAdapter
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.ItemClickListenerAddCategory
import com.baktiyar11.bulletinboard.utils.ALL_CATEGORY_KEY
import com.baktiyar11.bulletinboard.utils.BUNDLE
import com.baktiyar11.bulletinboard.utils.CATEGORY_KEY
import kotlin.collections.ArrayList

class AllCategoryActivity : AppCompatActivity() {

    private val binding: ActivityAllCategoryBinding by lazy {
        ActivityAllCategoryBinding.inflate(layoutInflater)
    }
    private var categoryList: ArrayList<Category> = GetListClass().addAllCategory()
    private val addCategoryAdapter: AddCategoryAdapter by lazy {
        AddCategoryAdapter(object : ItemClickListenerAddCategory {
            override fun showDetailsAddCategory(category: Category) {
                val intent = Intent(this@AllCategoryActivity, DetailsCategoryActivity::class.java)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getAllCategories()
        binding.apply {

            closeImage.setOnClickListener {
                startActivity(Intent(this@AllCategoryActivity,
                    AnnouncementListsActivity::class.java))
            }

            addCategoryAdapter.categoryList = categoryList
            recViewAddAllCategory.adapter = addCategoryAdapter
        }
    }

    private fun getAllCategories() {
        val intentCategory = intent.getBundleExtra(BUNDLE)
        val categories = intentCategory!!.getSerializable(ALL_CATEGORY_KEY) as ArrayList<Category>
        categoryList = categories
    }
}