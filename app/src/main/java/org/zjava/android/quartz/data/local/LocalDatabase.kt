package org.zjava.android.quartz.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.zjava.android.quartz.data.model.Device

@Database(entities = [Device::class], version = 1, exportSchema = false)
public abstract class LocalDatabase : RoomDatabase() {

    abstract fun deviceDao(): DeviceDao

    companion object {
        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getDatabase(context: Context): LocalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        "quartz_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}