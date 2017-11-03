package com.ronnnnn.giphy_architecture_component.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ronnnnn.giphy_architecture_component.R

/**
 * Created by kokushiseiya on 2017/11/03.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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