package com.example.msanalytics.data.api.retrofit.backend

import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import okhttp3.Request
import retrofit2.Response
import java.util.Objects

class BackendRetrofitDataSource(
    private val apiService: BackendApiService,
    private val accountModel: BackendAccountModel
): BackendExternalDataSource {
    override suspend fun createAccount(): Response<String> {
        return apiService.createAccount(accountModel)
    }
}