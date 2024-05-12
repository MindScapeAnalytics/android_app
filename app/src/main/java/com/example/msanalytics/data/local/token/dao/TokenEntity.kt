package com.example.msanalytics.data.local.token.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = TokenEntity.TABLE_NAME)
data class TokenEntity(
    @ColumnInfo(name = "token") var token: String?,
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = 1
) {
    companion object {
        const val TABLE_NAME = "token_table"
    }
}

