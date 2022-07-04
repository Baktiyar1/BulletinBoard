package com.baktiyar11.bulletinboard.presentation.item_add.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemGoodCategoryBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.squareup.picasso.Picasso

class ItemAddCategorySpinnerAdapter(
    context: Context,
    item_good_category: Int,
    category_name: Int,
    categories: ArrayList<Category>,
    private val actionListener: CategoryItemOnClickListener,
) : ArrayAdapter<Category>(context, item_good_category, category_name, categories) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val category: Category = getItem(position)!!
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_good_category, null, true)
        val binding = ItemGoodCategoryBinding.bind(view)
        binding.apply {
            goodCategoryName.text = category.categoryName
            Picasso.get().load(category.categoryIcon).into(goodCategoryImage)
            actionListener.categoryOnClick(position)
        }
        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View? = convertView
        val category = getItem(position)!!
        if (view == null) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_good_category, parent, false)
        }
        val binding = ItemGoodCategoryBinding.bind(view!!)
        binding.apply {
            goodCategoryName.text = category.categoryName
            Picasso.get().load(category.categoryIcon).into(goodCategoryImage)
        }
        return binding.root
    }
}

interface CategoryItemOnClickListener {
    fun categoryOnClick(position: Int)
}