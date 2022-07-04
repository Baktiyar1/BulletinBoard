package com.baktiyar11.bulletinboard.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.databinding.ItemProductsBinding
import com.baktiyar11.bulletinboard.domain.models.category.childrenWord.ChildrenWord

class ChildrenWordAdapter(private val actionListener: ItemClickListenerChildrenWord) :
    RecyclerView.Adapter<ChildrenWordAdapter.ChildrenWordViewHolder>() {

    var childrenWordList: List<ChildrenWord> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildrenWordViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        val binding = ItemProductsBinding.bind(view)
        return ChildrenWordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildrenWordViewHolder, position: Int) {
        holder.bind(childrenWord = childrenWordList[position])
    }

    override fun getItemCount(): Int = childrenWordList.size

    inner class ChildrenWordViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(childrenWord: ChildrenWord) {
            binding.apply {
                productItemPrice.text = childrenWord.priceChildrenWord
                productItemHeader.text = childrenWord.headerChildrenWord
            }
            itemView.setOnClickListener {
                actionListener.showDetailsChildrenWord(childrenWord)
            }
        }
    }
}

interface ItemClickListenerChildrenWord {
    fun showDetailsChildrenWord(childrenWord: ChildrenWord)
}