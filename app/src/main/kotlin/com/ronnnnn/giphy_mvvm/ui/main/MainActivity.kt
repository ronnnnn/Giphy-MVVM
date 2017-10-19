package com.ronnnnn.giphy_mvvm.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ronnnnn.giphy_mvvm.R
import com.ronnnnn.giphy_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        savedInstanceState ?: kotlin.run {
            supportFragmentManager.beginTransaction()
                    .add(R.id.container_frame_layout, MainFragment.createInstance())
                    .addToBackStack(MainFragment::class.java.name)
                    .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount < 2) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}
