package com.baktiyar11.bulletinboard.presentation.item_add.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemOtherSpinnerBinding
import com.baktiyar11.bulletinboard.domain.models.category.spinnerModels.City

class CitySpinnerAdapter(
    context: Context, item_other_spinner: Int, array_name: Int,
    names: ArrayList<City>, private val actionListener: CitySpinnerOnClickListener,
) : ArrayAdapter<City>(context, item_other_spinner, array_name, names) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val city: City = getItem(position)!!
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_other_spinner, null, true)
        val binding = ItemOtherSpinnerBinding.bind(view)
        binding.goodCategoryName.text = city.title
        actionListener.citySpinnerOnClick(position)
        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View? = convertView
        if (view == null) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_other_spinner, parent, false)
        }
        val city: City = getItem(position)!!
        val binding = ItemOtherSpinnerBinding.bind(view!!)
        binding.goodCategoryName.text = city.title
        return binding.root
    }
}

interface CitySpinnerOnClickListener {
    fun citySpinnerOnClick(position: Int)
}