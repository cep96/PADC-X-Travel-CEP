package com.cep96.padc_x_travel_cep.data.models

import com.cep96.padc_x_travel_cep.network.dataagents.HttpUrlConnectionDataAgentImpl
import com.cep96.padc_x_travel_cep.network.dataagents.OkHttpDataAgentImpl
import com.cep96.padc_x_travel_cep.network.dataagents.RetrofitDataAgentImpl
import com.cep96.padc_x_travel_cep.network.dataagents.ToursDataAgent

abstract class BaseModel {

    val mDataAgent: ToursDataAgent = RetrofitDataAgentImpl

}