package com.magicbytes.mycv.dataModels

class Cv(
    val name: String,
    val profileImageName: String,
    val professionalSummary: String,
    val skills: String,
    val experience: List<Experience>,
    val education: List<Education>
) {
}

data class Experience(val companyName: String, val startTime: String, val endTime: String)

data class Education(val institution: String, val studyTerm: String, val topic: String)