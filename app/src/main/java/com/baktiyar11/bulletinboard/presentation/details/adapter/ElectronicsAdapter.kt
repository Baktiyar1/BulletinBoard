package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.electronics.Electronics
import com.baktiyar11.bulletinboard.domain.models.category.taxi.Taxi

class ElectronicsAdapter(private val actionListener: ItemClickListenerElectronics) :
    RecyclerView.Adapter<ElectronicsAdapter.ElectronicsViewHolder>() {

    var electronicsList: List<Electronics> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectronicsViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return ElectronicsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ElectronicsViewHolder, position: Int) {
        holder.bind(electronics = electronicsList[position])
    }

    override fun getItemCount(): Int = electronicsList.size

    inner class ElectronicsViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(electronics: Electronics) {
            binding.apply {
                productItemPrice.text = electronics.priceElectronics
                productItemHeader.text = electronics.headerElectronics
            }
            itemView.setOnClickListener {
                actionListener.showDetailsElectronics(electronics)
            }
        }
    }
}

interface ItemClickListenerElectronics {
    fun showDetailsElectronics(electronics: Electronics)
}