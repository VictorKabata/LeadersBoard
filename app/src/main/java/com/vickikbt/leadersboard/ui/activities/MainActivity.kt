package com.vickikbt.leadersboard.ui.activities

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.ui.adapters.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = SectionsPagerAdapter(this, supportFragmentManager)

        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)
    }
}