package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.animals.Animals

class AnimalsAdapter(private val actionListener: ItemClickListenerAnimals) :
    RecyclerView.Adapter<AnimalsAdapter.AnimalsViewHolder>() {

    var animalsList: List<Animals> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalsViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return AnimalsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalsViewHolder, position: Int) {
        holder.bind(animals = animalsList[position])
    }

    override fun getItemCount(): Int = animalsList.size

    inner class AnimalsViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animals: Animals) {
            binding.apply {
                productItemPrice.text = animals.priceAnimals
                productItemHeader.text = animals.headerAnimals
            }
            itemView.setOnClickListener {
                actionListener.showDetailsAnimals(animals)
            }
        }
    }
}

interface ItemClickListenerAnimals {
    fun showDetailsAnimals(animals: Animals)
}