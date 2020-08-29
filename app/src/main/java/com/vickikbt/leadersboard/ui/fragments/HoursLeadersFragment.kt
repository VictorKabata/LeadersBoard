package com.vickikbt.leadersboard.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.ui.viewmodels.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_hours_leaders.*

@AndroidEntryPoint
class HoursLeadersFragment : Fragment() {

    private val viewModel by viewModels<AppViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_hours_leaders, container, false)

        viewModel.fetchHoursLeaders().observe(viewLifecycleOwner, Observer {
            network_tester.text = it.toString()
        })


        return root
    }

}