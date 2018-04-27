package com.aislli.ktdemo.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
/**
 * Created by Aislli on 2015/12/29.
 */
abstract class ARecyclerBaseAdapter<VH : RecyclerView.ViewHolder, T>(protected var mContext: Context, protected var mList: ArrayList<T>) : RecyclerView.Adapter<VH>() {
    protected var onItemClickListener: OnItemClickListener? = null
    protected var onItemLongClickListener: OnItemLongClickListener? = null
    protected var onFocusChangeListener: OnFocusChangeListener? = null

    fun getItem(position: Int): T? {
        if (position < mList.size)
            return mList[position]
        else
            return null
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(view: View, position: Int)
    }

    interface OnFocusChangeListener {
        fun onFocusChange(view: View, hasFocus: Boolean)
    }

    fun setItemLongClickListener(onItemLongClickListener: OnItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener
    }


    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun setFocusChangeListener(onFocusChangeListener: OnFocusChangeListener) {
        this.onFocusChangeListener = onFocusChangeListener
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun add(t: T) {
        insert(t, mList.size)
    }

    fun insert(t: T, position: Int) {
        mList.add(position, t)
        notifyItemInserted(position)
    }

    fun remove(position: Int) {
        mList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun clear() {
        val size = mList.size
        mList.clear()
        notifyItemRangeRemoved(0, size)
    }

    fun addAll(ts: List<T>) {
        val startIndex = mList.size
        mList.addAll(startIndex, ts)
        notifyItemRangeInserted(startIndex, ts.size)
    }

}
