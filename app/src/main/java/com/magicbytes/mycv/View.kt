package com.magicbytes.mycv

interface View {
    var isProgressVisible: Boolean
    var isErrorVisible: Boolean

    fun showCv(listItems: List<ListItem>)
}