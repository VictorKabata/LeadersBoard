package com.vickikbt.leadersboard.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.ui.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)
    }
}