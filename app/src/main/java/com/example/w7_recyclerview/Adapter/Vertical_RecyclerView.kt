package com.example.w7_recyclerview.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.w7_recyclerview.Apps
import com.example.w7_recyclerview.Departments
import com.example.w7_recyclerview.R

class Vertical_RecyclerView(private val departmentList: ArrayList<Departments>) : RecyclerView.Adapter<Vertical_RecyclerView.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return departmentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = departmentList[position]
        holder.titleDepartment.text = currentItem.titleDepartment
        val appAdapter = Horizontal_RecyclerView(currentItem.apps as ArrayList<Apps>)
        holder.childRecyclerView.adapter = appAdapter
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleDepartment: TextView = itemView.findViewById(R.id.title_department)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.child_recyclerView)


    }

}