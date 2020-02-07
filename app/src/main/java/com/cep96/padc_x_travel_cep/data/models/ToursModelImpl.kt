package com.cep96.padc_x_travel_cep.data.models

import com.cep96.padc_x_travel_cep.data.vos.TourVO

object ToursModelImpl: ToursModel, BaseModel() {
    override fun getAllTours(onSuccess: (TourVO) -> Unit, onFailure: (String) -> Unit) {
        mDataAgent.getAllTours(onSuccess = {
            onSuccess.invoke(it)
        }, onFailure = {
            onFailure.invoke(it)
        })
    }

}