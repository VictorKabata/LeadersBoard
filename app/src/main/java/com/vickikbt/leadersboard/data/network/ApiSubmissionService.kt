package com.vickikbt.leadersboard.data.network

import com.vickikbt.leadersboard.util.Constants
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiSubmissionService {

    @FormUrlEncoded
    @POST(Constants.SUBMISSION_ENDPOINT)
    suspend fun submitProject(
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") projectLink: String
    ):Response<Void>

}