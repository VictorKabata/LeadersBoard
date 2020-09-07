package com.vickikbt.leadersboard.repository

import com.vickikbt.leadersboard.data.network.ApiSubmissionService
import com.vickikbt.leadersboard.data.network.SafeApiRequest
import javax.inject.Inject

class SubmissionRepository @Inject constructor(private val apiSubmissionService: ApiSubmissionService) :
    SafeApiRequest() {

    suspend fun submitProject(
        emailAddress: String,
        firstName: String,
        lastName: String,
        projectLink: String
    ): Any {
        return safeApiRequest {
            apiSubmissionService.submitProject(
                emailAddress,
                firstName,
                lastName,
                projectLink
            )
        }
    }

}