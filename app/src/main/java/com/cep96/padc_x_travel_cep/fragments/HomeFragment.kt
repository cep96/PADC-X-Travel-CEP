package com.cep96.padc_x_travel_cep.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.cep96.padc_x_travel_cep.R
import com.cep96.padc_x_travel_cep.adapters.CountryListAdapter
import com.cep96.padc_x_travel_cep.adapters.PopularTourListAdapter
import com.cep96.padc_x_travel_cep.data.models.ToursModel
import com.cep96.padc_x_travel_cep.data.models.ToursModelImpl
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private val toursModel: ToursModel = ToursModelImpl
    private lateinit var mCountryAdapter: CountryListAdapter
    private lateinit var mPopularToursAdapter: PopularTourListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // for country list
        mCountryAdapter = CountryListAdapter()

        rcCountry.adapter = mCountryAdapter
        rcCountry.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // for popular tours list
        mPopularToursAdapter = PopularTourListAdapter()

        rcPopularTours.adapter = mPopularToursAdapter
        rcPopularTours.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        requestData()

    }

    private fun requestData() {
        swipeRefreshLayout.isRefreshing = true
        toursModel.getAllTours(
            onSuccess = {

//                Toast.makeText(context, "$it", Toast.LENGTH_LONG).show()
                it.country.let {
                    mCountryAdapter.setData(it)
                }

                it.popularTours.let {
                    mPopularToursAdapter.setData(it)
                }

                swipeRefreshLayout.isRefreshing = false

            },
            onFailure = {
                Log.e("Error Message", "==> $it")
//                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
                swipeRefreshLayout.isRefreshing = false
            })
    }

    companion object{
        fun newInstance(): HomeFragment{
            return HomeFragment()
        }
    }
}
