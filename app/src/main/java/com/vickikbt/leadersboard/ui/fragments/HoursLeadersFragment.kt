package com.vickikbt.leadersboard.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.ui.viewmodels.HoursLeadersViewModel
import com.vickikbt.leadersboard.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_hours_leaders.*

@AndroidEntryPoint
class HoursLeadersFragment : Fragment(), StateListener {

    private val viewModel by viewModels<HoursLeadersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_hours_leaders, container, false)
        viewModel.stateListener = this

        viewModel.getHoursLeader().observe(viewLifecycleOwner, Observer {
            network_tester_textView.text = it.toString()
        })
        return root
    }

    override fun onLoading() {
        hours_progressBar.show()
    }

    override fun onSuccess(message: String) {
        hours_progressBar.hide()
        requireActivity().applicationContext.log(message)
    }

    override fun onFailure(message: String) {
        hours_progressBar.hide()
        requireActivity().applicationContext.toast(message)
    }

}