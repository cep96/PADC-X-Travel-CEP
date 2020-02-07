package com.cep96.padc_x_travel_cep.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cep96.padc_x_travel_cep.R
import com.cep96.padc_x_travel_cep.data.vos.CountryVO
import com.cep96.padc_x_travel_cep.viewholders.PopularToursViewHolder

class PopularTourListAdapter: BaseRecyclerAdapter<PopularToursViewHolder, CountryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularToursViewHolder {
        return PopularToursViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_popular_tours, parent, false))
    }
}