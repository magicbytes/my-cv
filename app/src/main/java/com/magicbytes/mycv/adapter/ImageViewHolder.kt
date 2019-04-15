package com.magicbytes.mycv.adapter

import android.view.View
import android.widget.ImageView
import com.magicbytes.mycv.ListItem
import com.magicbytes.mycv.R

class ImageViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.imageView)


    override fun show(item: ListItem) {
        val url = item.data as? String ?: return

    }
}