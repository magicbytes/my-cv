package com.magicbytes.mycv.adapter

import android.view.View
import android.widget.TextView
import com.magicbytes.mycv.ListItem
import com.magicbytes.mycv.R
import kotlinx.android.synthetic.main.list_item_summary.view.*

class SummaryViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val textView: TextView = itemView.findViewById(R.id.textView)

    override fun show(item: ListItem) {
        val data = item.data as? String ?: return
        textView.text = data
    }
}