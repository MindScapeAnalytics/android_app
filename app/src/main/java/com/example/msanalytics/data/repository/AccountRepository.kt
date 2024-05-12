package com.example.msanalytics.data.repository

import com.example.msanalytics.data.api.retrofit.backend.BackendExternalDataSource
import com.example.msanalytics.data.api.retrofit.backend.BackendRetrofitDataSource
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendTokenModel
import com.example.msanalytics.data.local.token.TokenLocalDataSource
import com.example.msanalytics.data.local.token.dao.TokenEntity
import retrofit2.Response

class AccountRepository constructor(
    private val backendExternalDataSource: BackendExternalDataSource,
    private val tokenLocalDataSource: TokenLocalDataSource
) {
    suspend fun createAccount(accountModel: BackendAccountModel): Response<String> {
        val response = backendExternalDataSource.createAccount(accountModel)
        getToken(accountModel)
        return response
    }

    suspend fun getTokenFromLocal(): TokenEntity? {
        return tokenLocalDataSource.getToken()
    }

    suspend fun getToken(accountModel: BackendAccountModel): Response<BackendTokenModel> {
        val response = backendExternalDataSource.getToken(accountModel)
        val tokenEntity = TokenEntity(response.body()?.token)

        tokenLocalDataSource.saveToken(tokenEntity)

        return response
    }
}