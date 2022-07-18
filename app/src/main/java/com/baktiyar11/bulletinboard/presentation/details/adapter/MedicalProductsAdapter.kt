package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.medicalProducts.MedicalProducts
import com.squareup.picasso.Picasso

class MedicalProductsAdapter(private val actionListener: ItemClickListenerMedicalProducts) :
    RecyclerView.Adapter<MedicalProductsAdapter.MedicalProductsViewHolder>() {

    var medicalProductsList: List<MedicalProducts> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicalProductsViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return MedicalProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedicalProductsViewHolder, position: Int) {
        holder.bind(medicalProducts = medicalProductsList[position])
    }

    override fun getItemCount(): Int = medicalProductsList.size

    inner class MedicalProductsViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(medicalProducts: MedicalProducts) {
            binding.apply {
                productItemPrice.text = medicalProducts.price
                productItemHeader.text = medicalProducts.header
                Picasso.get().load(medicalProducts.icon.url).into(goodImageItem)
            }
            itemView.setOnClickListener {
                actionListener.showDetailsMedicalProducts(medicalProducts)
            }
        }
    }
}

interface ItemClickListenerMedicalProducts {
    fun showDetailsMedicalProducts(medicalProducts: MedicalProducts)
}