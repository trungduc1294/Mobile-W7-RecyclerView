package com.example.w7_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.w7_recyclerview.Adapter.Horizontal_RecyclerView
import com.example.w7_recyclerview.Adapter.Vertical_RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var departmentRecyclerview: RecyclerView
    private lateinit var departmentList : ArrayList<Departments>

    private lateinit var appRecyclerView: RecyclerView
    private lateinit var appList: ArrayList<Apps>

    lateinit var departments : Array<String>
    lateinit var apps : Array<Int>
    lateinit var appName: Array<String>
    lateinit var appStar: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        departments = arrayOf(
            "Popular apps",
            "Flight booking",
            "Language",
            "Social"
        )

        apps = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f
        )
        appName = arrayOf(
            "Facebook",
            "Instargram",
            "Google",
            "Doulingo",
            "Mazzi",
            "Books"
        )

        appStar = arrayOf(
            "4.5*",
            "4.7*",
            "4.2*",
            "4.3*",
            "4.3*",
            "4.7*",
        )

        departmentRecyclerview = findViewById(R.id.department_recyclerView)
        departmentRecyclerview.layoutManager = LinearLayoutManager(this)
        departmentRecyclerview.setHasFixedSize(true)
        departmentList = arrayListOf<Departments>()

//        appRecyclerView = findViewById(R.id.department_recyclerView.)
//        appRecyclerView.layoutManager = LinearLayoutManager(this)
//        appRecyclerView.setHasFixedSize(true)
        appList = arrayListOf<Apps>()

        getUserData()
    }

    private fun getUserData(){
        for(i in apps.indices){
            val app = Apps(apps[i], appName[i], appStar[i])
            appList.add(app)
        }
        for(i in departments.indices){
            val department = Departments(departments[i], appList )
            departmentList.add(department)
        }

        departmentRecyclerview.adapter = Vertical_RecyclerView(departmentList)
//        appRecyclerView.adapter = Horizontal_RecyclerView(appList)

    }
}