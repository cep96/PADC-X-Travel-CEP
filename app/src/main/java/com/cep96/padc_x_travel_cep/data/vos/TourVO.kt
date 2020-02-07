package com.cep96.padc_x_travel_cep.data.vos

import com.google.gson.annotations.SerializedName

data class TourVO(
    @SerializedName("country") val country: List<CountryVO>,
    @SerializedName("popular_tours") val popularTours: List<CountryVO>
)

