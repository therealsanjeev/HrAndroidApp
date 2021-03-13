package com.therealsanjeev.hrandroidapp.repo

import androidx.lifecycle.LiveData
import com.therealsanjeev.hrandroidapp.data.StaffDao
import com.therealsanjeev.hrandroidapp.data.StaffData

class Repository(private val staffDao: StaffDao) {

    //roomDatabase
    val getAllData: LiveData<List<StaffData>> = staffDao.getAllData()

    suspend fun insertData(urlData: StaffData){
        staffDao.insertData(urlData)
    }

    suspend fun deleteData(){
        staffDao.deleteAll()
    }
}