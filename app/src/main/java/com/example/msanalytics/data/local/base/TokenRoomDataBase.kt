package com.example.msanalytics.data.local.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.msanalytics.data.local.token.dao.TokenDao
import com.example.msanalytics.data.local.token.dao.TokenEntity

@Database(entities = [
    TokenEntity::class
], version = 1, exportSchema = true)
abstract class TokenRoomDataBase: RoomDatabase() {
    abstract fun tokenDao(): TokenDao
}