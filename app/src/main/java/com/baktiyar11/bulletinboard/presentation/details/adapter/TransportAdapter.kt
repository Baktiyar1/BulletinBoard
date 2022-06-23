package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.transport.Transport

interface ItemClickListenerTransport {
    fun showDetailsTransport(transport: Transport)
}

class TransportAdapter(private val actionListener: ItemClickListenerTransport)
    : RecyclerView.Adapter<TransportAdapter.TransportViewHolder>() {

    var transportList: List<Transport> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransportViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return TransportViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransportViewHolder, position: Int) {
        holder.bind(transport = transportList[position])
    }

    override fun getItemCount(): Int = transportList.size

    inner class TransportViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(transport: Transport) {
            binding.apply {
                productItemPrice.text = transport.transportPrice
                productItemHeader.text = transport.transportHeader
            }
            itemView.setOnClickListener {
                actionListener.showDetailsTransport(transport)
            }
        }
    }
}