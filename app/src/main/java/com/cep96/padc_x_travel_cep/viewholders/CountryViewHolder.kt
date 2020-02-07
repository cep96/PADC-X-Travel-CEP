package com.cep96.padc_x_travel_cep.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.cep96.padc_x_travel_cep.data.vos.CountryVO
import kotlinx.android.synthetic.main.item_country.view.*
import kotlinx.android.synthetic.main.item_country.view.tvAverageRating
import kotlinx.android.synthetic.main.item_country.view.tvCountryName

class CountryViewHolder(itemView: View) : BaseViewHolder<CountryVO>(itemView) {
    override fun bindData(data: CountryVO) {

        Glide.with(itemView).load(data.photos[0]).into(itemView.ivCountry)

//        itemView.tvCountryName.text = data.location
        itemView.tvAverageRating.text = data.averageRating.toString()

    }

}