package com.aislli.ktdemo.fragment

/**
 * Created by Aislli on 2018/4/26 0026.
 */
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aislli.ktdemo.R
import kotlinx.android.synthetic.main.frag_menu.*
class MenuFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn1 -> mListener(0)
            R.id.btn2 -> mListener(1)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
    }
    lateinit var mListener: (Int) -> Unit
    companion object {

        fun newInstance(listener: (Int) -> Unit): MenuFragment {

            val args = Bundle()
            val fragment = MenuFragment()
            fragment.mListener = listener
            fragment.arguments = args
            return fragment
        }
    }
}
