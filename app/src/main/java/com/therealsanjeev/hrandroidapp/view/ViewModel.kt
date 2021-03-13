package com.therealsanjeev.hrandroidapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.therealsanjeev.hrandroidapp.data.StaffData
import com.therealsanjeev.hrandroidapp.repo.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel (private val repository: Repository): ViewModel() {

    //roomDatabase
    fun insertData(staff: StaffData){
        viewModelScope.launch{
            repository.insertData(staff)
        }
    }


    fun deleteData(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteData()
        }
    }

    fun getSavedData() = repository.getAllData
}