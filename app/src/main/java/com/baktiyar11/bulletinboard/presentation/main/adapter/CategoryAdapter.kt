package com.baktiyar11.bulletinboard.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemCategoryBinding
import com.baktiyar11.bulletinboard.domain.models.category.Category
import com.squareup.picasso.Picasso

class CategoryAdapter(private val actionListener: ItemClickListenerCategory) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var categoryList: List<Category> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        val binding = ItemCategoryBinding.bind(view)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(category = categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.apply {
                categoryName.text = category.categoryName
                Picasso.get().load(category.categoryIcon).into(categoryIcon)
            }
            itemView.setOnClickListener {
                actionListener.showDetailsCategory(category)
            }
        }
    }
}

interface ItemClickListenerCategory {
    fun showDetailsCategory(category: Category)
}