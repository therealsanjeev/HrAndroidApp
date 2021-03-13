package com.therealsanjeev.hrandroidapp.data

import androidx.room.Entity

@Entity(tableName= "staff_table")
data class StaffData(
    var name: String,
    var position: String,
    var salary:String,
    var type:String
)
