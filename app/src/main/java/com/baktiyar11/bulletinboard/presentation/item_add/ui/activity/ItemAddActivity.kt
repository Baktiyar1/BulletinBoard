package com.baktiyar11.bulletinboard.presentation.item_add.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ActivityItemAddBinding
import com.baktiyar11.bulletinboard.domain.models.category.spinnerModels.SubCategory
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.domain.models.category.spinnerModels.City
import com.baktiyar11.bulletinboard.domain.models.category.spinnerModels.Region
import com.baktiyar11.bulletinboard.domain.models.category.transport.CarTypeModel
import com.baktiyar11.bulletinboard.domain.models.category.transport.TransportModel
import com.baktiyar11.bulletinboard.domain.models.login.User
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.*
import com.baktiyar11.bulletinboard.presentation.main.ui.AnnouncementListsActivity
import com.baktiyar11.bulletinboard.utils.ALL_CATEGORY_KEY
import com.baktiyar11.bulletinboard.utils.BUNDLE
import com.baktiyar11.bulletinboard.utils.toast
import com.parse.ParseObject

class ItemAddActivity : AppCompatActivity(), CategoryItemOnClickListener,
    TransportItemOnClickListener, CarTypeModelSpinnerOnClickListener, OtherSpinnerOnClickListener,
    RegionSpinnerOnClickListener, CitySpinnerOnClickListener, SubCategorySpinnerOnClickListener {

    private val binding: ActivityItemAddBinding by lazy {
        ActivityItemAddBinding.inflate(layoutInflater)
    }
    private val addCategorySpinnerAdapter: ItemAddCategorySpinnerAdapter by lazy {
        ItemAddCategorySpinnerAdapter(
            context = this@ItemAddActivity, item_good_category = R.layout.item_good_category,
            category_name = R.array.categories, categories = categoryList,
            actionListener = this@ItemAddActivity)
    }
    private val addTransportModelSpinnerAdapter: ItemAddTransportModelSpinnerAdapter by lazy {
        ItemAddTransportModelSpinnerAdapter(
            this@ItemAddActivity, item_good_category = R.layout.item_category,
            transport_model_name = R.array.transport_model_name,
            transport_models = transportModelList, this@ItemAddActivity
        )
    }
    private var categoryList: ArrayList<Category> = arrayListOf()
    private var transportModelList = arrayListOf<TransportModel>()
    private val subCategories = arrayListOf<SubCategory>()
    private val typeModelTransportCategories = arrayListOf<CarTypeModel>()
    private val yearTransportCategories = arrayListOf<String>()
    private val fuelTransportCategories = arrayListOf<String>()
    private val bodyTypeTransportCategories = arrayListOf<String>()
    private val driveUnitTransportCategories = arrayListOf<String>()
    private val colorTransportCategories = arrayListOf<String>()
    private val cppTransportCategories = arrayListOf<String>()
    private val steeringWheelTransportCategories = arrayListOf<String>()
    private val conditionTransportCategories = arrayListOf<String>()
    private val engineCapacityTransportCategories = arrayListOf<String>()
    private val currencies = arrayListOf<String>()
    private val regions = arrayListOf<Region>()
    private val cities = arrayListOf<City>()
    private var category: Category? = null
    private var subCategory: SubCategory? = null
    private var transportModel: TransportModel? = null
    private var carTypeModel: CarTypeModel? = null
    private var year: String? = null
    private var fuel: String? = null
    private var bodyType: String? = null
    private var driveUnit: String? = null
    private var carColor: String? = null
    private var cpp: String? = null
    private var steeringWheel: String? = null
    private var condition: String? = null
    private var engineCapacity: String? = null
    private var currency: String? = null
    private var region: Region? = null
    private var city: City? = null
    private var negotiableExamination: Boolean = true
    private var myNumberExamination: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getAllCategory()

        category = categoryList[0]

        transportModelList = addAllTransportModel()

        getAllList()

        binding.apply {
            closeImage.setOnClickListener {
                startActivity(Intent(this@ItemAddActivity,
                    AnnouncementListsActivity::class.java))
            }

            giveAdapters()

            negotiableSwitch.setOnClickListener {
                if (negotiableSwitch.isChecked) {
                    priceConstraint.visibility = View.GONE
                    textPrice.visibility = View.GONE
                    negotiableExamination = false
                } else {
                    priceConstraint.visibility = View.VISIBLE
                    textPrice.visibility = View.VISIBLE
                    negotiableExamination = true
                }
            }

            myNumberSwitch.setOnClickListener {
                if (myNumberSwitch.isChecked) {
                    phoneNumberEditText.visibility = View.GONE
                    phoneNumberTextView.visibility = View.VISIBLE
                    myNumberExamination = false
                } else {
                    phoneNumberEditText.visibility = View.VISIBLE
                    phoneNumberTextView.visibility = View.GONE
                    myNumberExamination = true
                }
            }

            addBtn.setOnClickListener {
                save()
            }
        }
    }

    private fun save() {
        binding.apply {
            if (price.text!!.isNotEmpty() && phoneNumberEditText.text.isNotEmpty()) {
                val userObject = ParseObject("User")
                val user = User()
                user.userId = userObject.getString("objectId")
                user.username = userObject.getString("username")
                user.userPassword = userObject.getString("password")
                user.userEmail = userObject.getString("email")
                user.userPhone = userObject.getString("phone")
                when (category?.categoryName) {
                    "TRANSPORT" -> saveTransport(user)
                    "REAL ESTATE" -> saveRealEstate(user)
                    "TAXI" -> saveTaxi(user)
                    "ELECTRONICS" -> saveElectronics(user)
                    "SERVICES" -> saveServices(user)
                    "WORK" -> saveWork(user)
                    "PERSONAL ITEMS" -> savePersonalItems(user)
                    "ANIMALS" -> saveAnimals(user)
                    "SPORT AND HOBBIES" -> saveSportAndHobbies(user)
                    "MEDICAL PRODUCTS" -> saveMedicalProducts(user)
                    "CHILDREN WORLD" -> saveChildrenIsWord(user)
                    "GIVE FOR FREE" -> saveGiveForFree(user)
                    else -> toast("Error! Try again later")
                }
            } else toast("Fill in all the fields!")
        }
    }

    private fun saveTransport(user: User) {
        binding.apply {
            val transportObject = ParseObject("Transport")
            transportObject.put("category", category!!.categoryName)
            transportObject.put("subCategory", subCategory!!.title)
            if (subCategory!!.title == "PASSENGER CAR") {
                transportObject.put("model", carTypeModel!!.title)
                transportObject.put("brand", transportModel!!.transportModelName)
                transportObject.put("year", year)
                transportObject.put("bodyType", bodyType)
                transportObject.put("fuelType", fuel)
                transportObject.put("color", carColor)
                transportObject.put("RRCType", cpp)
                transportObject.put("steeringWheel", steeringWheel)
                transportObject.put("condition", condition)
                transportObject.put("engineCapacity", engineCapacity)
            }
            transportObject.put("header", headerMain.text.toString())
            transportObject.put("description", descMain.text.toString())
            transportObject.put("region", region!!.title)
            transportObject.put("city", city!!.title)
            transportObject.put("userId", user.userId.toString())
            transportObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    transportObject.put("userPhone", phoneNumberEditText.text.toString())
                    transportObject.put("price", price.text.toString())
                    transportObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    transportObject.put("userPhone", phoneNumberEditText.text.toString())
                    transportObject.put("price", "Negotiable")
                    transportObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    transportObject.put("userPhone", user.userPhone.toString())
                    transportObject.put("price", price.text.toString())
                    transportObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                transportObject.put("userPhone", user.userPhone.toString())
                transportObject.put("price", "Negotiable")
                transportObject.put("currency", "Negotiable")
            }

            transportObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun saveRealEstate(user: User) {
        binding.apply {
            val realEstateObject = ParseObject("RealEstate")
            realEstateObject.put("category", category!!.categoryName)
            realEstateObject.put("subCategory", subCategory!!.title)
            realEstateObject.put("header", headerMain.text.toString())
            realEstateObject.put("description", descMain.text.toString())
            realEstateObject.put("region", region!!.title)
            realEstateObject.put("city", city!!.title)
            realEstateObject.put("userId", user.userId.toString())
            realEstateObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    realEstateObject.put("userPhone", phoneNumberEditText.text.toString())
                    realEstateObject.put("price", price.text.toString())
                    realEstateObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    realEstateObject.put("userPhone", phoneNumberEditText.text.toString())
                    realEstateObject.put("price", "Negotiable")
                    realEstateObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    realEstateObject.put("userPhone", user.userPhone.toString())
                    realEstateObject.put("price", price.text.toString())
                    realEstateObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                realEstateObject.put("userPhone", user.userPhone.toString())
                realEstateObject.put("price", "Negotiable")
                realEstateObject.put("currency", "Negotiable")
            }

            realEstateObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun saveTaxi(user: User) {
        binding.apply {
            val taxiObject = ParseObject("Taxi")
            taxiObject.put("category", category!!.categoryName)
            taxiObject.put("subCategory", subCategory!!.title)
            taxiObject.put("header", headerMain.text.toString())
            taxiObject.put("description", descMain.text.toString())
            taxiObject.put("region", region!!.title)
            taxiObject.put("city", city!!.title)
            taxiObject.put("userId", user.userId.toString())
            taxiObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    taxiObject.put("userPhone", phoneNumberEditText.text.toString())
                    taxiObject.put("price", price.text.toString())
                    taxiObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    taxiObject.put("userPhone", phoneNumberEditText.text.toString())
                    taxiObject.put("price", "Negotiable")
                    taxiObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    taxiObject.put("userPhone", user.userPhone.toString())
                    taxiObject.put("price", price.text.toString())
                    taxiObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                taxiObject.put("userPhone", user.userPhone.toString())
                taxiObject.put("price", "Negotiable")
                taxiObject.put("currency", "Negotiable")
            }

            taxiObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun saveElectronics(user: User) {
        binding.apply {
            val electronicsObject = ParseObject("Electronics")
            electronicsObject.put("category", category!!.categoryName)
            electronicsObject.put("subCategory", subCategory!!.title)
            electronicsObject.put("header", headerMain.text.toString())
            electronicsObject.put("description", descMain.text.toString())
            electronicsObject.put("region", region!!.title)
            electronicsObject.put("city", city!!.title)
            electronicsObject.put("userId", user.userId.toString())
            electronicsObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    electronicsObject.put("userPhone", phoneNumberEditText.text.toString())
                    electronicsObject.put("price", price.text.toString())
                    electronicsObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    electronicsObject.put("userPhone", phoneNumberEditText.text.toString())
                    electronicsObject.put("price", "Negotiable")
                    electronicsObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    electronicsObject.put("userPhone", user.userPhone.toString())
                    electronicsObject.put("price", price.text.toString())
                    electronicsObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                electronicsObject.put("userPhone", user.userPhone.toString())
                electronicsObject.put("price", "Negotiable")
                electronicsObject.put("currency", "Negotiable")
            }

            electronicsObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun saveServices(user: User) {
        binding.apply {
            val servicesObject = ParseObject("Services")
            servicesObject.put("category", category!!.categoryName)
            servicesObject.put("subCategory", subCategory!!.title)
            servicesObject.put("header", headerMain.text.toString())
            servicesObject.put("description", descMain.text.toString())
            servicesObject.put("region", region!!.title)
            servicesObject.put("city", city!!.title)
            servicesObject.put("userId", user.userId.toString())
            servicesObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    servicesObject.put("userPhone", phoneNumberEditText.text.toString())
                    servicesObject.put("price", price.text.toString())
                    servicesObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    servicesObject.put("userPhone", phoneNumberEditText.text.toString())
                    servicesObject.put("price", "Negotiable")
                    servicesObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    servicesObject.put("userPhone", user.userPhone.toString())
                    servicesObject.put("price", price.text.toString())
                    servicesObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                servicesObject.put("userPhone", user.userPhone.toString())
                servicesObject.put("price", "Negotiable")
                servicesObject.put("currency", "Negotiable")
            }

            servicesObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun saveWork(user: User) {
        binding.apply {
            val workObject = ParseObject("Work")
            workObject.put("category", category!!.categoryName)
            workObject.put("subCategory", subCategory!!.title)
            workObject.put("header", headerMain.text.toString())
            workObject.put("description", descMain.text.toString())
            workObject.put("region", region!!.title)
            workObject.put("city", city!!.title)
            workObject.put("userId", user.userId.toString())
            workObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    workObject.put("userPhone", phoneNumberEditText.text.toString())
                    workObject.put("price", price.text.toString())
                    workObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    workObject.put("userPhone", phoneNumberEditText.text.toString())
                    workObject.put("price", "Negotiable")
                    workObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    workObject.put("userPhone", user.userPhone.toString())
                    workObject.put("price", price.text.toString())
                    workObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                workObject.put("userPhone", user.userPhone.toString())
                workObject.put("price", "Negotiable")
                workObject.put("currency", "Negotiable")
            }

            workObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun savePersonalItems(user: User) {
        binding.apply {
            val personalItemsObject = ParseObject("PersonalItems")
            personalItemsObject.put("category", category!!.categoryName)
            personalItemsObject.put("subCategory", subCategory!!.title)
            personalItemsObject.put("header", headerMain.text.toString())
            personalItemsObject.put("description", descMain.text.toString())
            personalItemsObject.put("region", region!!.title)
            personalItemsObject.put("city", city!!.title)
            personalItemsObject.put("userId", user.userId.toString())
            personalItemsObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    personalItemsObject.put("userPhone", phoneNumberEditText.text.toString())
                    personalItemsObject.put("price", price.text.toString())
                    personalItemsObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    personalItemsObject.put("userPhone", phoneNumberEditText.text.toString())
                    personalItemsObject.put("price", "Negotiable")
                    personalItemsObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    personalItemsObject.put("userPhone", user.userPhone.toString())
                    personalItemsObject.put("price", price.text.toString())
                    personalItemsObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                personalItemsObject.put("userPhone", user.userPhone.toString())
                personalItemsObject.put("price", "Negotiable")
                personalItemsObject.put("currency", "Negotiable")
            }

            personalItemsObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun saveAnimals(user: User) {
        binding.apply {
            val animalsObject = ParseObject("Animals")
            animalsObject.put("category", category!!.categoryName)
            animalsObject.put("subCategory", subCategory!!.title)
            animalsObject.put("header", headerMain.text.toString())
            animalsObject.put("description", descMain.text.toString())
            animalsObject.put("region", region!!.title)
            animalsObject.put("city", city!!.title)
            animalsObject.put("userId", user.userId.toString())
            animalsObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    animalsObject.put("userPhone", phoneNumberEditText.text.toString())
                    animalsObject.put("price", price.text.toString())
                    animalsObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    animalsObject.put("userPhone", phoneNumberEditText.text.toString())
                    animalsObject.put("price", "Negotiable")
                    animalsObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    animalsObject.put("userPhone", user.userPhone.toString())
                    animalsObject.put("price", price.text.toString())
                    animalsObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                animalsObject.put("userPhone", user.userPhone.toString())
                animalsObject.put("price", "Negotiable")
                animalsObject.put("currency", "Negotiable")
            }

            animalsObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun saveSportAndHobbies(user: User) {
        binding.apply {
            val sportAndHobbiesObject = ParseObject("SportAndHobbies")
            sportAndHobbiesObject.put("category", category!!.categoryName)
            sportAndHobbiesObject.put("subCategory", subCategory!!.title)
            sportAndHobbiesObject.put("header", headerMain.text.toString())
            sportAndHobbiesObject.put("description", descMain.text.toString())
            sportAndHobbiesObject.put("region", region!!.title)
            sportAndHobbiesObject.put("city", city!!.title)
            sportAndHobbiesObject.put("userId", user.userId.toString())
            sportAndHobbiesObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    sportAndHobbiesObject.put("userPhone", phoneNumberEditText.text.toString())
                    sportAndHobbiesObject.put("price", price.text.toString())
                    sportAndHobbiesObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    sportAndHobbiesObject.put("userPhone", phoneNumberEditText.text.toString())
                    sportAndHobbiesObject.put("price", "Negotiable")
                    sportAndHobbiesObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    sportAndHobbiesObject.put("userPhone", user.userPhone.toString())
                    sportAndHobbiesObject.put("price", price.text.toString())
                    sportAndHobbiesObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                sportAndHobbiesObject.put("userPhone", user.userPhone.toString())
                sportAndHobbiesObject.put("price", "Negotiable")
                sportAndHobbiesObject.put("currency", "Negotiable")
            }

            sportAndHobbiesObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun saveMedicalProducts(user: User) {
        binding.apply {
            val medicalProductsObject = ParseObject("MedicalProducts")
            medicalProductsObject.put("category", category!!.categoryName)
            medicalProductsObject.put("subCategory", subCategory!!.title)
            medicalProductsObject.put("header", headerMain.text.toString())
            medicalProductsObject.put("description", descMain.text.toString())
            medicalProductsObject.put("region", region!!.title)
            medicalProductsObject.put("city", city!!.title)
            medicalProductsObject.put("userId", user.userId.toString())
            medicalProductsObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    medicalProductsObject.put("userPhone", phoneNumberEditText.text.toString())
                    medicalProductsObject.put("price", price.text.toString())
                    medicalProductsObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    medicalProductsObject.put("userPhone", phoneNumberEditText.text.toString())
                    medicalProductsObject.put("price", "Negotiable")
                    medicalProductsObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    medicalProductsObject.put("userPhone", user.userPhone.toString())
                    medicalProductsObject.put("price", price.text.toString())
                    medicalProductsObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                medicalProductsObject.put("userPhone", user.userPhone.toString())
                medicalProductsObject.put("price", "Negotiable")
                medicalProductsObject.put("currency", "Negotiable")
            }

            medicalProductsObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun saveChildrenIsWord(user: User) {
        binding.apply {
            val childrenIsWorkObject = ParseObject("ChildrenWord")
            childrenIsWorkObject.put("category", category!!.categoryName)
            childrenIsWorkObject.put("subCategory", subCategory!!.title)
            childrenIsWorkObject.put("header", headerMain.text.toString())
            childrenIsWorkObject.put("description", descMain.text.toString())
            childrenIsWorkObject.put("region", region!!.title)
            childrenIsWorkObject.put("city", city!!.title)
            childrenIsWorkObject.put("userId", user.userId.toString())
            childrenIsWorkObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    childrenIsWorkObject.put("userPhone", phoneNumberEditText.text.toString())
                    childrenIsWorkObject.put("price", price.text.toString())
                    childrenIsWorkObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    childrenIsWorkObject.put("userPhone", phoneNumberEditText.text.toString())
                    childrenIsWorkObject.put("price", "Negotiable")
                    childrenIsWorkObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    childrenIsWorkObject.put("userPhone", user.userPhone.toString())
                    childrenIsWorkObject.put("price", price.text.toString())
                    childrenIsWorkObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                childrenIsWorkObject.put("userPhone", user.userPhone.toString())
                childrenIsWorkObject.put("price", "Negotiable")
                childrenIsWorkObject.put("currency", "Negotiable")
            }

            childrenIsWorkObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun saveGiveForFree(user: User) {
        binding.apply {
            val giveForFreeObject = ParseObject("GiveForFree")
            giveForFreeObject.put("category", category!!.categoryName)
            giveForFreeObject.put("header", headerMain.text.toString())
            giveForFreeObject.put("description", descMain.text.toString())
            giveForFreeObject.put("region", region!!.title)
            giveForFreeObject.put("city", city!!.title)
            giveForFreeObject.put("userId", user.userId.toString())
            giveForFreeObject.put("userName", user.username.toString())
            if (negotiableExamination && myNumberExamination) {
                if (headerMain.text!!.isNotEmpty() && descMain.text!!.isNotEmpty()) {
                    giveForFreeObject.put("userPhone", phoneNumberEditText.text.toString())
                    giveForFreeObject.put("price", price.text.toString())
                    giveForFreeObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else if (!negotiableExamination && myNumberExamination) {
                if (descMain.text!!.isNotEmpty()) {
                    giveForFreeObject.put("userPhone", phoneNumberEditText.text.toString())
                    giveForFreeObject.put("price", "Negotiable")
                    giveForFreeObject.put("currency", "Negotiable")
                } else toast("Fill in all the fields!")
            } else if (negotiableExamination && !myNumberExamination) {
                if (headerMain.text!!.isNotEmpty()) {
                    giveForFreeObject.put("userPhone", user.userPhone.toString())
                    giveForFreeObject.put("price", price.text.toString())
                    giveForFreeObject.put("currency", currency)
                } else toast("Fill in all the fields!")
            } else {
                giveForFreeObject.put("userPhone", user.userPhone.toString())
                giveForFreeObject.put("price", "Negotiable")
                giveForFreeObject.put("currency", "Negotiable")
            }

            giveForFreeObject.saveInBackground { e ->
                if (e == null) toast("Post is saved!")
                else toast(e.message.toString())
                startActivity(Intent(this@ItemAddActivity, AnnouncementListsActivity::class.java))
            }
        }
    }

    private fun getAllCategory() {
        val intentCategory = intent.getBundleExtra(BUNDLE)
        val categories = intentCategory!!.getSerializable(ALL_CATEGORY_KEY) as ArrayList<Category>?
        categoryList = categories!!
    }

    private fun giveAdapters() {
        binding.apply {
            categorySpinner.adapter = addCategorySpinnerAdapter

            carModelSpinner.adapter = addTransportModelSpinnerAdapter

            subcategorySpinner.adapter = SubCategorySpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.sub_transport_category,
                names = subCategories, actionListener = this@ItemAddActivity)

            carTypeModelSpinner.adapter = CarTypeModelSpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.model_acura_name,
                names = typeModelTransportCategories, actionListener = this@ItemAddActivity)

            yearSpinner.adapter = OtherSpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.model_acura_name,
                names = yearTransportCategories, actionListener = this@ItemAddActivity)

            fuelSpinner.adapter = OtherSpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.transport_fuel,
                names = fuelTransportCategories, actionListener = this@ItemAddActivity)

            bodyTypeSpinner.adapter = OtherSpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.transport_body_type,
                names = bodyTypeTransportCategories, actionListener = this@ItemAddActivity)

            driveUnitSpinner.adapter = OtherSpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.transport_drive_unit,
                names = driveUnitTransportCategories, actionListener = this@ItemAddActivity)

            carColorSpinner.adapter = OtherSpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.transport_color,
                names = colorTransportCategories, actionListener = this@ItemAddActivity)

            cppSpinner.adapter = OtherSpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.transport_cpp,
                names = cppTransportCategories, actionListener = this@ItemAddActivity)

            steeringWheelSpinner.adapter =
                OtherSpinnerAdapter(context = this@ItemAddActivity,
                    item_other_spinner = R.layout.item_other_spinner,
                    array_name = R.array.transport_steering_wheel,
                    names = steeringWheelTransportCategories, actionListener = this@ItemAddActivity)

            conditionSpinner.adapter = OtherSpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.transport_condition,
                names = conditionTransportCategories, actionListener = this@ItemAddActivity)

            engineCapacitySpinner.adapter =
                OtherSpinnerAdapter(context = this@ItemAddActivity,
                    item_other_spinner = R.layout.item_other_spinner,
                    array_name = R.array.transport_engine_capacity,
                    names = engineCapacityTransportCategories,
                    actionListener = this@ItemAddActivity)

            currencySpinner.adapter = OtherSpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.volute,
                names = currencies, actionListener = this@ItemAddActivity)

            regionSpinner.adapter = RegionSpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.region,
                names = regions, actionListener = this@ItemAddActivity)

            citySpinner.adapter = CitySpinnerAdapter(context = this@ItemAddActivity,
                item_other_spinner = R.layout.item_other_spinner,
                array_name = R.array.cities_and_villages_chui,
                names = cities, actionListener = this@ItemAddActivity)
        }
    }

    private fun getAllList() {

        // Add subcategory
        val subTransportList = resources.getStringArray(R.array.sub_transport_category).toList()
        subTransportList.forEach {
            subCategories.add(SubCategory(id = 0, title = it))
        }

        val subRealEstateList = resources.getStringArray(R.array.sub_real_estate_category).toList()
        subRealEstateList.forEach {
            subCategories.add(SubCategory(id = 1, title = it))
        }

        val subTaxiList = resources.getStringArray(R.array.sub_taxi_category).toList()
        subTaxiList.forEach {
            subCategories.add(SubCategory(id = 2, title = it))
        }

        val subElectronicsList = resources.getStringArray(R.array.sub_electronics_category).toList()
        subElectronicsList.forEach {
            subCategories.add(SubCategory(id = 3, title = it))
        }

        val subServicesList = resources.getStringArray(R.array.sub_services_category).toList()
        subServicesList.forEach {
            subCategories.add(SubCategory(id = 4, title = it))
        }

        val subWorkList = resources.getStringArray(R.array.sub_work_category).toList()
        subWorkList.forEach {
            subCategories.add(SubCategory(id = 5, title = it))
        }

        val subPersonalItemsList =
            resources.getStringArray(R.array.sub_personal_items_category).toList()
        subPersonalItemsList.forEach {
            subCategories.add(SubCategory(id = 6, title = it))
        }

        val subAnimalsList = resources.getStringArray(R.array.sub_animals_category).toList()
        subAnimalsList.forEach {
            subCategories.add(SubCategory(id = 7, title = it))
        }

        val subSportAndHobbiesList =
            resources.getStringArray(R.array.sub_sport_and_hobbies_category).toList()
        subSportAndHobbiesList.forEach {
            subCategories.add(SubCategory(id = 8, title = it))
        }

        val subMedicalProductsList =
            resources.getStringArray(R.array.sub_medical_products_category).toList()
        subMedicalProductsList.forEach {
            subCategories.add(SubCategory(id = 9, title = it))
        }

        val subChildrenWordList =
            resources.getStringArray(R.array.sub_children_word_category).toList()
        subChildrenWordList.forEach {
            subCategories.add(SubCategory(id = 10, title = it))
        }

        // Add car model
        val carAcuraTypeModels = resources.getStringArray(R.array.model_acura_name).toList()
        carAcuraTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 0, title = model))
        }

        val carAlfaRomeoTypeModels =
            resources.getStringArray(R.array.model_alfa_romeo_name).toList()
        carAlfaRomeoTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 1, title = model))
        }

        val carAlpinaTypeModels = resources.getStringArray(R.array.model_alpina_name).toList()
        carAlpinaTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 2, title = model))
        }

        val carAudiTypeModels = resources.getStringArray(R.array.model_audi_name).toList()
        carAudiTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 3, title = model))
        }

        val carBentleyTypeModels = resources.getStringArray(R.array.model_bentley_name).toList()
        carBentleyTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 4, title = model))
        }

        val carBMVTypeModels = resources.getStringArray(R.array.model_bmw_name).toList()
        carBMVTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 5, title = model))
        }

        val carBYDTypeModels = resources.getStringArray(R.array.model_byd_name).toList()
        carBYDTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 6, title = model))
        }

        val carCadillacTypeModels = resources.getStringArray(R.array.model_cadillac_name).toList()
        carCadillacTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 7, title = model))
        }

        val carCherryTypeModels = resources.getStringArray(R.array.model_cherry_name).toList()
        carCherryTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 8, title = model))
        }

        val carChevroletTypeModels = resources.getStringArray(R.array.model_chevrolet_name).toList()
        carChevroletTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 9, title = model))
        }

        val carChryslerTypeModels = resources.getStringArray(R.array.model_chrysler_name).toList()
        carChryslerTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 10, title = model))
        }

        val carCitroenTypeModels = resources.getStringArray(R.array.model_citroen_name).toList()
        carCitroenTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 11, title = model))
        }

        val carDaewooTypeModels = resources.getStringArray(R.array.model_daewoo_name).toList()
        carDaewooTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 12, title = model))
        }

        val carDaihatsuTypeModels = resources.getStringArray(R.array.model_daihatsu_name).toList()
        carDaihatsuTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 13, title = model))
        }

        val carDodgeTypeModels = resources.getStringArray(R.array.model_dodge_name).toList()
        carDodgeTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 14, title = model))
        }

        val carDongFengTypeModels = resources.getStringArray(R.array.model_dong_feng_name).toList()
        carDongFengTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 15, title = model))
        }

        val carFiatTypeModels = resources.getStringArray(R.array.model_fiat_name).toList()
        carFiatTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 16, title = model))
        }

        val carFordTypeModels = resources.getStringArray(R.array.model_ford_name).toList()
        carFordTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 17, title = model))
        }

        val carGeeklyTypeModels = resources.getStringArray(R.array.model_geekly_name).toList()
        carGeeklyTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 18, title = model))
        }

        val carGMCTypeModels = resources.getStringArray(R.array.model_gmc_name).toList()
        carGMCTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 19, title = model))
        }

        val carGreatWallTypeModels =
            resources.getStringArray(R.array.model_great_wall_name).toList()
        carGreatWallTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 20, title = model))
        }

        val carHondaTypeModels = resources.getStringArray(R.array.model_honda_name).toList()
        carHondaTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 21, title = model))
        }

        val carHummerTypeModels = resources.getStringArray(R.array.model_hummer_name).toList()
        carHummerTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 22, title = model))
        }

        val carHyundaiTypeModels = resources.getStringArray(R.array.model_hyundai_name).toList()
        carHyundaiTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 23, title = model))
        }

        val carInfinityTypeModels = resources.getStringArray(R.array.model_infinity_name).toList()
        carInfinityTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 24, title = model))
        }

        val carIsuzuTypeModels = resources.getStringArray(R.array.model_isuzu_name).toList()
        carIsuzuTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 25, title = model))
        }

        val carJaguarTypeModels = resources.getStringArray(R.array.model_jaguar_name).toList()
        carJaguarTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 26, title = model))
        }

        val carJeepTypeModels = resources.getStringArray(R.array.model_jeep_name).toList()
        carJeepTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 27, title = model))
        }

        val carKiaTypeModels = resources.getStringArray(R.array.model_kia_name).toList()
        carKiaTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 28, title = model))
        }

        val carLamborghiniTypeModels =
            resources.getStringArray(R.array.model_lamborghini_name).toList()
        carLamborghiniTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 29, title = model))
        }

        val carLandRoverTypeModels =
            resources.getStringArray(R.array.model_land_rover_name).toList()
        carLandRoverTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 30, title = model))
        }

        val carLexusTypeModels = resources.getStringArray(R.array.model_lexus_name).toList()
        carLexusTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 31, title = model))
        }

        val carLifanTypeModels = resources.getStringArray(R.array.model_lifan_name).toList()
        carLifanTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 32, title = model))
        }

        val carLincolnTypeModels = resources.getStringArray(R.array.model_lincoln_name).toList()
        carLincolnTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 33, title = model))
        }

        val carMazdaTypeModels = resources.getStringArray(R.array.model_mazda_name).toList()
        carMazdaTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 34, title = model))
        }

        val carMercedesBenzTypeModels =
            resources.getStringArray(R.array.model_mercedes_benz_name).toList()
        carMercedesBenzTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 35, title = model))
        }

        val carMiniTypeModels = resources.getStringArray(R.array.model_mini_name).toList()
        carMiniTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 36, title = model))
        }

        val carMitsubishiTypeModels =
            resources.getStringArray(R.array.model_mitsubishi_name).toList()
        carMitsubishiTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 37, title = model))
        }

        val carNissanTypeModels = resources.getStringArray(R.array.model_nissan_name).toList()
        carNissanTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 38, title = model))
        }

        val carOpelTypeModels = resources.getStringArray(R.array.model_opel_name).toList()
        carOpelTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 39, title = model))
        }

        val carPeugeotTypeModels = resources.getStringArray(R.array.model_peugeot_name).toList()
        carPeugeotTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 40, title = model))
        }

        val carPorscheTypeModels = resources.getStringArray(R.array.model_porsche_name).toList()
        carPorscheTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 41, title = model))
        }

        val carRavonTypeModels = resources.getStringArray(R.array.model_ravon_name).toList()
        carRavonTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 42, title = model))
        }

        val carRenaultTypeModels = resources.getStringArray(R.array.model_renault_name).toList()
        carRenaultTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 43, title = model))
        }

        val carRoverTypeModels = resources.getStringArray(R.array.model_rover_name).toList()
        carRoverTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 43, title = model))
        }

        val carSaadTypeModels = resources.getStringArray(R.array.model_saab_name).toList()
        carSaadTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 44, title = model))
        }

        val carSaturnTypeModels = resources.getStringArray(R.array.model_saturn_name).toList()
        carSaturnTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 45, title = model))
        }

        val carScionTypeModels = resources.getStringArray(R.array.model_scion_name).toList()
        carScionTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 46, title = model))
        }

        val carSeatTypeModels = resources.getStringArray(R.array.model_seat_name).toList()
        carSeatTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 47, title = model))
        }

        val carScodaTypeModels = resources.getStringArray(R.array.model_scoda_name).toList()
        carScodaTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 48, title = model))
        }

        val carSsangYongTypeModels =
            resources.getStringArray(R.array.model_ssang_yong_name).toList()
        carSsangYongTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 49, title = model))
        }

        val carSubaruTypeModels = resources.getStringArray(R.array.model_subaru_name).toList()
        carSubaruTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 50, title = model))
        }

        val carSuzukiTypeModels = resources.getStringArray(R.array.model_suzuki_name).toList()
        carSuzukiTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 51, title = model))
        }

        val carTofasTypeModels = resources.getStringArray(R.array.model_tofas_name).toList()
        carTofasTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 52, title = model))
        }

        val carToyotaTypeModels = resources.getStringArray(R.array.model_toyota_name).toList()
        carToyotaTypeModels.forEach { model ->
            typeModelTransportCategories.add(CarTypeModel(id = 53, title = model))
        }

        // Add year
        yearTransportCategories.addAll(resources.getStringArray(R.array.transport_year)
            .toList())

        // Add fuel
        fuelTransportCategories.addAll(resources.getStringArray(R.array.transport_fuel)
            .toList())

        // Add body type
        bodyTypeTransportCategories.addAll(resources.getStringArray(R.array.transport_body_type)
            .toList())

        // Add driver unit
        driveUnitTransportCategories.addAll(resources.getStringArray(R.array.transport_drive_unit)
            .toList())

        // Add color
        colorTransportCategories.addAll(resources.getStringArray(R.array.transport_color)
            .toList())

        // Add CPP
        cppTransportCategories.addAll(resources.getStringArray(R.array.transport_cpp)
            .toList())

        // Add steering wheel
        steeringWheelTransportCategories.addAll(resources.getStringArray(R.array.transport_steering_wheel)
            .toList())

        // Add condition
        conditionTransportCategories.addAll(resources.getStringArray(R.array.transport_condition)
            .toList())

        // Add engine capacity
        engineCapacityTransportCategories.addAll(resources.getStringArray(R.array.transport_engine_capacity)
            .toList())

        // Add currencies
        currencies.addAll(resources.getStringArray(R.array.volute).toList())

        // Add regions
        val regionList = resources.getStringArray(R.array.region).toList()
        var i = 0
        regionList.forEach { reg ->
            regions.add(Region(id = i, title = reg))
            i += 1
        }

        // Add cities
        val chuiList = resources.getStringArray(R.array.cities_and_villages_chui).toList()
        chuiList.forEach { city ->
            cities.add(City(id = 0, title = city))
        }

        val issykKulList = resources.getStringArray(R.array.cities_and_villages_issyk_kul).toList()
        issykKulList.forEach { city ->
            cities.add(City(id = 1, title = city))
        }

        val talasList = resources.getStringArray(R.array.cities_and_villages_talas).toList()
        talasList.forEach { city ->
            cities.add(City(id = 2, title = city))
        }

        val narynList = resources.getStringArray(R.array.cities_and_villages_naryn).toList()
        narynList.forEach { city ->
            cities.add(City(id = 3, title = city))
        }

        val jalalAbabList =
            resources.getStringArray(R.array.cities_and_villages_jalal_abab).toList()
        jalalAbabList.forEach { city ->
            cities.add(City(id = 4, title = city))
        }

        val oshList = resources.getStringArray(R.array.cities_and_villages_osh).toList()
        oshList.forEach { city ->
            cities.add(City(id = 5, title = city))
        }

        val batkenList = resources.getStringArray(R.array.cities_and_villages_batken).toList()
        batkenList.forEach { city ->
            cities.add(City(id = 6, title = city))
        }
    }

    private fun addAllTransportModel(): ArrayList<TransportModel> {

        val transportModelList: ArrayList<TransportModel> = arrayListOf()

        // Add Model Acura
        val acuraModel = TransportModel(transportModelId = 0,
            transportModelName = "Acura",
            transportModelIcon = R.drawable.acura)
        transportModelList.add(0, acuraModel)

        // Add Model Alfa Romeo
        val alfaRomeoModel = TransportModel(transportModelId = 1,
            transportModelName = "Alfa Romeo",
            transportModelIcon = R.drawable.alfaromeo)
        transportModelList.add(1, alfaRomeoModel)

        // Add Model Alpina
        val alpinaModel = TransportModel(transportModelId = 2,
            transportModelName = "Alpina",
            transportModelIcon = R.drawable.alpina)
        transportModelList.add(2, alpinaModel)

        // Add Model Audi
        val audiModel = TransportModel(transportModelId = 3,
            transportModelName = "Audi",
            transportModelIcon = R.drawable.audi)
        transportModelList.add(3, audiModel)

        // Add Model Bentley
        val bentleyModel = TransportModel(transportModelId = 4,
            transportModelName = "Bentley",
            transportModelIcon = R.drawable.bentley)
        transportModelList.add(4, bentleyModel)

        // Add Model BMV
        val bmvModel = TransportModel(transportModelId = 5,
            transportModelName = "BMV",
            transportModelIcon = R.drawable.bmw)
        transportModelList.add(5, bmvModel)

        // Add Model BYD
        val bydModel = TransportModel(transportModelId = 6,
            transportModelName = "BYD",
            transportModelIcon = R.drawable.byd)
        transportModelList.add(6, bydModel)

        // Add Model Cadillac
        val cadillacModel = TransportModel(transportModelId = 7,
            transportModelName = "Cadillac",
            transportModelIcon = R.drawable.cadillac)
        transportModelList.add(7, cadillacModel)

        // Add Model Cherry
        val cheryModel = TransportModel(transportModelId = 8,
            transportModelName = "Cherry",
            transportModelIcon = R.drawable.cherry)
        transportModelList.add(8, cheryModel)

        // Add Model Chevrolet
        val chevroletModel = TransportModel(transportModelId = 9,
            transportModelName = "Chevrolet",
            transportModelIcon = R.drawable.chevrolet)
        transportModelList.add(9, chevroletModel)

        // Add Model Chrysler
        val chryslerModel = TransportModel(transportModelId = 10,
            transportModelName = "Chrysler",
            transportModelIcon = R.drawable.chrysler)
        transportModelList.add(10, chryslerModel)

        // Add Model Citroen
        val citroenModel = TransportModel(transportModelId = 11,
            transportModelName = "Citroen",
            transportModelIcon = R.drawable.citraon)
        transportModelList.add(11, citroenModel)

        // Add Model Daewoo
        val daewooModel = TransportModel(transportModelId = 12,
            transportModelName = "Daewoo",
            transportModelIcon = R.drawable.daewoo)
        transportModelList.add(12, daewooModel)

        // Add Model Daihatsu
        val daihatsuModel = TransportModel(transportModelId = 13,
            transportModelName = "Daihatsu",
            transportModelIcon = R.drawable.daihatsu)
        transportModelList.add(13, daihatsuModel)

        // Add Model Dodge
        val dodgeModel = TransportModel(transportModelId = 14,
            transportModelName = "Dodge",
            transportModelIcon = R.drawable.dodge)
        transportModelList.add(14, dodgeModel)

        // Add Model Dong Feng
        val dongFengModel = TransportModel(transportModelId = 15,
            transportModelName = "Dong Feng",
            transportModelIcon = R.drawable.dongfeng)
        transportModelList.add(15, dongFengModel)

        // Add Model Fiat
        val fiatModel = TransportModel(transportModelId = 16,
            transportModelName = "Fiat",
            transportModelIcon = R.drawable.fiat)
        transportModelList.add(16, fiatModel)

        // Add Model Ford
        val fordModel = TransportModel(transportModelId = 17,
            transportModelName = "Ford",
            transportModelIcon = R.drawable.ford)
        transportModelList.add(17, fordModel)

        // Add Model Geekly
        val geeklyModel = TransportModel(transportModelId = 18,
            transportModelName = "Geekly",
            transportModelIcon = R.drawable.geekly)
        transportModelList.add(18, geeklyModel)

        // Add Model GMC
        val gmcModel = TransportModel(transportModelId = 19,
            transportModelName = "GMC",
            transportModelIcon = R.drawable.gmc)
        transportModelList.add(19, gmcModel)

        // Add Model Great Wall
        val greatWallModel = TransportModel(transportModelId = 20,
            transportModelName = "Great Wall",
            transportModelIcon = R.drawable.greatwall)
        transportModelList.add(20, greatWallModel)

        // Add Model Honda
        val hondaModel = TransportModel(transportModelId = 21,
            transportModelName = "Honda",
            transportModelIcon = R.drawable.honda)
        transportModelList.add(21, hondaModel)

        // Add Model Hummer
        val hummerModel = TransportModel(transportModelId = 22,
            transportModelName = "Hummer",
            transportModelIcon = R.drawable.hummer)
        transportModelList.add(22, hummerModel)

        // Add Model Hyundai
        val hyundaiModel = TransportModel(transportModelId = 23,
            transportModelName = "Hyundai",
            transportModelIcon = R.drawable.hyundai)
        transportModelList.add(23, hyundaiModel)

        // Add Model Infinity
        val infinityModel = TransportModel(transportModelId = 24,
            transportModelName = "Infinity",
            transportModelIcon = R.drawable.infinity)
        transportModelList.add(24, infinityModel)

        // Add Model Isuzu
        val isuzuModel = TransportModel(transportModelId = 25,
            transportModelName = "Isuzu",
            transportModelIcon = R.drawable.isuzu)
        transportModelList.add(25, isuzuModel)

        // Add Model Jaguar
        val jaguarModel = TransportModel(transportModelId = 26,
            transportModelName = "Jaguar",
            transportModelIcon = R.drawable.jaguar)
        transportModelList.add(26, jaguarModel)

        // Add Model Jeep
        val jeepModel = TransportModel(transportModelId = 27,
            transportModelName = "Jeep",
            transportModelIcon = R.drawable.jeep)
        transportModelList.add(27, jeepModel)

        // Add Model Kia
        val kiaModel = TransportModel(transportModelId = 28,
            transportModelName = "Kia",
            transportModelIcon = R.drawable.kia)
        transportModelList.add(28, kiaModel)

        // Add Model Lamborghini
        val lamborghiniModel = TransportModel(transportModelId = 29,
            transportModelName = "Lamborghini",
            transportModelIcon = R.drawable.lamborghini)
        transportModelList.add(29, lamborghiniModel)

        // Add Model Land Rover
        val landRoverModel = TransportModel(transportModelId = 30,
            transportModelName = "Land Rover",
            transportModelIcon = R.drawable.landrover)
        transportModelList.add(30, landRoverModel)

        // Add Model Lexus
        val lexusModel = TransportModel(transportModelId = 31,
            transportModelName = "Lexus",
            transportModelIcon = R.drawable.lexus)
        transportModelList.add(31, lexusModel)

        // Add Model Lifan
        val lifanModel = TransportModel(transportModelId = 32,
            transportModelName = "Lifan",
            transportModelIcon = R.drawable.lifan)
        transportModelList.add(32, lifanModel)

        // Add Model Lincoln
        val lincolnModel = TransportModel(transportModelId = 33,
            transportModelName = "Lincoln",
            transportModelIcon = R.drawable.lincoln)
        transportModelList.add(33, lincolnModel)

        // Add Model Mazda
        val mazdaModel = TransportModel(transportModelId = 34,
            transportModelName = "Mazda",
            transportModelIcon = R.drawable.mazda)
        transportModelList.add(34, mazdaModel)

        // Add Model Mercedes-Benz
        val mercedesBenzModel = TransportModel(transportModelId = 35,
            transportModelName = "Mercedes-Benz",
            transportModelIcon = R.drawable.mercedes_benz)
        transportModelList.add(35, mercedesBenzModel)

        // Add Model MINI
        val miniModel = TransportModel(transportModelId = 36,
            transportModelName = "MINI",
            transportModelIcon = R.drawable.mini)
        transportModelList.add(36, miniModel)

        // Add Model Mitsubishi
        val mitsubishiModel = TransportModel(transportModelId = 37,
            transportModelName = "Mitsubishi",
            transportModelIcon = R.drawable.mitsubishi)
        transportModelList.add(37, mitsubishiModel)

        // Add Model Nissan
        val nissanModel = TransportModel(transportModelId = 38,
            transportModelName = "Nissan",
            transportModelIcon = R.drawable.nissan)
        transportModelList.add(38, nissanModel)

        // Add Model Opel
        val opelModel = TransportModel(transportModelId = 39,
            transportModelName = "Opel",
            transportModelIcon = R.drawable.opel)
        transportModelList.add(39, opelModel)

        // Add Model Peugeot
        val peugeotModel = TransportModel(transportModelId = 40,
            transportModelName = "Peugeot",
            transportModelIcon = R.drawable.peugeot)
        transportModelList.add(40, peugeotModel)

        // Add Model Porsche
        val porscheModel = TransportModel(transportModelId = 41,
            transportModelName = "Porsche",
            transportModelIcon = R.drawable.porsche)
        transportModelList.add(41, porscheModel)

        // Add Model Ravon
        val ravonModel = TransportModel(transportModelId = 42,
            transportModelName = "Ravon",
            transportModelIcon = R.drawable.ravon)
        transportModelList.add(42, ravonModel)

        // Add Model Renault
        val renaultModel = TransportModel(transportModelId = 43,
            transportModelName = "Renault",
            transportModelIcon = R.drawable.renault)
        transportModelList.add(43, renaultModel)

        // Add Model Rover
        val roverModel = TransportModel(transportModelId = 44,
            transportModelName = "Rover",
            transportModelIcon = R.drawable.rover)
        transportModelList.add(44, roverModel)

        // Add Model Saab
        val saabModel = TransportModel(transportModelId = 45,
            transportModelName = "Saab",
            transportModelIcon = R.drawable.saab)
        transportModelList.add(45, saabModel)

        // Add Model Saturn
        val saturnModel = TransportModel(transportModelId = 46,
            transportModelName = "Saturn",
            transportModelIcon = R.drawable.saturn)
        transportModelList.add(46, saturnModel)

        // Add Model Scion
        val scionModel = TransportModel(transportModelId = 47,
            transportModelName = "Scion",
            transportModelIcon = R.drawable.scion)
        transportModelList.add(47, scionModel)

        // Add Model SEAT
        val seatModel = TransportModel(transportModelId = 48,
            transportModelName = "SEAT",
            transportModelIcon = R.drawable.seat)
        transportModelList.add(48, seatModel)

        // Add Model Scoda
        val scodaModel = TransportModel(transportModelId = 49,
            transportModelName = "Scoda",
            transportModelIcon = R.drawable.scoda)
        transportModelList.add(49, scodaModel)

        // Add Model Subaru
        val subaruModel = TransportModel(transportModelId = 50,
            transportModelName = "Subaru",
            transportModelIcon = R.drawable.subaru)
        transportModelList.add(50, subaruModel)

        // Add Model Suzuki
        val suzukiModel = TransportModel(transportModelId = 51,
            transportModelName = "Suzuki",
            transportModelIcon = R.drawable.tofas)
        transportModelList.add(51, suzukiModel)

        // Add Model Tofas
        val tofasModel = TransportModel(transportModelId = 52,
            transportModelName = "Tofas",
            transportModelIcon = R.drawable.suzuki)
        transportModelList.add(52, tofasModel)

        // Add Model Toyota
        val toyotaModel = TransportModel(transportModelId = 53,
            transportModelName = "Toyota",
            transportModelIcon = R.drawable.toyota)
        transportModelList.add(53, toyotaModel)

        // Add Model Other
        val otherModel = TransportModel(transportModelId = 54,
            transportModelName = "Other",
            transportModelIcon = R.drawable.transport)
        transportModelList.add(54, otherModel)

        return transportModelList
    }

    override fun categoryOnClick(position: Int) {
        val subCategoryList = arrayListOf<SubCategory>()
        binding.apply {
            categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                ) {
                    category = categoryList[position]
                    transportConstraint.visibility = if (position == 0) View.VISIBLE else View.GONE
                    subcategorySpinner.visibility = if (position == 11) View.GONE else View.VISIBLE
                    chooseCategoryText.visibility = if (position == 11) View.GONE else View.VISIBLE
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            subCategories.forEach {
                if (it.id == categoryList[position].idCategory) {
                    subCategoryList.add(it)
                }

                subcategorySpinner.adapter = SubCategorySpinnerAdapter(
                    context = this@ItemAddActivity, array_name = R.array.model_acura_name,
                    item_other_spinner = R.layout.item_other_spinner,
                    names = subCategoryList, actionListener = this@ItemAddActivity
                )
            }
        }
    }

    override fun transportOnClick(position: Int) {
        val typeList = arrayListOf<CarTypeModel>()
        binding.apply {
            carModelSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                ) {
                    transportModel = transportModelList[position]
                }

                override fun onNothingSelected(position: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            typeModelTransportCategories.forEach {
                if (it.id == transportModelList[position].transportModelId) {
                    typeList.add(it)
                }

                carTypeModelSpinner.adapter =
                    CarTypeModelSpinnerAdapter(context = this@ItemAddActivity,
                        item_other_spinner = R.layout.item_other_spinner,
                        array_name = R.array.model_acura_name,
                        names = typeList, actionListener = this@ItemAddActivity)
            }
        }
    }

    override fun otherSpinnerOnClick(position: Int) {
        binding.apply {

            yearSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        year = parent?.getItemAtPosition(position) as String
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            fuelSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        fuel = parent?.getItemAtPosition(position) as String
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            bodyTypeSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        bodyType = parent?.getItemAtPosition(position) as String
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            driveUnitSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        driveUnit = parent?.getItemAtPosition(position) as String
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            carColorSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        carColor = parent?.getItemAtPosition(position) as String
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            cppSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        cpp = parent?.getItemAtPosition(position) as String
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            steeringWheelSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        steeringWheel = parent?.getItemAtPosition(position) as String
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            conditionSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        condition = parent?.getItemAtPosition(position) as String
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            engineCapacitySpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        engineCapacity = parent?.getItemAtPosition(position) as String
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            currencySpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        currency = parent?.getItemAtPosition(position) as String
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
        }
    }

    override fun regionSpinnerOnClick(position: Int) {
        binding.apply {
            val cityList = arrayListOf<City>()
            regionSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        region = parent?.getItemAtPosition(position) as Region
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            cities.forEach {
                if (it.id == regions[position].id) {
                    cityList.add(it)
                }

                citySpinner.adapter = CitySpinnerAdapter(
                    context = this@ItemAddActivity, array_name = R.array.model_acura_name,
                    item_other_spinner = R.layout.item_other_spinner,
                    names = cityList, actionListener = this@ItemAddActivity
                )
            }
        }
    }

    override fun carTypeModelSpinnerOnClick(position: Int) {
        binding.apply {
            carTypeModelSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        carTypeModel = parent?.getItemAtPosition(position) as CarTypeModel
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
        }
    }

    override fun citySpinnerOnClick(position: Int) {
        binding.apply {
            citySpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        city = parent?.getItemAtPosition(position) as City
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
        }
    }

    override fun subCategorySpinnerOnClick(position: Int) {
        binding.apply {
            subcategorySpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        subCategory = subCategories[position]
                        binding.transportConstraint.visibility =
                            if (position == 0 && category?.categoryName == "TRANSPORT") View.VISIBLE
                            else View.GONE
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
        }
    }
}