package org.zjava.android.quartz.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import org.zjava.android.quartz.data.model.Device
import org.zjava.android.quartz.data.repository.DeviceRepository

class DeviceListViewModel(private val deviceRepository: DeviceRepository) : ViewModel() {

    val allDevices: LiveData<List<Device>> = deviceRepository.allDevices.asLiveData()

    fun insert(device: Device) = viewModelScope.launch {
        deviceRepository.insert(device)
    }
}

class DeviceListViewModelFactory(private val deviceRepository: DeviceRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeviceListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DeviceListViewModel(deviceRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}