package com.cep96.padc_x_travel_cep.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.cep96.padc_x_travel_cep.data.vos.CountryVO
import kotlinx.android.synthetic.main.item_popular_tours.view.*

class PopularToursViewHolder(itemView: View) : BaseViewHolder<CountryVO>(itemView) {
    override fun bindData(data: CountryVO) {

        Glide.with(itemView).load(data.photos[0]).into(itemView.ivPopularTour)

//        itemView.tvCountryName.text = data.location
        itemView.tvAverageRating.text = data.averageRating.toString()

    }
}