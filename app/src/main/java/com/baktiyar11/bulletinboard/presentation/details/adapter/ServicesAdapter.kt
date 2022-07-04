package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.services.Services

class ServicesAdapter(private val actionListener: ItemClickListenerServices) :
    RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {

    var servicesList: List<Services> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return ServicesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.bind(services = servicesList[position])
    }

    override fun getItemCount(): Int = servicesList.size

    inner class ServicesViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(services: Services) {
            binding.apply {
                productItemPrice.text = services.priceServices
                productItemHeader.text = services.headerServices
            }
            itemView.setOnClickListener {
                actionListener.showDetailsServices(services)
            }
        }
    }
}

interface ItemClickListenerServices {
    fun showDetailsServices(services: Services)
}