package org.zjava.android.quartz.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "devices")
data class Device(
    @PrimaryKey
    @ColumnInfo(name = "mac")
    val macAddress: Long,

    @ColumnInfo(name = "name")
    val name: String
)