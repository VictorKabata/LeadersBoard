package com.vickikbt.leadersboard.ui.viewmodels

import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vickikbt.leadersboard.repository.SubmissionRepository
import com.vickikbt.leadersboard.util.ApiException
import com.vickikbt.leadersboard.util.Coroutines
import com.vickikbt.leadersboard.util.NoInternetException
import com.vickikbt.leadersboard.util.StateListener

class SubmissionViewModel @ViewModelInject constructor(private val submissionRepository: SubmissionRepository) :
    ViewModel(), Observable {

    @Bindable
    val emailAddress = MutableLiveData<String>()

    @Bindable
    val firstName = MutableLiveData<String>()

    @Bindable
    val lastName = MutableLiveData<String>()

    @Bindable
    val projectLink = MutableLiveData<String>()

    val statListener: StateListener? = null

    fun onSubmitButtonClicked(view: View) {
        statListener?.onLoading()
        when {
            emailAddress.value.isNullOrEmpty() -> {
                statListener?.onFailure("Enter Email Address")
                return
            }
            firstName.value.isNullOrEmpty() -> {
                statListener?.onFailure("Enter First Name")
                return
            }
            lastName.value.isNullOrEmpty() -> {
                statListener?.onFailure("Enter Last Name")
                return
            }
            projectLink.value.isNullOrEmpty() -> {
                statListener?.onFailure("Enter Project Link")
                return
            }
        }

        Coroutines.main {
            try {
                val submissionResponse = submissionRepository.submitProject(
                    emailAddress.value!!,
                    firstName.value!!, lastName.value!!, projectLink.value!!
                )

                submissionResponse.let {
                    statListener?.onSuccess("Project Submitted")
                    return@main
                }
                statListener?.onFailure("Failed to submit")
            } catch (e: ApiException) {
                statListener?.onFailure(e.message.toString())
            } catch (e: NoInternetException) {
                statListener?.onFailure(e.message.toString())
            }
        }

    }


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
}