package com.baktiyar11.bulletinboard.presentation.item_add.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemAddCategoriesListBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.squareup.picasso.Picasso

interface ItemClickListenerAddCategory {
    fun showDetailsAddCategory(category: Category)
}

class AddCategoryAdapter(private val actionListener: ItemClickListenerAddCategory) :
    RecyclerView.Adapter<AddCategoryAdapter.AddCategoryViewHolder>() {

    var categoryList: List<Category> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddCategoryViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_add_categories_list, parent, false)
        val binding = ItemAddCategoriesListBinding.bind(view)
        return AddCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddCategoryViewHolder, position: Int) {
        holder.bind(category = categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

    inner class AddCategoryViewHolder(private val binding: ItemAddCategoriesListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.apply {
                secondName.text = category.categoryName
                secondDesc.text = category.categoryDescription
                Picasso.get().load(category.categoryIcon).into(secondImage)
            }
            itemView.setOnClickListener {
                actionListener.showDetailsAddCategory(category)
            }
        }
    }
}