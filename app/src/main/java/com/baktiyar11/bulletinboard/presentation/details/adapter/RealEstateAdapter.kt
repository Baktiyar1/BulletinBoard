package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.realEstate.RealEstate

class RealEstateAdapter(private val actionListener: ItemClickListenerRealEstate) :
    RecyclerView.Adapter<RealEstateAdapter.RealEstateViewHolder>() {

    var realEstateList: List<RealEstate> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealEstateViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return RealEstateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RealEstateViewHolder, position: Int) {
        holder.bind(realEstate = realEstateList[position])
    }

    override fun getItemCount(): Int = realEstateList.size

    inner class RealEstateViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(realEstate: RealEstate) {
            binding.apply {
                productItemPrice.text = realEstate.priceRealEstate
                productItemHeader.text = realEstate.headerRealEstate
            }
            itemView.setOnClickListener {
                actionListener.showDetailsRealEstate(realEstate)
            }
        }
    }
}

interface ItemClickListenerRealEstate {
    fun showDetailsRealEstate(realEstate: RealEstate)
}