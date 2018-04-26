package com.aislli.ktdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private var am_btn: Button? = null
    private var am_tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initData()
    }

    private fun initData() {
        val list = ArrayList<Int>()
        for (x in 1..10) {
            print(x)
            list.add(x)
        }
        list.filter { it % 2 == 0 }
                .map { it + 1 }
                .forEach { println(it) }

    }

    private fun initView() {
        am_btn = findViewById(R.id.am_btn) as Button
        am_tv = findViewById(R.id.am_tv) as TextView

        setListener()
    }

    private fun setListener() {
        val a: Int? = null
        val myString = a?.toString() ?: "123"

        am_btn!!.setOnClickListener {
            am_tv!!.text = "ssssss"
            toast(myString)
        }
    }
}
