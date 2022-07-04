package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.personalItems.PersonalItems

class PersonalItemsAdapter(private val actionListener: ItemClickListenerPersonalItems) :
    RecyclerView.Adapter<PersonalItemsAdapter.PersonalItemsViewHolder>() {

    var personalItemsList: List<PersonalItems> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalItemsViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return PersonalItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonalItemsViewHolder, position: Int) {
        holder.bind(personalItems = personalItemsList[position])
    }

    override fun getItemCount(): Int = personalItemsList.size

    inner class PersonalItemsViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(personalItems: PersonalItems) {
            binding.apply {
                productItemPrice.text = personalItems.pricePersonalItems
                productItemHeader.text = personalItems.headerPersonalItems
            }
            itemView.setOnClickListener {
                actionListener.showDetailsPersonalItems(personalItems)
            }
        }
    }
}

interface ItemClickListenerPersonalItems {
    fun showDetailsPersonalItems(personalItems: PersonalItems)
}