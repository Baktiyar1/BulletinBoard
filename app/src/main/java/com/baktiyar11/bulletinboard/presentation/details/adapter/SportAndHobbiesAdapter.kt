package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.sportAndHobbies.SportAndHobbies

class SportAndHobbiesAdapter(private val actionListener: ItemClickListenerSportAndHobbies) :
    RecyclerView.Adapter<SportAndHobbiesAdapter.SportAndHobbiesViewHolder>() {

    var sportAndHobbiesList: List<SportAndHobbies> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportAndHobbiesViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return SportAndHobbiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SportAndHobbiesViewHolder, position: Int) {
        holder.bind(sportAndHobbies = sportAndHobbiesList[position])
    }

    override fun getItemCount(): Int = sportAndHobbiesList.size

    inner class SportAndHobbiesViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sportAndHobbies: SportAndHobbies) {
            binding.apply {
                productItemPrice.text = sportAndHobbies.priceSportAndHobbies
                productItemHeader.text = sportAndHobbies.headerSportAndHobbies
            }
            itemView.setOnClickListener {
                actionListener.showDetailsSportAndHobbies(sportAndHobbies)
            }
        }
    }
}

interface ItemClickListenerSportAndHobbies {
    fun showDetailsSportAndHobbies(sportAndHobbies: SportAndHobbies)
}