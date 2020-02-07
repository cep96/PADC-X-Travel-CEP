package com.cep96.padc_x_travel_cep.network.dataagents

import com.cep96.padc_x_travel_cep.data.vos.TourVO
import com.cep96.padc_x_travel_cep.network.ToursApi
import com.cep96.padc_x_travel_cep.network.responses.GetAllToursResponse
import com.cep96.padc_x_travel_cep.utils.BASE_URL
import com.cep96.padc_x_travel_cep.utils.EM_NO_INTERNET_CONNECTION
import com.cep96.padc_x_travel_cep.utils.NEW_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgentImpl: ToursDataAgent {
    override fun getAllTours(onSuccess: (TourVO) -> Unit, onFailure: (String) -> Unit) {
        val getAllNewsCall = mToursApi?.getAllTours()

        getAllNewsCall?.enqueue(object : Callback<GetAllToursResponse>{
            override fun onFailure(call: Call<GetAllToursResponse>, t: Throwable) {
                onFailure(t.message ?:EM_NO_INTERNET_CONNECTION)
            }

            override fun onResponse(
                call: Call<GetAllToursResponse>,
                response: Response<GetAllToursResponse>
            ) {
                val getAllToursResponse = response.body()

                if (getAllToursResponse != null){
                    if (getAllToursResponse.isResponseOK()){
                        getAllToursResponse.data?.let{
                            onSuccess(it)
                        }
                    }else{
                        onFailure(getAllToursResponse.message)
                    }
                }else{
                    onFailure(EM_NO_INTERNET_CONNECTION)
                }
            }

        })
    }

    private var mToursApi: ToursApi? = null

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(NEW_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        mToursApi = retrofit.create(ToursApi::class.java)
    }

}