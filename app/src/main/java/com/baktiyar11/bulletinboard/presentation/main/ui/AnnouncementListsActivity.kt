package com.baktiyar11.bulletinboard.presentation.main.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ActivityAnnouncementListsBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.presentation.details.ui.DetailsCategoryActivity
import com.baktiyar11.bulletinboard.presentation.item_add.ui.activity.ItemAddActivity
import com.baktiyar11.bulletinboard.presentation.main.adapter.CategoryAdapter
import com.baktiyar11.bulletinboard.presentation.main.adapter.ItemClickListenerCategory
import com.baktiyar11.bulletinboard.utils.ALL_CATEGORY_KEY
import com.baktiyar11.bulletinboard.utils.BUNDLE
import com.baktiyar11.bulletinboard.utils.CATEGORY_KEY
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import java.util.*

class AnnouncementListsActivity : AppCompatActivity() {

    private val binding: ActivityAnnouncementListsBinding by lazy {
        ActivityAnnouncementListsBinding.inflate(layoutInflater)
    }
    private var categoryList: ArrayList<Category>? = null
    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter(object : ItemClickListenerCategory {
            override fun showDetailsCategory(category: Category) {
                val intent = Intent(this@AnnouncementListsActivity, DetailsCategoryActivity::class.java)
                intent.putExtra(CATEGORY_KEY, category)
                startActivity(intent)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        categoryList = addAllCategory()

        categoryAdapter.categoryList = categoryList!!

        binding.apply {
            categoryRecViewMain.adapter = categoryAdapter
            val slideModelList: ArrayList<SlideModel> = arrayListOf()
            slideModelList.add(SlideModel(R.drawable.banner_watch, ScaleTypes.CENTER_INSIDE))
            slideModelList.add(SlideModel(R.drawable.banner_ad, ScaleTypes.CENTER_INSIDE))
            imageSliderMain.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE)

            floatingActionButtonMain.setOnClickListener {
                transitionToItemAddActivity(ItemAddActivity())
            }

            constraintLayoutAllCategory.setOnClickListener {
                transitionToItemAddActivity(AllCategoryActivity())
            }
        }
    }

    private fun transitionToItemAddActivity(activity: Activity) {
        val intent = Intent(this@AnnouncementListsActivity, activity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(ALL_CATEGORY_KEY, categoryList)
        intent.putExtra(BUNDLE, bundle)
        startActivity(intent)
    }

    private fun addAllCategory(): ArrayList<Category> {

        val categoryList: ArrayList<Category> = arrayListOf()

        // Add category TRANSPORT
        val transport = Category(idCategory = 0, categoryName = "TRANSPORT",
            categoryDescription = "Automobiles of Kyrgyzstan, auto accessories, auto parts",
            categoryIcon = R.drawable.transport)
        categoryList.add(0, transport)

        // Add category REAL ESTATE
        val realEstate = Category(idCategory = 1, categoryName = "REAL ESTATE",
            categoryDescription = "Purchase, sale and rental of real estate throughout Kyrgyzstan",
            categoryIcon = R.drawable.real_estate)
        categoryList.add(1, realEstate)

        // Add category TAXI
        val taxi = Category(idCategory = 2, categoryName = "TAXI",
            categoryDescription = "Taxi services throughout Kyrgyzstan",
            categoryIcon = R.drawable.taxi)
        categoryList.add(2, taxi)

        // Add category ELECTRONICS
        val electronic = Category(idCategory = 3, categoryName = "ELECTRONICS",
            categoryDescription = "Large hypermarket of new and used electronics in Kyrgyzstan",
            categoryIcon = R.drawable.electronic)
        categoryList.add(3, electronic)

        // Add category SERVICES
        val service = Category(idCategory = 4, categoryName = "SERVICES",
            categoryDescription = "Repair, service and other services throughout Kyrgyzstan",
            categoryIcon = R.drawable.services)
        categoryList.add(4, service)

        // Add category WORK
        val work = Category(idCategory = 5, categoryName = "WORK",
            categoryDescription = "The most current vacancies and qualified employees throughout Kyrgyzstan",
            categoryIcon = R.drawable.work)
        categoryList.add(5, work)

        // add category PERSONAL ITEMS
        val personalItems = Category(idCategory = 6, categoryName = "PERSONAL ITEMS",
            categoryDescription = "Second hand and products from the best manufacturers in the world and Kyrgyzstan",
            categoryIcon = R.drawable.personal_items)
        categoryList.add(6, personalItems)

        // add category ANIMALS
        val animals = Category(idCategory = 7, categoryName = "ANIMALS",
            categoryDescription = "Companion animals that take up leisure, provide pleasure and with whom you can communicate",
            categoryIcon = R.drawable.animals)
        categoryList.add(7, animals)

        // add category SPORT AND HOBBIES
        val sportAndHobbies = Category(idCategory = 8, categoryName = "SPORT AND HOBBIES",
            categoryDescription = "Everything for a sporty lifestyle",
            categoryIcon = R.drawable.sport_and_hobbies)
        categoryList.add(8, sportAndHobbies)

        // add category MEDICAL PRODUCTS
        val medicalProducts = Category(idCategory = 9, categoryName = "MEDICAL PRODUCTS",
            categoryDescription = "Medicines and medical products from trusted manufacturers",
            categoryIcon = R.drawable.medical_products)
        categoryList.add(9, medicalProducts)

        // add category CHILDREN'S WORLD
        val childrenWord = Category(idCategory = 10, categoryName = "CHILDRENS WORLD",
            categoryDescription = "Everything for children",
            categoryIcon = R.drawable.kids)
        categoryList.add(10, childrenWord)

        // add category MEDICAL PRODUCTS
        val giveForFree = Category(idCategory = 11, categoryName = "GIVE FOR FREE",
            categoryDescription = "All that is here you can get FREE",
            categoryIcon = R.drawable.give_for_free)
        categoryList.add(11, giveForFree)

        return categoryList
    }
}