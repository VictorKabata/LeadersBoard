package com.vickikbt.leadersboard.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.model.SkillLeadersModel
import com.vickikbt.leadersboard.ui.adapters.SkillLeadersRecyclerViewAdapter
import com.vickikbt.leadersboard.ui.viewmodels.MainViewModel
import com.vickikbt.leadersboard.util.Coroutines
import com.vickikbt.leadersboard.util.hide
import com.vickikbt.leadersboard.util.log
import com.vickikbt.leadersboard.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_skill_leaders.*

@AndroidEntryPoint
class SkillLeadersFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_skill_leaders, container, false)

        initRecyclerView()

        return root
    }

    private fun initRecyclerView() {
        skills_progressBar?.show()
        
        val skillLeadersList = arrayListOf<SkillLeadersModel>()
        val adapter = SkillLeadersRecyclerViewAdapter(requireActivity(), skillLeadersList)

        Coroutines.main {
            viewModel.skillLeaders.await().observe(viewLifecycleOwner, Observer {
                for (i in it.indices) {
                    skillLeadersList.add(it[i])
                    skill_recyclerview.adapter = adapter
                    skills_progressBar?.hide()
                }
                requireActivity().applicationContext.log(skillLeadersList.size.toString())
            })
        }
    }

}