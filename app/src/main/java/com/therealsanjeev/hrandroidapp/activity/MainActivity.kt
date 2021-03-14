package com.therealsanjeev.hrandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import  com.therealsanjeev.hrandroidapp.DialogBox.DialogBox
import com.therealsanjeev.hrandroidapp.adapter.recyclerAdapter
import com.therealsanjeev.hrandroidapp.data.StaffData
import com.therealsanjeev.hrandroidapp.data.StaffDataBase
import com.therealsanjeev.hrandroidapp.data.StaffDataBase.Companion.getDatabase
import com.therealsanjeev.hrandroidapp.repo.Repository
import com.therealsanjeev.hrandroidapp.view.ViewModel
import com.therealsanjeev.hrandroidapp.view.ViewModelFactory


class MainActivity : AppCompatActivity(), DialogBox.ExampleDialogListener {

    private lateinit var viewModel: ViewModel

    private lateinit var recyclerView: RecyclerView

    private val recyclerAdapter: recyclerAdapter by lazy { recyclerAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val staffDao=StaffDataBase.getDatabase(this).staffDuo()
        val repository = Repository(staffDao)

        setRecyclerView()
        findViewById<Button>(R.id.create_staff_btn).setOnClickListener {
            val createUserDialog = DialogBox()
            createUserDialog.show(supportFragmentManager, "tag")
        }
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModel::class.java)

        viewModel.getSavedData()

        viewModel.getSavedData().observe(this,{
//            recyclerAdapter
        })


    }

    override fun applyTexts(name: String?, position: String?, salary: String?, type: String?) {
        val staff=StaffData(name.toString(),position.toString(),salary.toString(),type.toString())
        Toast.makeText(this, "$staff", Toast.LENGTH_SHORT).show()
        viewModel.insertData(staff)
        recyclerAdapter.notifyDataSetChanged()

    }
    //Setting up the RecyclerView :
    private fun setRecyclerView() {
        recyclerView = findViewById(R.id.user_list_rv)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerAdapter
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true
    }
}