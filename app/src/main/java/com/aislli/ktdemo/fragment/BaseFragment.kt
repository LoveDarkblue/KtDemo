package com.aislli.ktdemo.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Aislli on 2017/12/26 0026.
 */

abstract class BaseFragment : Fragment() {
    protected var mRootView: View? = null
    protected var TAG: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (null == mRootView) {
            mRootView = inflater.inflate(layoutId, container, false)
            TAG = this.javaClass.simpleName
        } else {
            val parent = mRootView!!.parent as ViewGroup
            parent?.removeView(mRootView)
        }
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
    }

    protected abstract fun initView()

    protected abstract fun initData()

    protected abstract val layoutId: Int

    override fun onDetach() {
        super.onDetach()
        try {
            val childFragmentManager = Fragment::class.java.getDeclaredField("mChildFragmentManager")
            childFragmentManager.isAccessible = true
            childFragmentManager.set(this, null)

        } catch (e: NoSuchFieldException) {
            throw RuntimeException(e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException(e)
        }

    }

    protected fun <E : View> getView(id: Int): E {
        try {
            return mRootView!!.findViewById<E>(id)
        } catch (ex: ClassCastException) {
            throw ex
        }

    }
}
