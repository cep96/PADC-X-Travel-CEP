package com.cep96.padc_x_travel_cep.data.models

import com.cep96.padc_x_travel_cep.data.vos.TourVO

interface ToursModel {

    fun getAllTours(
        onSuccess: (TourVO) -> Unit,
        onFailure: (String) -> Unit
    )
}