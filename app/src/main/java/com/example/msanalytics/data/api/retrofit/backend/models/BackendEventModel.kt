package com.example.msanalytics.data.api.retrofit.backend.models

import com.google.gson.annotations.SerializedName

data class BackendEventModel(
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("data") var data: String? = null
)
