package com.magicbytes.mycv

import com.google.firebase.storage.FirebaseStorage
import com.google.gson.Gson
import com.magicbytes.mycv.dataModels.Cv


interface Model {
    var eventsListener: Events?

    fun loadInfo()

    interface Events {
        fun onCvAvailable(cv: Cv)

        fun onErrorOccurred()
    }
}

class CvNetworkModel : Model {
    override var eventsListener: Model.Events? = null

    override fun loadInfo() {
        val storage = FirebaseStorage.getInstance().reference
        val cvJson = storage.child("cv.json")
        val oneMegabyte: Long = 1024 * 1024
        cvJson.getBytes(oneMegabyte)
            .addOnSuccessListener { dataArray ->
                val json = String(dataArray)
                val cv = Gson().fromJson(json, Cv::class.java)
                eventsListener?.onCvAvailable(cv)
            }
            .addOnFailureListener { exception ->
                eventsListener?.onErrorOccurred()
            }
    }
}