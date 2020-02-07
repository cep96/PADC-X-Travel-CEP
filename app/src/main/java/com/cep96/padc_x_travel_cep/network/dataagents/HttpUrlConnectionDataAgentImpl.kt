package com.cep96.padc_x_travel_cep.network.dataagents

import android.os.AsyncTask
import com.cep96.padc_x_travel_cep.data.vos.TourVO
import com.cep96.padc_x_travel_cep.network.responses.GetAllToursResponse
import com.cep96.padc_x_travel_cep.utils.BASE_URL
import com.cep96.padc_x_travel_cep.utils.EM_NO_INTERNET_CONNECTION
import com.cep96.padc_x_travel_cep.utils.GET_ALL_TOURS
import com.cep96.padc_x_travel_cep.utils.NEW_BASE_URL
import com.google.gson.Gson
import java.io.*
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

object HttpUrlConnectionDataAgentImpl: ToursDataAgent {
    override fun getAllTours(onSuccess: (TourVO) -> Unit, onFailure: (String) -> Unit) {
        GetTask(onSuccess, onFailure).execute()
    }

    class GetTask(
        private val onSuccess: (TourVO) -> Unit,
        private val onFailure: (String) -> Unit
    ): AsyncTask<Void, Void, GetAllToursResponse>(){

        // background thread
        override fun doInBackground(vararg params: Void?): GetAllToursResponse? {
            val url: URL
            var reader: BufferedReader? = null
            val stringBuilder: StringBuilder

            try {
                // create HttpUrlConnection
                url = URL(NEW_BASE_URL + GET_ALL_TOURS)

                val connection = url.openConnection() as HttpURLConnection

                // do a http post method
                connection.requestMethod = "GET"

                // give it 15 seconds to respond
                connection.readTimeout = 15 * 1000
//                connection.doInput = true
                connection.doOutput = true

                // write the parameters from NameValuePair list into connection obj.
                val outputStream = connection.outputStream
                val writer = BufferedWriter(
                    OutputStreamWriter(outputStream, "UTF-8")
                )
                writer.close()
                outputStream.close()


                connection.connect()

                //read the output from the server
                reader = BufferedReader(
                    InputStreamReader(connection.inputStream)
                )
                stringBuilder = StringBuilder()

                for (line in reader.readLines()){
                    stringBuilder.append(line + "\n")
                }

                val responseString = stringBuilder.toString()

                return Gson()
                    .fromJson(responseString, GetAllToursResponse::class.java)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                // close the reader; this can throw an exception too, so
                // wrap it in another try/catch block.
                if (reader != null){
                    try {
                        reader.close()
                    }catch (ioe: IOException){
                        ioe.printStackTrace()
                    }
                }
            }
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