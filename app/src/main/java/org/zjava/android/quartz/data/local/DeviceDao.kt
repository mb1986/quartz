package org.zjava.android.quartz.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.zjava.android.quartz.data.model.Device

@Dao
interface DeviceDao {

    @Query("SELECT * FROM devices ORDER BY name ASC")
    fun loadAll(): Flow<List<Device>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(device: Device)

    @Update
    suspend fun update(device: Device)

    @Query("DELETE FROM devices")
    suspend fun deleteAll()
}
