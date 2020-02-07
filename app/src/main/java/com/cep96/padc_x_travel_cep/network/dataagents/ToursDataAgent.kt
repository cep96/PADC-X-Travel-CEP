package com.cep96.padc_x_travel_cep.network.dataagents

import com.cep96.padc_x_travel_cep.data.vos.TourVO

interface ToursDataAgent {

    fun getAllTours(
        onSuccess: (TourVO) -> Unit,
        onFailure: (String) -> Unit
    )
}