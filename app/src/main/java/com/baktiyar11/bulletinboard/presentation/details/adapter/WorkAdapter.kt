package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.work.Work

class WorkAdapter(private val actionListener: ItemClickListenerWork) :
    RecyclerView.Adapter<WorkAdapter.WorkViewHolder>() {

    var workList: List<Work> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return WorkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        holder.bind(work = workList[position])
    }

    override fun getItemCount(): Int = workList.size

    inner class WorkViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(work: Work) {
            binding.apply {
                productItemPrice.text = work.priceWork
                productItemHeader.text = work.headerWork
            }
            itemView.setOnClickListener {
                actionListener.showDetailsWork(work)
            }
        }
    }
}

interface ItemClickListenerWork {
    fun showDetailsWork(work: Work)
}