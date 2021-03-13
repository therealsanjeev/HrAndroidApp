package com.therealsanjeev.hrandroidapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StaffDao {

    @Query("SELECT * FROM staff_table")
    fun getAllData(): LiveData<List<StaffData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(StaffData: StaffData)

    @Query("DELETE FROM staff_table")
    suspend fun deleteAll()
}