package com.baktiyar11.bulletinboard.presentation.main.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.data.database.category.CategoryDao
import com.baktiyar11.bulletinboard.databinding.ActivityAllCategoryBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.presentation.App
import com.baktiyar11.bulletinboard.presentation.details.ui.DetailsCategoryActivity
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.AddCategoryAdapter
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.ItemClickListenerAddCategory
import com.baktiyar11.bulletinboard.utils.CATEGORY_KEY
import kotlinx.coroutines.launch
import java.util.*

class AllCategoryActivity : AppCompatActivity() {

    private val binding: ActivityAllCategoryBinding by lazy {
        ActivityAllCategoryBinding.inflate(layoutInflater)
    }
    private var daoCategory: CategoryDao? = null
    private var categoryList: MutableList<Category> = mutableListOf()
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
            recViewAddAllCategory.adapter = addCategoryAdapter
        }
    }

    private fun getAllCategories() = lifecycleScope.launch {
        daoCategory = App.appDatabase?.getCategoryDao()
        addAllCategory()
        categoryList.forEach { category ->
            daoCategory?.addNewCategory(category)
        }
        addCategoryAdapter.categoryList = categoryList
    }

    private fun addAllCategory() {
        // Add category TRANSPORT
        val idTransport: Int = Random().nextInt(99999)
        val transport = Category(idTransport,
            "TRANSPORT",
            "Automobiles of Kyrgyzstan, auto accessories, auto parts",
            R.drawable.transport)
        categoryList.add(0, transport)
        // Add category REAL ESTATE
        val idRealEstate: Int = Random().nextInt(99999)
        val realEstate = Category(idRealEstate,
            "REAL ESTATE",
            "Purchase, sale and rental of real estate throughout Kyrgyzstan",
            R.drawable.real_estate)
        categoryList.add(1, realEstate)
        // Add category TAXI
        val idTaxi: Int = Random().nextInt(99999)
        val taxi = Category(idTaxi,
            "TAXI",
            "Taxi services throughout Kyrgyzstan",
            R.drawable.taxi)
        categoryList.add(2, taxi)
        // Add category ELECTRONICS
        val idElectronic: Int = Random().nextInt(99999)
        val electronic = Category(idElectronic,
            "ELECTRONICS",
            "Large hypermarket of new and used electronics in Kyrgyzstan",
            R.drawable.electronic)
        categoryList.add(3, electronic)
        // Add category SERVICES
        val idService: Int = Random().nextInt(99999)
        val service = Category(idService,
            "SERVICES",
            "Repair, service and other services throughout Kyrgyzstan",
            R.drawable.services)
        categoryList.add(4, service)
        // Add category WORK
        val idWork: Int = Random().nextInt(99999)
        val work = Category(idWork,
            "WORK",
            "The most current vacancies and qualified employees throughout Kyrgyzstan",
            R.drawable.work)
        categoryList.add(5, work)
        // add category PERSONAL ITEMS
        val idPersonalItems: Int = Random().nextInt(99999)
        val personalItems = Category(idPersonalItems,
            "PERSONAL ITEMS",
            "Second hand and products from the best manufacturers in the world and Kyrgyzstan",
            R.drawable.personal_items)
        categoryList.add(6, personalItems)
        // add category ANIMALS
        val idAnimals: Int = Random().nextInt(99999)
        val animals = Category(idAnimals,
            "ANIMALS",
            "Companion animals that take up leisure, provide pleasure and with whom you can communicate",
            R.drawable.animals)
        categoryList.add(7, animals)
        // add category SPORT AND HOBBIES
        val idSportAndHobbies: Int = Random().nextInt(99999)
        val sportAndHobbies = Category(idSportAndHobbies,
            "SPORT AND HOBBIES",
            "Everything for a sporty lifestyle",
            R.drawable.sport_and_hobbies)
        categoryList.add(8, sportAndHobbies)
        // add category MEDICAL PRODUCTS
        val idMedicalProducts: Int = Random().nextInt(99999)
        val medicalProducts = Category(idMedicalProducts,
            "MEDICAL PRODUCTS",
            "Medicines and medical products from trusted manufacturers",
            R.drawable.services)
        categoryList.add(9, medicalProducts)
        // add category CHILDREN'S WORLD
        val idChildrenWord: Int = Random().nextInt(99999)
        val childrenWord = Category(idChildrenWord,
            "CHILDREN'S WORLD",
            "Everything for children",
            R.drawable.kids)
        categoryList.add(10, childrenWord)
        // add category MEDICAL PRODUCTS
        val idGiveForFree: Int = Random().nextInt(99999)
        val giveForFree = Category(idGiveForFree,
            "GIVE FOR FREE",
            "All that is here you can get FREE",
            R.drawable.give_for_free)
        categoryList.add(11, giveForFree)
    }
}