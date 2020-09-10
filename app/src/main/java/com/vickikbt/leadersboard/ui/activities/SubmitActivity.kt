package com.vickikbt.leadersboard.ui.activities

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.databinding.ActivitySubmitBinding
import com.vickikbt.leadersboard.ui.viewmodels.SubmissionViewModel
import com.vickikbt.leadersboard.util.StateListener
import com.vickikbt.leadersboard.util.hide
import com.vickikbt.leadersboard.util.log
import com.vickikbt.leadersboard.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_submit.*

@AndroidEntryPoint
class SubmitActivity : AppCompatActivity(), StateListener {

    private val viewModel by viewModels<SubmissionViewModel>()
    private lateinit var binding: ActivitySubmitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit)
        binding.viewModel = viewModel

        viewModel.statListener = this

        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        submit_button.setOnClickListener {
            showDialog()
        }

    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.confirmation_dialog)


        val confirmationButton = dialog.findViewById<Button>(R.id.button_confirmation)
        confirmationButton.setOnClickListener {
            viewModel.onSubmitButtonClicked()
            //showStatusDialog(R.drawable.ic_success, "Submission Successful")
        }

        val closeDialog: ImageView = dialog.findViewById(R.id.imageView_status)
        closeDialog.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }

    private fun showStatusDialog(image: Int, message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.status_dialog)

        val imageStatus = dialog.findViewById<ImageView>(R.id.imageView_status)
        imageStatus.setImageResource(image)

        val textStatus = dialog.findViewById<TextView>(R.id.textView_message)
        textStatus.text = message

        dialog.show()
    }

    override fun onLoading() {
        progressBar_submit?.show()
    }

    override fun onSuccess(message: String) {
        progressBar_submit?.hide()
        log(message)

        showStatusDialog(R.drawable.ic_success, "Submission Successful")
    }

    override fun onFailure(message: String) {
        progressBar_submit?.hide()
        log(message)

        showStatusDialog(R.drawable.ic_error, "Submission not Successful")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}