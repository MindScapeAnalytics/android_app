package com.example.msanalytics.data.local.token

import com.example.msanalytics.data.local.token.dao.TokenDao
import com.example.msanalytics.data.local.token.dao.TokenEntity

class RoomTokenLocalDataSource(
    private val tokenDao: TokenDao
): TokenLocalDataSource {
    override suspend fun getToken(): TokenEntity? {
        return tokenDao.getToken()
    }

    override suspend fun saveToken(tokenEntity: TokenEntity) {
        return tokenDao.saveToken(tokenEntity)
    }

    override suspend fun deleteToken(tokenEntity: TokenEntity) {
        return tokenDao.deleteToken(tokenEntity)
    }

    override suspend fun updateToken(tokenEntity: TokenEntity) {
        return tokenDao.updateToken(tokenEntity)
    }
}