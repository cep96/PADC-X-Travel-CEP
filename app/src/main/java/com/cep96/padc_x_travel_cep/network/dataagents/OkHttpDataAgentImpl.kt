package com.cep96.padc_x_travel_cep.network.dataagents

import android.os.AsyncTask
import com.cep96.padc_x_travel_cep.data.vos.TourVO
import com.cep96.padc_x_travel_cep.network.responses.GetAllToursResponse
import com.cep96.padc_x_travel_cep.utils.BASE_URL
import com.cep96.padc_x_travel_cep.utils.EM_NO_INTERNET_CONNECTION
import com.cep96.padc_x_travel_cep.utils.GET_ALL_TOURS
import com.cep96.padc_x_travel_cep.utils.NEW_BASE_URL
import com.google.gson.Gson
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.util.concurrent.TimeUnit

object OkHttpDataAgentImpl: ToursDataAgent {
    override fun getAllTours(onSuccess: (TourVO) -> Unit, onFailure: (String) -> Unit) {
        GetNewsTask(mClient, onSuccess, onFailure).execute()
    }

    private val mClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    class GetNewsTask(
        private val mOkHttpClient: OkHttpClient,
        private val onSuccess: (TourVO) -> Unit,
        private val onFailure: (String) -> Unit
    ): AsyncTask<Void,Void, GetAllToursResponse>(){
        override fun doInBackground(vararg params: Void?): GetAllToursResponse? {

            val request = Request.Builder()
                .url(NEW_BASE_URL + GET_ALL_TOURS)
                .get()
                .build()

            try {
                val response = mOkHttpClient
                    .newCall(request)
                    .execute()

                if (response.isSuccessful){
                    response.body?.let {
                        val responseString = it.string()
                        return Gson().fromJson<GetAllToursResponse>(responseString, GetAllToursResponse::class.java)
                    }
                }
            }catch (e: Exception){}

            return null
        }

        override fun onPostExecute(result: GetAllToursResponse?) {
            super.onPostExecute(result)

            if (result != null){
                if (result.isResponseOK()){
                    result.data?.let {
                        onSuccess(it)
                    }
                }else{
                    onFailure(result.message)
                }
            }else{
                onFailure(EM_NO_INTERNET_CONNECTION)
            }

        }

    }

}