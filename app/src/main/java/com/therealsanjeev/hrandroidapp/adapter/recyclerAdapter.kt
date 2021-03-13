package com.therealsanjeev.hrandroidapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.therealsanjeev.hrandroidapp.R
import com.therealsanjeev.hrandroidapp.data.StaffData
import kotlinx.android.synthetic.main.single_item.view.*

class recyclerAdapter(): RecyclerView.Adapter<recyclerAdapter.MyViewHolder>() {

    var dataList = emptyList<StaffData>()

    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name = view.name
        val position = view.position
        val salary=view.salary
        val type=view.type

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = dataList[position].name
        holder.position.text = dataList[position].position
        holder.salary.text=dataList[position].salary
        holder.type.text=dataList[position].type
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}