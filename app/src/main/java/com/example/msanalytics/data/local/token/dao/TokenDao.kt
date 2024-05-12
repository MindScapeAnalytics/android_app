package com.example.msanalytics.data.local.token.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TokenDao {
    @Query("SELECT * FROM ${TokenEntity.TABLE_NAME} WHERE id=1")
    suspend fun getToken(): TokenEntity?

    @Insert(entity = TokenEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveToken(tokenEntity: TokenEntity)

    @Delete(entity = TokenEntity::class)
    suspend fun deleteToken(tokenEntity: TokenEntity)

    @Update(entity = TokenEntity::class)
    suspend fun updateToken(tokenEntity: TokenEntity)
}