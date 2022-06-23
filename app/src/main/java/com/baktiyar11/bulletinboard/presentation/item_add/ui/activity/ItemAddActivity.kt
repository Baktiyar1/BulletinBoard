package com.baktiyar11.bulletinboard.presentation.item_add.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ActivityItemAddBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.domain.models.category.transport.TransportModel
import com.baktiyar11.bulletinboard.presentation.GetListClass
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.ItemAddCategorySpinnerAdapter
import com.baktiyar11.bulletinboard.presentation.item_add.adapter.ItemAddTransportModelSpinnerAdapter
import com.baktiyar11.bulletinboard.utils.ALL_CATEGORY_KEY
import com.baktiyar11.bulletinboard.utils.BUNDLE

class ItemAddActivity : AppCompatActivity() {

    private val binding: ActivityItemAddBinding by lazy {
        ActivityItemAddBinding.inflate(layoutInflater)
    }
    private var addCategorySpinnerAdapter: ItemAddCategorySpinnerAdapter? = null
    private var categoryList: ArrayList<Category>? = arrayListOf()
    private var transportModelList: ArrayList<TransportModel> =
        GetListClass().addAllTransportModel()
    private var addTransportModelSpinnerAdapter: ItemAddTransportModelSpinnerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {

            getAllCategory()
            addCategorySpinnerAdapter = ItemAddCategorySpinnerAdapter(
                context = this@ItemAddActivity,
                item_good_category = R.layout.item_good_category,
                category_name = R.array.categories,
                categories = categoryList!!
            )
            categorySpinner.adapter = addCategorySpinnerAdapter!!

            transportCategory()

        }
    }

    private fun transportCategory() {
        binding.apply {
            categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long,
                ) {
                    when (position) {
                        0 -> transportCategoryInfo()
                        else -> transporConstraint.visibility = View.GONE
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }

    private fun transportCategoryInfo() {
        binding.apply {
            subTransportCategory()
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
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long, ) {
                        when (position) {
                            0 -> modelName(R.array.model_acura_name)
                            1 -> modelName(R.array.model_alfa_romeo_name)
                            2 -> modelName(R.array.model_alpina_name)
                            3 -> modelName(R.array.model_audi_name)
                            4 -> modelName(R.array.model_bentley_name)
                            5 -> modelName(R.array.model_bmw_name)
                            6 -> modelName(R.array.model_byd_name)
                            7 -> modelName(R.array.model_cadillac_name)
                            8 -> modelName(R.array.model_cherry_name)
                            9 -> modelName(R.array.model_chevrolet_name)
                            10 -> modelName(R.array.model_chrysler_name)
                            11 -> modelName(R.array.model_citroen_name)
                            12 -> modelName(R.array.model_daewoo_name)
                            13 -> modelName(R.array.model_daihatsu_name)
                            14 -> modelName(R.array.model_dodge_name)
                            15 -> modelName(R.array.model_dong_feng_name)
                            16 -> modelName(R.array.model_fiat_name)
                            17 -> modelName(R.array.model_ford_name)
                            18 -> modelName(R.array.model_geekly_name)
                            19 -> modelName(R.array.model_gmc_name)
                            20 -> modelName(R.array.model_great_wall_name)
                            21 -> modelName(R.array.model_honda_name)
                            22 -> modelName(R.array.model_hummer_name)
                            23 -> modelName(R.array.model_hyundai_name)
                            24 -> modelName(R.array.model_infinity_name)
                            25 -> modelName(R.array.model_isuzu_name)
                            26 -> modelName(R.array.model_jaguar_name)
                            27 -> modelName(R.array.model_jeep_name)
                            28 -> modelName(R.array.model_kia_name)
                            29 -> modelName(R.array.model_lamborghini_name)
                            30 -> modelName(R.array.model_land_rover_name)
                            31 -> modelName(R.array.model_lexus_name)
                            32 -> modelName(R.array.model_lifan_name)
                            33 -> modelName(R.array.model_lincoln_name)
                            34 -> modelName(R.array.model_mazda_name)
                            35 -> modelName(R.array.model_mercedes_benz_name)
                            36 -> modelName(R.array.model_mini_name)
                            37 -> modelName(R.array.model_mitsubishi_name)
                            38 -> modelName(R.array.model_nissan_name)
                            39 -> modelName(R.array.model_opel_name)
                            40 -> modelName(R.array.model_peugeot_name)
                            41 -> modelName(R.array.model_porsche_name)
                            42 -> modelName(R.array.model_ravon_name)
                            43 -> modelName(R.array.model_renault_name)
                            44 -> modelName(R.array.model_rover_name)
                            45 -> modelName(R.array.model_saab_name)
                            46 -> modelName(R.array.model_saturn_name)
                            47 -> modelName(R.array.model_scion_name)
                            48 -> modelName(R.array.model_seat_name)
                            49 -> modelName(R.array.model_scoda_name)
                            50 -> modelName(R.array.model_ssang_yong_name)
                            51 -> modelName(R.array.model_subaru_name)
                            52 -> modelName(R.array.model_suzuki_name)
                            53 -> modelName(R.array.model_tofas_name)
                            54 -> modelName(R.array.model_toyota_name)
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
            transport_models = transportModelList
        )
        binding.carModelSpinner.adapter = addTransportModelSpinnerAdapter!!
    }

    private fun getAllCategory() {
        val intentCategory = intent.getBundleExtra(BUNDLE)
        val categories = intentCategory!!.getSerializable(ALL_CATEGORY_KEY) as ArrayList<Category>?
        categoryList = categories
    }

    private fun subTransportCategory() {
        val sunTransportAdapter = ArrayAdapter.createFromResource(this@ItemAddActivity,
            R.array.sub_transport_category, android.R.layout.simple_spinner_item)
        binding.subcategorySpinner.adapter = sunTransportAdapter
    }

    private fun modelName(resourceId: Int) {
        binding.apply {
            val modelAdapter = ArrayAdapter.createFromResource(this@ItemAddActivity,
                resourceId, android.R.layout.simple_spinner_item)
            carTypeModelSpinner.adapter = modelAdapter
        }
    }

    private fun modelOtherName() {
        binding.apply {
        }
    }

}