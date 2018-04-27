package com.aislli.ktdemo.fragment

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.aislli.ktdemo.R
import com.aislli.ktdemo.util.toast

/**
 * Created by Aislli on 2018/4/26 0026.
 */

class NullFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.frag_null
    private var am_btn: Button? = null
    private var am_tv: TextView? = null

    override fun initView() {
        am_btn = getView(R.id.am_btn)
        am_tv = getView(R.id.am_tv)

        setListener()
    }

    private fun setListener() {
        val a: Int? = null
        val myString = a?.toString() ?: "123"

        am_btn?.setOnClickListener {
            am_tv?.text = "ssssss"
            activity.toast(myString)
        }
    }

    override fun initData() {
    }

    companion object {
        fun newInstance(): NullFragment {
            val args = Bundle()

            val fragment = NullFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
