package com.vickikbt.leadersboard.ui.viewmodels

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
import java.net.UnknownHostException

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

    var statListener: StateListener? = null

    fun onSubmitButtonClicked() {
        statListener?.onLoading()

        when {
            firstName.value.isNullOrEmpty() -> {
                statListener?.onFailure("Enter first name")
                return
            }
            lastName.value.isNullOrEmpty() -> {
                statListener?.onFailure("Enter last name")
                return
            }
            emailAddress.value.isNullOrEmpty() -> {
                statListener?.onFailure("Enter email address")
                return
            }
            projectLink.value.isNullOrEmpty() -> {
                statListener?.onFailure("Enter project link")
                return
            }

            else -> Coroutines.main {
                try {
                    val submissionResponse = submissionRepository.submitProject(
                        emailAddress.value!!,
                        firstName.value!!, lastName.value!!, projectLink.value!!
                    )

                    submissionResponse.let {
                        statListener?.onSuccess("Project Submitted")
                        return@let
                    }
                    statListener?.onFailure("Failed to submit")
                } catch (e: ApiException) {
                    statListener?.onFailure(e.message.toString())
                } catch (e: UnknownHostException) {
                    statListener?.onFailure("Ensure you are connected to the internet")
                }
            }
        }

    }


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
}