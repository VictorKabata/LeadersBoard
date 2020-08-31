package com.vickikbt.leadersboard.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.model.HoursLeaderModel
import com.vickikbt.leadersboard.ui.adapters.HoursLeadersRecyclerViewAdapter
import com.vickikbt.leadersboard.ui.viewmodels.MainViewModel
import com.vickikbt.leadersboard.util.Coroutines
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_hours_leaders.*

@AndroidEntryPoint
class HoursLeadersFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_hours_leaders, container, false)

        initRecyclerView()

        return root
    }

    private fun initRecyclerView() {
        val hoursLeadersList = arrayListOf<HoursLeaderModel>()
        val adapter = HoursLeadersRecyclerViewAdapter(requireActivity(), hoursLeadersList)

        Coroutines.main {
            viewModel.hoursLeaders.await().observe(viewLifecycleOwner, Observer {
                for (i in it.indices) {
                    hoursLeadersList.add(it[i])
                    hours_recyclerview.adapter = adapter
                }
            })
        }
    }

}