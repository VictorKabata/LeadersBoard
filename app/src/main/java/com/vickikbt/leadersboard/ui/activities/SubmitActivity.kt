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

        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    override fun onLoading() {
        progressBar_submit?.show()
    }

    override fun onSuccess(message: String) {
        progressBar_submit?.hide()
        log(message)
        //TODO: Add onSuccess Custom Dialog
    }

    override fun onFailure(message: String) {
        progressBar_submit?.show()
        log(message)
        toast(message)
        //TODO: Add onFailure Custom Dialog
    }
}