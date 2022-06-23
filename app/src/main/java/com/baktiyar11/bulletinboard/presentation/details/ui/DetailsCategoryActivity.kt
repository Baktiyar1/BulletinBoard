package com.baktiyar11.bulletinboard.presentation.details.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.baktiyar11.bulletinboard.data.RetrofitBuilder
import com.baktiyar11.bulletinboard.databinding.ActivityDetailsBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.baktiyar11.bulletinboard.domain.models.category.transport.Transport
import com.baktiyar11.bulletinboard.presentation.details.adapter.ItemClickListenerTransport
import com.baktiyar11.bulletinboard.presentation.details.adapter.TransportAdapter
import com.baktiyar11.bulletinboard.utils.CATEGORY_KEY
import com.baktiyar11.bulletinboard.utils.PRODUCT_KEY
import com.baktiyar11.bulletinboard.utils.toast
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsCategoryActivity : AppCompatActivity() {

    private val binding: ActivityDetailsBinding by lazy {
        ActivityDetailsBinding.inflate(layoutInflater)
    }
    private var transportList: MutableList<Transport>? = null
    private val transportAdapter: TransportAdapter by lazy {
        TransportAdapter(object : ItemClickListenerTransport {
            override fun showDetailsTransport(transport: Transport) {
                val intent =
                    Intent(this@DetailsCategoryActivity, DetailsProductActivity::class.java)
                intent.putExtra(PRODUCT_KEY, transport)
                startActivity(intent)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            recViewProduct.adapter = transportAdapter
            val category = intent!!.extras!!.getSerializable(CATEGORY_KEY) as Category
            detailsCategoryDescription.text = category.categoryDescription
            Picasso.get().load(category.categoryIcon).into(imageCategoryDetails)
            if (category.categoryName == "TRANSPORT") {
                lifecycleScope.launch(Dispatchers.IO) {
                    val response =
                        RetrofitBuilder.api.getAllTransport(id = "{\"category\":\"${category.categoryName}\"}")
                    if (response.body()!!.results.isEmpty()) noOffer()
                    else {
                        withContext(Dispatchers.Main) {
                            if (response.isSuccessful) {
                                transportList = response.body()!!.results.toMutableList()
                                transportAdapter.transportList = transportList!!
                                toast(response.body()!!.results.size.toString())
                            } else toast(response.message())
                        }
                    }
                }
            }
        }
    }

    private fun noOffer() {
        binding.apply {
            noOfferText.visibility = View.VISIBLE
            fabDetails.visibility = View.GONE
        }
    }
}