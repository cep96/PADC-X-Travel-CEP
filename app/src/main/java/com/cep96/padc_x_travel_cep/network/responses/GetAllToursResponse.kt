package com.cep96.padc_x_travel_cep.network.responses

import com.cep96.padc_x_travel_cep.data.vos.TourVO
import com.cep96.padc_x_travel_cep.utils.CODE_RESPONSE_OK
import com.google.gson.annotations.SerializedName

data class GetAllToursResponse (

    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: TourVO
){
    fun isResponseOK(): Boolean = (data != null) && (code == CODE_RESPONSE_OK)
}