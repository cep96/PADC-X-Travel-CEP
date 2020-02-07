package com.cep96.padc_x_travel_cep.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cep96.padc_x_travel_cep.R
import com.cep96.padc_x_travel_cep.data.vos.CountryVO
import com.cep96.padc_x_travel_cep.viewholders.CountryViewHolder

class CountryListAdapter: BaseRecyclerAdapter<CountryViewHolder, CountryVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false))
    }
}