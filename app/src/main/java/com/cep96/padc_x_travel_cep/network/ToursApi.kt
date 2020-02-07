package com.cep96.padc_x_travel_cep.network

import com.cep96.padc_x_travel_cep.network.responses.GetAllToursResponse
import com.cep96.padc_x_travel_cep.utils.GET_ALL_TOURS
import retrofit2.Call
import retrofit2.http.GET

interface ToursApi {

    @GET(GET_ALL_TOURS)
    fun getAllTours(): Call<GetAllToursResponse>
}