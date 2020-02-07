package com.cep96.padc_x_travel_cep.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cep96.padc_x_travel_cep.fragments.HomeFragment

class BottomNavigationViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment.newInstance()
            1 -> return HomeFragment.newInstance()
            2 -> return HomeFragment.newInstance()
            3 -> return HomeFragment.newInstance()
            4 -> return HomeFragment.newInstance()
            else -> return HomeFragment.newInstance()
        }
    }
}