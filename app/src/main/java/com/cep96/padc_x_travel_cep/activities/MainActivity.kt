package com.cep96.padc_x_travel_cep.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.cep96.padc_x_travel_cep.R
import com.cep96.padc_x_travel_cep.adapters.BottomNavigationViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val mAdapter = BottomNavigationViewPagerAdapter(this)
        viewPager2.adapter = mAdapter

        viewPager2.isUserInputEnabled = false

        bottomNavigationView
            .setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
                override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                    when(menuItem.itemId){
                        R.id.navHome -> {
                            viewPager2.currentItem = 0
                            return true
                        }
                        R.id.navRating -> {
                            viewPager2.currentItem = 1
                            return true
                        }
                        R.id.navFavorite -> {
                            viewPager2.currentItem = 2
                            return true
                        }
                        R.id.navPrice -> {
                            viewPager2.currentItem = 3
                            return true
                        }
                        R.id.navSearch -> {
                            viewPager2.currentItem = 4
                            return true
                        }
                    }
                    return false
                }

            })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
