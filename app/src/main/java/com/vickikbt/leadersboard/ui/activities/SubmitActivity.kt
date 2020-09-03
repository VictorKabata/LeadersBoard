package com.vickikbt.leadersboard.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.databinding.ActivitySubmitBinding
import com.vickikbt.leadersboard.ui.viewmodels.SubmissionViewModel
import com.vickikbt.leadersboard.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_submit.*

@AndroidEntryPoint
class SubmitActivity : AppCompatActivity(), StateListener {

    private val viewModel by viewModels<SubmissionViewModel>()
    private lateinit var binding: ActivitySubmitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit)
        viewModel.statListener = this

        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        submit_button.setOnClickListener {
            viewModel.onSubmitButtonClicked()
        }

    }

    //TODO: Add custom dialog message for different messages
    override fun onLoading() {
        progressBar_submit?.show()
    }

    override fun onSuccess(message: String) {
        progressBar_submit?.hide()
        log(message)
    }

    override fun onFailure(message: String) {
        progressBar_submit?.hide()
        log(message)
        toast(message)
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
        super.onBackPressed()
    }
}