package com.therealsanjeev.hrandroidapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StaffData::class],version = 1,exportSchema = true)
abstract class StaffDataBase: RoomDatabase() {

    abstract fun staffDuo():StaffDao

    companion object{
        @Volatile
        private var INSTANCE: StaffDataBase? = null

        fun getDatabase(context: Context): StaffDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StaffDataBase::class.java, "staff_database"
            )
                .fallbackToDestructiveMigration()
                .build()
    }

}