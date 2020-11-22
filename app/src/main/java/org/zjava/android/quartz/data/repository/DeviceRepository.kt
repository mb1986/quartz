package org.zjava.android.quartz.data.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import org.zjava.android.quartz.data.local.DeviceDao
import org.zjava.android.quartz.data.model.Device

class DeviceRepository(private val deviceDao: DeviceDao) {

    val allDevices: Flow<List<Device>> = deviceDao.loadAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(device: Device) {
        deviceDao.insert(device)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(device: Device) {
        deviceDao.update(device)
    }
}