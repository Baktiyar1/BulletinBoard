package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.giveForFree.GiveForFree
import com.squareup.picasso.Picasso

class GiveForFreeAdapter(private val actionListener: ItemClickListenerGiveForFree) :
    RecyclerView.Adapter<GiveForFreeAdapter.GiveForFreeViewHolder>() {

    var giveForFreeList: List<GiveForFree> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiveForFreeViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return GiveForFreeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GiveForFreeViewHolder, position: Int) {
        holder.bind(giveForFree = giveForFreeList[position])
    }

    override fun getItemCount(): Int = giveForFreeList.size

    inner class GiveForFreeViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(giveForFree: GiveForFree) {
            binding.apply {
                productItemPrice.text = giveForFree.price
                productItemHeader.text = giveForFree.header
                Picasso.get().load(giveForFree.icon.url).into(goodImageItem)
            }
            itemView.setOnClickListener {
                actionListener.showDetailsGiveForFree(giveForFree)
            }
        }
    }
}

interface ItemClickListenerGiveForFree {
    fun showDetailsGiveForFree(giveForFree: GiveForFree)
}