package com.cep96.padc_x_travel_cep.adapters

import androidx.recyclerview.widget.RecyclerView
import com.cep96.padc_x_travel_cep.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T : BaseViewHolder<W>, W>: RecyclerView.Adapter<T>() {

    var mData: MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    fun setData(data: List<W>){
        mData = data as MutableList<W>
        notifyDataSetChanged()
    }

}