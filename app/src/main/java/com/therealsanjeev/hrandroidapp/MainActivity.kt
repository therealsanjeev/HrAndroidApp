package com.therealsanjeev.hrandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import  com.therealsanjeev.hrandroidapp.DialogBox.DialogBox
import com.therealsanjeev.hrandroidapp.adapter.recyclerAdapter
import com.therealsanjeev.hrandroidapp.data.StaffData
import com.therealsanjeev.hrandroidapp.data.StaffDataBase
import com.therealsanjeev.hrandroidapp.data.StaffDataBase.Companion.getDatabase
import com.therealsanjeev.hrandroidapp.repo.Repository
import com.therealsanjeev.hrandroidapp.view.ViewModel

import kotlinx.android.synthetic.main.activity_main.*

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
        create_staff_btn.setOnClickListener {
            val createUserDialog = DialogBox()
            createUserDialog.show(supportFragmentManager, "tag")
        }


    }

    override fun applyTexts(name: String?, position: String?, salary: String?, type: String?) {
        val staff=StaffData(name.toString(),position.toString(),salary.toString(),type.toString())
        Toast.makeText(this, "$staff", Toast.LENGTH_SHORT).show()
        viewModel.insertData(staff)

    }
    //Setting up the RecyclerView :
    private fun setRecyclerView() {
        recyclerView = user_list_rv
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerAdapter
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true
    }
}