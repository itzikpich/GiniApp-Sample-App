package com.itzikpich.giniappssampleapp.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itzikpich.giniappssampleapp.R
import com.itzikpich.giniappssampleapp.databinding.ListItemDoubleBinding
import com.itzikpich.giniappssampleapp.databinding.ListItemSingleBinding
import com.itzikpich.giniappssampleapp.models.NumberItemType
import com.itzikpich.giniappssampleapp.models.NumberType
import com.itzikpich.giniappssampleapp.view_holders.ViewBindingViewHolder


class NumberAdapter : RecyclerView.Adapter<ViewBindingViewHolder>() {

    val numbers = mutableListOf<NumberItemType>()

    fun setList(num: List<NumberItemType>) {
        numbers.clear()
        numbers.addAll(num)
        this.notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int =
        when(numbers[position].type) {
            NumberType.SINGLE -> R.layout.list_item_single
            NumberType.DOUBLE -> R.layout.list_item_double
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when(viewType) {
            R.layout.list_item_single -> ViewBindingViewHolder.createVH(parent, ListItemSingleBinding::inflate)
            R.layout.list_item_double -> ViewBindingViewHolder.createVH(parent, ListItemDoubleBinding::inflate)
            else -> throw Exception("layout must be list_item_single or list_item_double")
        }

    override fun onBindViewHolder(holder: ViewBindingViewHolder, position: Int) {
        val item = numbers[position]
        (holder.binding as? ListItemSingleBinding)?.apply {
            this.number.text = item.numberItem.toString()
        }
        (holder.binding as? ListItemDoubleBinding)?.apply {
            this.number.text = item.numberItem.toString()
        }
    }

    override fun getItemCount(): Int = numbers.size


}