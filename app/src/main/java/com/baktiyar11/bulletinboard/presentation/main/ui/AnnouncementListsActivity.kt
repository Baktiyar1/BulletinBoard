package com.baktiyar11.bulletinboard.presentation.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.data.database.category.CategoryDao
import com.baktiyar11.bulletinboard.databinding.ActivityAnnouncementListsBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.presentation.App
import com.baktiyar11.bulletinboard.presentation.GetListClass
import com.baktiyar11.bulletinboard.presentation.details.ui.DetailsCategoryActivity
import com.baktiyar11.bulletinboard.presentation.item_add.ui.activity.ItemAddActivity
import com.baktiyar11.bulletinboard.presentation.main.adapter.CategoryAdapter
import com.baktiyar11.bulletinboard.presentation.main.adapter.ItemClickListenerCategory
import com.baktiyar11.bulletinboard.utils.ALL_CATEGORY_KEY
import com.baktiyar11.bulletinboard.utils.BUNDLE
import com.baktiyar11.bulletinboard.utils.CATEGORY_KEY
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import kotlinx.coroutines.launch
import java.util.*

class AnnouncementListsActivity : AppCompatActivity() {

    private val binding: ActivityAnnouncementListsBinding by lazy {
        ActivityAnnouncementListsBinding.inflate(layoutInflater)
    }
    private var daoCategory: CategoryDao? = null
    private var categoryList: ArrayList<Category>? = GetListClass().addAllCategory()
    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter(object : ItemClickListenerCategory {
            override fun showDetailsCategory(category: Category) {
                val intent =
                    Intent(this@AnnouncementListsActivity, DetailsCategoryActivity::class.java)
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
            categoryRecViewMain.adapter = categoryAdapter
            val slideModelList: ArrayList<SlideModel> = arrayListOf()
            slideModelList.add(SlideModel(R.drawable.banner_watch, ScaleTypes.CENTER_INSIDE))
            slideModelList.add(SlideModel(R.drawable.banner_ad, ScaleTypes.CENTER_INSIDE))
            imageSliderMain.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE)

            floatingActionButtonMain.setOnClickListener {
                transitionToItemAddActivity()
            }

            constraintLayoutAllCategory.setOnClickListener {
                startActivity(Intent(this@AnnouncementListsActivity,
                    AllCategoryActivity::class.java))
            }
        }
    }

    private fun transitionToItemAddActivity() {
        val intent = Intent(this@AnnouncementListsActivity, ItemAddActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(ALL_CATEGORY_KEY, categoryList)
        intent.putExtra(BUNDLE, bundle)
        startActivity(intent)
    }

    private fun getAllCategories() = lifecycleScope.launch {
        daoCategory = App.appDatabase?.getCategoryDao()
        categoryAdapter.categoryList = categoryList!!
    }
}