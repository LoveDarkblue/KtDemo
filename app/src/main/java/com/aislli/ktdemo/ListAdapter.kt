package com.aislli.ktdemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.aislli.ktdemo.base.ARecyclerBaseAdapter
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by Aislli on 2018/4/27 0027.
 */

class ListAdapter(mContext: Context, mList: ArrayList<String>) : ARecyclerBaseAdapter<ListAdapter.ViewHolder, String>(mContext, mList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val s = mList[position]
        holder.tv_title.text = s
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tv_title: TextView = itemView.il_textview
    }
}
