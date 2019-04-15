package com.magicbytes.mycv.adapter

import android.view.View
import android.widget.ImageView
import com.google.firebase.storage.FirebaseStorage
import com.magicbytes.mycv.ListItem
import com.magicbytes.mycv.R
import com.squareup.picasso.Picasso

class ImageViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.imageView)


    override fun show(item: ListItem) {
        val imageName = item.data as? String ?: return

        val reference = FirebaseStorage.getInstance().getReference("$imageName.png")
        reference.downloadUrl.addOnSuccessListener { uri ->
            Picasso.get().load(uri).into(imageView)
        }
    }
}