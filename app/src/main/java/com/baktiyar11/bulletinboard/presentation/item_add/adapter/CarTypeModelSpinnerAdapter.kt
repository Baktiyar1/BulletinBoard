package com.baktiyar11.bulletinboard.presentation.item_add.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemOtherSpinnerBinding
import com.baktiyar11.bulletinboard.domain.models.category.transport.CarTypeModel

class CarTypeModelSpinnerAdapter(
    context: Context, item_other_spinner: Int, array_name: Int,
    names: ArrayList<CarTypeModel>, private val actionListener: CarTypeModelSpinnerOnClickListener,
) : ArrayAdapter<CarTypeModel>(context, item_other_spinner, array_name, names) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val carTypeModel: CarTypeModel = getItem(position)!!
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_other_spinner, null, true)
        val binding = ItemOtherSpinnerBinding.bind(view)
        binding.goodCategoryName.text = carTypeModel.title
        actionListener.carTypeModelSpinnerOnClick(position)
        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View? = convertView
        if (view == null) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_other_spinner, parent, false)
        }
        val carTypeModel: CarTypeModel = getItem(position)!!
        val binding = ItemOtherSpinnerBinding.bind(view!!)
        binding.goodCategoryName.text = carTypeModel.title
        return binding.root
    }
}

interface CarTypeModelSpinnerOnClickListener {
    fun carTypeModelSpinnerOnClick(position: Int)
}