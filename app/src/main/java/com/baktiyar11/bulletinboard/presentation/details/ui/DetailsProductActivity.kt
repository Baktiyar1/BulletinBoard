package com.baktiyar11.bulletinboard.presentation.details.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.baktiyar11.bulletinboard.databinding.ActivityDetailsProductBinding
import com.baktiyar11.bulletinboard.domain.models.Image
import com.baktiyar11.bulletinboard.domain.models.category.Abstract
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.domain.models.category.animals.Animals
import com.baktiyar11.bulletinboard.domain.models.category.childrenWord.ChildrenWord
import com.baktiyar11.bulletinboard.domain.models.category.electronics.Electronics
import com.baktiyar11.bulletinboard.domain.models.category.giveForFree.GiveForFree
import com.baktiyar11.bulletinboard.domain.models.category.medicalProducts.MedicalProducts
import com.baktiyar11.bulletinboard.domain.models.category.personalItems.PersonalItems
import com.baktiyar11.bulletinboard.domain.models.category.realEstate.RealEstate
import com.baktiyar11.bulletinboard.domain.models.category.services.Services
import com.baktiyar11.bulletinboard.domain.models.category.sportAndHobbies.SportAndHobbies
import com.baktiyar11.bulletinboard.domain.models.category.taxi.Taxi
import com.baktiyar11.bulletinboard.domain.models.category.transport.Transport
import com.baktiyar11.bulletinboard.domain.models.category.work.Work
import com.baktiyar11.bulletinboard.utils.CATEGORY_KEY
import com.baktiyar11.bulletinboard.utils.PRODUCT_KEY
import com.squareup.picasso.Picasso
import java.lang.Exception

class DetailsProductActivity : AppCompatActivity() {

    private val binding: ActivityDetailsProductBinding by lazy {
        ActivityDetailsProductBinding.inflate(layoutInflater)
    }
    private val category: Category by lazy {
        intent!!.extras!!.getSerializable(CATEGORY_KEY) as Category
    }
    private var categoryString: String? = null
    private var subcategory: String? = null
    private var model: String? = null
    private var brand: String? = null
    private var year: String? = null
    private var bodyType: String? = null
    private var driverUnit: String? = null
    private var fuelType: String? = null
    private var color: String? = null
    private var rrcType: String? = null
    private var steeringWheel: String? = null
    private var condition: String? = null
    private var engineCapacity: String? = null
    private var header: String? = null
    private var price: String? = null
    private var city: String? = null
    private var userPhone: String? = null
    private var icon: Image? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            backMainMenu.setOnClickListener {
                val intent =
                    Intent(this@DetailsProductActivity, DetailsCategoryActivity::class.java)
                intent.putExtra(CATEGORY_KEY, category)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }

            fabDetails.setOnClickListener {
                call()
            }

            when (val newObject = intent!!.extras!!.getSerializable(PRODUCT_KEY) as Abstract) {
                is Transport -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    model = newObject.model
                    brand = newObject.brand
                    year = newObject.year
                    color = newObject.color
                    bodyType = newObject.bodyType
                    driverUnit = newObject.driverUnit
                    fuelType = newObject.fuelType
                    rrcType = newObject.rrcType
                    steeringWheel = newObject.steeringWheel
                    condition = newObject.condition
                    engineCapacity = newObject.engineCapacity
                    initViewsAll()
                }
                is RealEstate -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    initViewsAll()
                }
                is Taxi -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    initViewsAll()
                }
                is Electronics -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    initViewsAll()
                }
                is Services -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    initViewsAll()
                }
                is Work -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    initViewsAll()
                }
                is PersonalItems -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    initViewsAll()
                }
                is Animals -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    initViewsAll()
                }
                is SportAndHobbies -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    initViewsAll()
                }
                is MedicalProducts -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    initViewsAll()
                }
                is ChildrenWord -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    subcategory = newObject.subcategory
                    initViewsAll()
                }
                is GiveForFree -> {
                    categoryString = newObject.category
                    header = newObject.header
                    price = newObject.price
                    city = newObject.city
                    userPhone = newObject.userPhone
                    icon = newObject.icon
                    initViewsAll()
                }
            }
        }
    }

    private fun initViewsAll() = binding.apply {
        detailsGoodHeader.text = header
        detailsGoodPrice.text = price
        detailsGoodCity.text = city
        detailsUserPhoneNumber.text = userPhone
        detailsGoodCategory.text = categoryString
        Picasso.get().load(icon?.url).into(detailsGoodImage)

        if (categoryString != "GIVE FOR FREE") {
            detailsGoodSubCategory.text = subcategory
            if (categoryString == "TRANSPORT") {
                if (subcategory == "PASSENGER CAR") {
                    detailsGoodCharacterCardView.visibility = View.VISIBLE
                    detailsGoodSubCategory.visibility = View.VISIBLE
                    textView10.visibility = View.VISIBLE

                    detailsTransportModel.text = model
                    detailsCarBrand.text = brand
                    detailsCarYear.text = year
                    detailsCarFuel.text = fuelType
                    detailsCarBody.text = bodyType
                    detailsCarDriveUnit.text = driverUnit
                    detailsCarColor.text = color
                    detailsCarCpp.text = rrcType
                    detailsCarSteeringWheel.text = steeringWheel
                    detailsCarCondition.text = condition
                    detailsCarEngineCapacity.text = engineCapacity
                } else detailsGoodCharacterCardView.visibility = View.GONE
            } else detailsGoodCharacterCardView.visibility = View.GONE
        } else {
            detailsGoodSubCategory.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
        }
    }

    private fun call(){
        try {
            val uri = "tel:" + userPhone?.trim()
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse(uri)
            startActivity(intent)
        } catch (e: Exception) {
            ActivityCompat.requestPermissions(this@DetailsProductActivity,
                arrayOf(android.Manifest.permission.CALL_PHONE), 1)
        }
    }
}