package com.baktiyar11.bulletinboard.presentation.item_add.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemOtherSpinnerBinding

class OtherSpinnerAdapter(
    context: Context, item_other_spinner: Int, array_name: Int,
    names: ArrayList<String>,
    private val actionListener: OtherSpinnerOnClickListener,
) : ArrayAdapter<String>(context, item_other_spinner, array_name, names) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val category: String = getItem(position)!!
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_other_spinner, null, true)
        val binding = ItemOtherSpinnerBinding.bind(view)
        binding.goodCategoryName.text = category
        actionListener.otherSpinnerOnClick(position)
        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View? = convertView
        if (view == null) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_other_spinner, parent, false)
        }
        val binding = ItemOtherSpinnerBinding.bind(view!!)
        binding.goodCategoryName.text = getItem(position)!!
        return binding.root
    }
}

interface OtherSpinnerOnClickListener {
    fun otherSpinnerOnClick(position: Int)
}