package com.example.msanalytics.data.api.repository

import com.example.msanalytics.data.api.retrofit.backend.BackendExternalDataSource
import com.example.msanalytics.data.api.retrofit.backend.BackendRetrofitDataSource
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import retrofit2.Response

class AccountRepository constructor(
    private val backendExternalDataSource: BackendExternalDataSource
) {
    suspend fun createAccount(accountModel: BackendAccountModel): Response<String> {
        return backendExternalDataSource.createAccount(accountModel)
    }

    suspend fun getToken(accountModel: BackendAccountModel): Response<String> {
        return backendExternalDataSource.getToken(accountModel)
    }
}