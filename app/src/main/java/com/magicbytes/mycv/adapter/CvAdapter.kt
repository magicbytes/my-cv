package com.magicbytes.mycv.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.magicbytes.mycv.ListItem
import com.magicbytes.mycv.R

class CvAdapter(private val items: List<ListItem>) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        val itemType = ListItem.Type.values()[viewType]

        val inflater = LayoutInflater.from(viewGroup.context)
        return when (itemType) {
            ListItem.Type.Image -> {
                val view = inflater.inflate(R.layout.list_item_image, viewGroup, false)
                ImageViewHolder(view)
            }
            ListItem.Type.Name -> {
                val view = inflater.inflate(R.layout.list_item_name, viewGroup, false)
                NameViewHolder(view)
            }
            ListItem.Type.Summary -> {
                val view = inflater.inflate(R.layout.list_item_summary, viewGroup, false)
                SummaryViewHolder(view)
            }
            ListItem.Type.Skills -> {
                val view = inflater.inflate(R.layout.list_item_skills, viewGroup, false)
                SkillsViewHolder(view)
            }
            ListItem.Type.ExperienceHeader -> {
                val view = inflater.inflate(R.layout.list_item_experience_header, viewGroup, false)
                ExperienceHeaderViewHolder(view)
            }
            ListItem.Type.Experience -> {
                val view = inflater.inflate(R.layout.list_item_experience, viewGroup, false)
                ExperienceViewHolder(view)
            }
            ListItem.Type.EducationHeader -> TODO()
            ListItem.Type.Education -> TODO()
        }
    }

    override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
        viewHolder.show(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type.ordinal
    }
}