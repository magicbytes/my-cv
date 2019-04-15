package com.magicbytes.mycv

import com.magicbytes.mycv.dataModels.Cv

class Presenter(private val view: View, private val model: Model) : Model.Events {

    init {
        model.eventsListener = this
    }

    fun showCv() {
        view.isProgressVisible = true
        view.isErrorVisible = false

        model.loadInfo()
    }

    override fun onCvAvailable(cv: Cv) {
        val result = ArrayList<ListItem>()
        result.add(ListItem(ListItem.Type.Image, cv.profileImageName))
        result.add(ListItem(ListItem.Type.Name, cv.name))
//        result.add(ListItem(ListItem.Type.Summary, cv.professionalSummary))
//        result.add(ListItem(ListItem.Type.Skills, cv.skills))
//        if (cv.experience.isNotEmpty()) {
//            result.add(ListItem(ListItem.Type.ExperienceHeader, ""))
//        }
//        cv.experience.forEach {
//            result.add(ListItem(ListItem.Type.Experience, it))
//        }
//        if (cv.education.isNotEmpty()) {
//            result.add(ListItem(ListItem.Type.EducationHeader, ""))
//        }
//        cv.education.forEach {
//            result.add(ListItem(ListItem.Type.Education, it))
//        }

        view.isProgressVisible = false
        view.showCv(result)
    }

    override fun onErrorOccurred() {
        view.isErrorVisible = true
        view.isProgressVisible = false
    }
}