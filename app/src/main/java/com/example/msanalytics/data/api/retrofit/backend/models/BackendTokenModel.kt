package com.example.msanalytics.data.api.retrofit.backend.models

import com.google.gson.annotations.SerializedName

data class BackendTokenModel (
    @SerializedName("token") var token: String? = null,
    @SerializedName("expires_in") var expiresIn: Int?    = null,
    @SerializedName("refresh_expires_in") var refreshExpiresIn: Int?    = null,
    @SerializedName("refresh_token") var refreshToken: String? = null,
    @SerializedName("token_type") var tokenType: String? = null,
    @SerializedName("not-before-policy") var notBeforePolicy : Int? = null,
    @SerializedName("session_state") var sessionState: String? = null,
    @SerializedName("scope") var scope: String? = null
)