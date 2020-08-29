package com.vickikbt.leadersboard.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.ui.viewmodels.AppViewModel
import com.vickikbt.leadersboard.util.StateListener
import com.vickikbt.leadersboard.util.hide
import com.vickikbt.leadersboard.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_hours_leaders.*

@AndroidEntryPoint
class HoursLeadersFragment : Fragment(), StateListener {

    private val viewModel by viewModels<AppViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_hours_leaders, container, false)

        viewModel.fetchSkillLeaders().observe(viewLifecycleOwner, Observer {
            network_tester_textView.text = it.toString()
            Log.e("VickiKbt", it.toString())
        })
        return root
    }

    override fun onLoading() {
        hours_progressBar.show()
    }

    override fun onSuccess(message: String) {
        hours_progressBar.hide()
    }

    override fun onFailure(message: String) {
        hours_progressBar.hide()
        Log.e("VickiKbt", message)
    }

}