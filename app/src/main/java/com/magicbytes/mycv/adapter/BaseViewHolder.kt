package com.magicbytes.mycv.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.magicbytes.mycv.ListItem

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun show(item: ListItem)
}