package com.vickikbt.leadersboard.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.ui.viewmodels.MainViewModel
import com.vickikbt.leadersboard.util.Coroutines
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

        Coroutines.main {
            viewModel.skillLeaders.await().observe(viewLifecycleOwner, Observer {
                blank_textView.text = it.toString()
            })
        }

        return root
    }

}