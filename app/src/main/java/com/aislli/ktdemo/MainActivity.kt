package com.aislli.ktdemo

import android.app.FragmentTransaction
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aislli.ktdemo.fragment.MenuFragment
import com.aislli.ktdemo.fragment.NullFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val beginTransaction = fragmentManager.beginTransaction()
        beginTransaction.replace(R.id.content, MenuFragment.newInstance{
            val transaction = fragmentManager.beginTransaction()
            when (it) {
                0 -> transaction.replace(R.id.content, NullFragment.newInstance())
                1 -> startActivity(Intent(this,ExtensionsActivity::class.java))
            }
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            transaction.addToBackStack(null)
            transaction.commit()
        })
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        beginTransaction.addToBackStack(null)
        beginTransaction.commit()
    }

}
