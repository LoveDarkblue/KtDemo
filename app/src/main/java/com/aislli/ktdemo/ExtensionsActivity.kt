package com.aislli.ktdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_extensions.*

class ExtensionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extensions)
        ae_tv.text = "123"

        initView()
    }

    fun initView(){
        val list = ArrayList<String>()
        for (x in 1..10) {
            list.add("number $x")
        }

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = ListAdapter(this,list)
    }
}
