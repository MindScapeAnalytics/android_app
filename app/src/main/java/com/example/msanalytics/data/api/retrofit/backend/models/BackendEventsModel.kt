package com.example.msanalytics.data.api.retrofit.backend.models

import com.google.gson.annotations.SerializedName

data class BackendEventsModel(
    @SerializedName("Id") var id: String? = null,
    @SerializedName("Name") var name: String? = null,
    @SerializedName("Description") var description: String? = null,
    @SerializedName("Data") var data: String? = null,
    @SerializedName("UserId") var userId: String? = null
)
