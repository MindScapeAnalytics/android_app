package com.example.msanalytics.data.local.token

import com.example.msanalytics.data.local.token.dao.TokenEntity

interface TokenLocalDataSource {
    suspend fun getToken(): TokenEntity?
    suspend fun saveToken(tokenEntity: TokenEntity)
    suspend fun deleteToken(tokenEntity: TokenEntity)
    suspend fun updateToken(tokenEntity: TokenEntity)
}