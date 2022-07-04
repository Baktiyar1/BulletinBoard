package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.taxi.Taxi

class TaxiAdapter (private val actionListener: ItemClickListenerTaxi) :
    RecyclerView.Adapter<TaxiAdapter.TaxiViewHolder>() {

    var taxiList: List<Taxi> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaxiViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return TaxiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaxiViewHolder, position: Int) {
        holder.bind(taxi = taxiList[position])
    }

    override fun getItemCount(): Int = taxiList.size

    inner class TaxiViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(taxi: Taxi) {
            binding.apply {
                productItemPrice.text = taxi.priceTaxi
                productItemHeader.text = taxi.headerTaxi
            }
            itemView.setOnClickListener {
                actionListener.showDetailsTaxi(taxi)
            }
        }
    }
}

interface ItemClickListenerTaxi {
    fun showDetailsTaxi(taxi: Taxi)
}