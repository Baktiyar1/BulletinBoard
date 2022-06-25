package com.baktiyar11.bulletinboard.presentation.item_add.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemGoodCategoryBinding
import com.baktiyar11.bulletinboard.domain.models.category.transport.TransportModel
import com.squareup.picasso.Picasso

class ItemAddTransportModelSpinnerAdapter(
    context: Context, item_good_category: Int,
    transport_model_name: Int, transport_models: ArrayList<TransportModel>,
    private val actionListener: TransportItemOnClickListener,
) : ArrayAdapter<TransportModel>(context, item_good_category,
    transport_model_name, transport_models) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val transportModel: TransportModel = getItem(position)!!
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_good_category, null, true)
        val binding = ItemGoodCategoryBinding.bind(view)
        binding.apply {
            goodCategoryName.text = transportModel.transportModelName
            Picasso.get().load(transportModel.transportModelIcon).into(goodCategoryImage)
            actionListener.transportOnClick(position)
        }
        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View? = convertView
        if (view == null) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_good_category, parent, false)
        }
        val binding = ItemGoodCategoryBinding.bind(view!!)
        binding.apply {
            val transportModel = getItem(position)!!
            goodCategoryName.text = transportModel.transportModelName
            Picasso.get().load(transportModel.transportModelIcon).into(goodCategoryImage)
        }
        return binding.root
    }
}

interface TransportItemOnClickListener {
    fun transportOnClick(position: Int) : TransportModel
}