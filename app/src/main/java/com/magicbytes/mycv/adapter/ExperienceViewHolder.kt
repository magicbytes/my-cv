package com.magicbytes.mycv.adapter

import android.view.View
import android.widget.TextView
import com.magicbytes.mycv.ListItem
import com.magicbytes.mycv.R
import com.magicbytes.mycv.dataModels.Experience
import kotlinx.android.synthetic.main.list_item_experience.view.*

class ExperienceViewHolder(itemView: View) : BaseViewHolder(itemView) {

    private val name: TextView = itemView.findViewById(R.id.name)
    private val term: TextView = itemView.findViewById(R.id.termTextView)

    override fun show(item: ListItem) {
        val data = item.data as? Experience ?: return

        name.text = data.companyName
        term.text =  "${data.startTime} - ${data.endTime}"
    }
}