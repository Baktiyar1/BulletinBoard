package com.baktiyar11.bulletinboard.presentation.item_add.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ActivityItemAddBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.domain.models.category.transport.TransportModel
import com.baktiyar11.bulletinboard.presentation.GetListClass
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.CategoryItemOnClickListener
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.ItemAddCategorySpinnerAdapter
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.ItemAddTransportModelSpinnerAdapter
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.TransportItemOnClickListener
import com.baktiyar11.bulletinboard.presentation.main.ui.AnnouncementListsActivity
import com.baktiyar11.bulletinboard.utils.ALL_CATEGORY_KEY
import com.baktiyar11.bulletinboard.utils.BUNDLE
import com.baktiyar11.bulletinboard.utils.TRANSPORT
import com.baktiyar11.bulletinboard.utils.toast

class ItemAddActivity : AppCompatActivity(), TransportItemOnClickListener, CategoryItemOnClickListener{

    private val binding: ActivityItemAddBinding by lazy {
        ActivityItemAddBinding.inflate(layoutInflater)
    }
    private var addCategorySpinnerAdapter: ItemAddCategorySpinnerAdapter? = null
    private var categoryList: ArrayList<Category> = arrayListOf()
    private var transportModelList: ArrayList<TransportModel> =
        GetListClass().addAllTransportModel()
    private var addTransportModelSpinnerAdapter: ItemAddTransportModelSpinnerAdapter? = null
    private var numberEdit: Boolean = false
    var category: Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {

            getAllCategory()

            closeImage.setOnClickListener {
                startActivity(Intent(this@ItemAddActivity,
                    AnnouncementListsActivity::class.java))
            }

            addCategorySpinnerAdapter = ItemAddCategorySpinnerAdapter(
                context = this@ItemAddActivity,
                item_good_category = R.layout.item_good_category,
                category_name = R.array.categories,
                categories = categoryList,
                this@ItemAddActivity
            )
            categorySpinner.adapter = addCategorySpinnerAdapter!!
            citiesAndVillagesInfo()
            negotiableSwitch()
            myNumberSwitch()
            transportCategory()

            addBtn.setOnClickListener {
                getCategory(TRANSPORT)
                addBtn()
            }

        }
    }

    private fun getCategory(categoryName: String) {
        categoryList.forEach {
            if (it.categoryName == categoryName) {
                category = it
            } else {
                getCategory(categoryName)
            }
        }
    }

    private fun addBtn() {
        binding.apply {
            if (!numberEdit) {
                val headerText: String = headerMain.text.toString()
                val descText: String = descMain.text.toString()
                val numberText: String = phoneNumberEditText.text.toString()
                if (headerText.isEmpty() || descText.isEmpty() || numberText.isEmpty()) {
                    toast("Fill in all the fields!")
                }
            } else {
                val headerText: String = headerMain.text.toString()
                val descText: String = descMain.text.toString()
                if (headerText.isEmpty() || descText.isEmpty()) {
                    toast("Fill in all the fields!")
                }
            }
        }
    }

    private fun myNumberSwitch() {
        binding.apply {
            myNumberSwitch.setOnCheckedChangeListener { _, isChecked ->
                run {
                    if (!isChecked) {
                        phoneNumberEditText.visibility = View.VISIBLE
                        phoneNumberTextView.visibility = View.GONE
                        numberEdit = true
                    } else {
                        phoneNumberTextView.visibility = View.VISIBLE
                        phoneNumberEditText.visibility = View.GONE
                        numberEdit = false
                    }
                }
            }
        }
    }

    private fun negotiableSwitch() {
        binding.apply {
            negotiableSwitch.setOnCheckedChangeListener { _, isChecked ->
                run {
                    if (!isChecked) {
                        priceConstraint.visibility = View.VISIBLE
                    } else {
                        priceConstraint.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun citiesAndVillagesInfo() {
        binding.apply {
            spinner(R.array.volute, currencySpinner)
            spinner(R.array.region, regionSpinner)
            regionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                ) {
                    when (position) {
                        0 -> spinner(R.array.cities_and_villages_chui, citySpinner)
                        1 -> spinner(R.array.cities_and_villages_issyk_kul, citySpinner)
                        2 -> spinner(R.array.cities_and_villages_talas, citySpinner)
                        3 -> spinner(R.array.cities_and_villages_jalal_abab, citySpinner)
                        4 -> spinner(R.array.cities_and_villages_naryn, citySpinner)
                        5 -> spinner(R.array.cities_and_villages_osh, citySpinner)
                        else -> spinner(R.array.cities_and_villages_batken, citySpinner)
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }

    private fun transportCategory() {
        binding.apply {
            categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                ) {
                    when (position) {
                        0 -> transportCategoryInfo()
                        else -> transporConstraint.visibility = View.GONE
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }

    private fun transportCategoryInfo() {
        binding.apply {
            spinner(R.array.sub_transport_category, subcategorySpinner)
            subcategorySpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        when (position) {
                            0 -> {
                                transporConstraint.visibility = View.VISIBLE
                                getAllTransportModel()
                                modelInfo()
                                spinner(R.array.transport_year, yearSpinner)
                                spinner(R.array.transport_fuel, fuelSpinner)
                                spinner(R.array.transport_body_type, bodyTypeSpinner)
                                spinner(R.array.transport_drive_unit, driveUnitSpinner)
                                spinner(R.array.transport_color, carColorSpinner)
                                spinner(R.array.transport_cpp, cppSpinner)
                                spinner(R.array.transport_steering_wheel, steeringWheelSpinner)
                                spinner(R.array.transport_condition, conditionSpinner)
                                spinner(R.array.transport_engine_capacity, engineCapacitySpinner)
                            }
                            else -> transporConstraint.visibility = View.GONE
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
        }
    }

    private fun modelInfo() {
        binding.apply {
            carModelSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                    ) {
                        when (position) {
                            0 -> spinner(R.array.model_acura_name, carTypeModelSpinner)
                            1 -> spinner(R.array.model_alfa_romeo_name, carTypeModelSpinner)
                            2 -> spinner(R.array.model_alpina_name, carTypeModelSpinner)
                            3 -> spinner(R.array.model_audi_name, carTypeModelSpinner)
                            4 -> spinner(R.array.model_bentley_name, carTypeModelSpinner)
                            5 -> spinner(R.array.model_bmw_name, carTypeModelSpinner)
                            6 -> spinner(R.array.model_byd_name, carTypeModelSpinner)
                            7 -> spinner(R.array.model_cadillac_name, carTypeModelSpinner)
                            8 -> spinner(R.array.model_cherry_name, carTypeModelSpinner)
                            9 -> spinner(R.array.model_chevrolet_name, carTypeModelSpinner)
                            10 -> spinner(R.array.model_chrysler_name, carTypeModelSpinner)
                            11 -> spinner(R.array.model_citroen_name, carTypeModelSpinner)
                            12 -> spinner(R.array.model_daewoo_name, carTypeModelSpinner)
                            13 -> spinner(R.array.model_daihatsu_name, carTypeModelSpinner)
                            14 -> spinner(R.array.model_dodge_name, carTypeModelSpinner)
                            15 -> spinner(R.array.model_dong_feng_name, carTypeModelSpinner)
                            16 -> spinner(R.array.model_fiat_name, carTypeModelSpinner)
                            17 -> spinner(R.array.model_ford_name, carTypeModelSpinner)
                            18 -> spinner(R.array.model_geekly_name, carTypeModelSpinner)
                            19 -> spinner(R.array.model_gmc_name, carTypeModelSpinner)
                            20 -> spinner(R.array.model_great_wall_name, carTypeModelSpinner)
                            21 -> spinner(R.array.model_honda_name, carTypeModelSpinner)
                            22 -> spinner(R.array.model_hummer_name, carTypeModelSpinner)
                            23 -> spinner(R.array.model_hyundai_name, carTypeModelSpinner)
                            24 -> spinner(R.array.model_infinity_name, carTypeModelSpinner)
                            25 -> spinner(R.array.model_isuzu_name, carTypeModelSpinner)
                            26 -> spinner(R.array.model_jaguar_name, carTypeModelSpinner)
                            27 -> spinner(R.array.model_jeep_name, carTypeModelSpinner)
                            28 -> spinner(R.array.model_kia_name, carTypeModelSpinner)
                            29 -> spinner(R.array.model_lamborghini_name, carTypeModelSpinner)
                            30 -> spinner(R.array.model_land_rover_name, carTypeModelSpinner)
                            31 -> spinner(R.array.model_lexus_name, carTypeModelSpinner)
                            32 -> spinner(R.array.model_lifan_name, carTypeModelSpinner)
                            33 -> spinner(R.array.model_lincoln_name, carTypeModelSpinner)
                            34 -> spinner(R.array.model_mazda_name, carTypeModelSpinner)
                            35 -> spinner(R.array.model_mercedes_benz_name, carTypeModelSpinner)
                            36 -> spinner(R.array.model_mini_name, carTypeModelSpinner)
                            37 -> spinner(R.array.model_mitsubishi_name, carTypeModelSpinner)
                            38 -> spinner(R.array.model_nissan_name, carTypeModelSpinner)
                            39 -> spinner(R.array.model_opel_name, carTypeModelSpinner)
                            40 -> spinner(R.array.model_peugeot_name, carTypeModelSpinner)
                            41 -> spinner(R.array.model_porsche_name, carTypeModelSpinner)
                            42 -> spinner(R.array.model_ravon_name, carTypeModelSpinner)
                            43 -> spinner(R.array.model_renault_name, carTypeModelSpinner)
                            44 -> spinner(R.array.model_rover_name, carTypeModelSpinner)
                            45 -> spinner(R.array.model_saab_name, carTypeModelSpinner)
                            46 -> spinner(R.array.model_saturn_name, carTypeModelSpinner)
                            47 -> spinner(R.array.model_scion_name, carTypeModelSpinner)
                            48 -> spinner(R.array.model_seat_name, carTypeModelSpinner)
                            49 -> spinner(R.array.model_scoda_name, carTypeModelSpinner)
                            50 -> spinner(R.array.model_ssang_yong_name, carTypeModelSpinner)
                            51 -> spinner(R.array.model_subaru_name, carTypeModelSpinner)
                            52 -> spinner(R.array.model_suzuki_name, carTypeModelSpinner)
                            53 -> spinner(R.array.model_tofas_name, carTypeModelSpinner)
                            54 -> spinner(R.array.model_toyota_name, carTypeModelSpinner)
                            else -> modelOtherName()
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
        }
    }

    private fun getAllTransportModel() {
        addTransportModelSpinnerAdapter = ItemAddTransportModelSpinnerAdapter(
            context = this@ItemAddActivity,
            item_good_category = R.layout.item_good_category,
            transport_model_name = R.array.transport_model_name,
            transport_models = transportModelList,
            this
        )
        binding.carModelSpinner.adapter = addTransportModelSpinnerAdapter!!
    }

    private fun getAllCategory() {
        val intentCategory = intent.getBundleExtra(BUNDLE)
        val categories = intentCategory!!.getSerializable(ALL_CATEGORY_KEY) as ArrayList<Category>?
        categoryList = categories!!
    }

    private fun modelOtherName() {
        binding.apply {
            carTypeModelSpinner.visibility = View.GONE
            carTypeModelEditText.visibility = View.VISIBLE
        }
    }

    private fun spinner(resourceId: Int, spinner: Spinner) {
        binding.apply {
            carTypeModelSpinner.visibility = View.VISIBLE
            carTypeModelEditText.visibility = View.GONE
            val adapter = ArrayAdapter.createFromResource(this@ItemAddActivity,
                resourceId,
                android.R.layout.simple_spinner_item)
            spinner.adapter = adapter
        }
    }

    override fun transportOnClick(position: Int) {
        transportModelList[position]
        toast(transportModelList[position].transportModelName)
    }

    override fun categoryOnClick(position: Int) {
        categoryList[position]
        toast(categoryList[position].categoryName)
    }
}