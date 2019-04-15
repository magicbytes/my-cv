package com.magicbytes.mycv.adapter

import android.view.View
import android.widget.TextView
import com.magicbytes.mycv.ListItem
import com.magicbytes.mycv.R

class SkillsViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val textView: TextView = itemView.findViewById(R.id.textViewData)

    override fun show(item: ListItem) {
        val data = item.data as? String ?: return
        textView.text = data
    }
}