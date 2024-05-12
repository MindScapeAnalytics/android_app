package com.example.msanalytics.data.api.retrofit.backend.models

import com.google.gson.annotations.SerializedName

data class BackendEventModel(
    @SerializedName("token") var token: String? = null,
    @SerializedName("expires_in") var expiresIn: Int?    = null,
    @SerializedName("refresh_expires_in") var refreshExpiresIn: Int?    = null,
)
