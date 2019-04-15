package com.magicbytes.mycv

class ListItem(val type: Type, val data: Any) {

    enum class Type {
        Name,
        Image,
        Summary,
        Skills,
        ExperienceHeader,
        Experience,
        EducationHeader,
        Education
    }
}