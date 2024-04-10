package com.example.candlerushadmin.clickInterface

import android.widget.ImageView

interface ClickInterface {
    fun onClick(position: Int, clickType: ClickType ?= ClickType.Delete) :Boolean
    fun view(position: Int,imageView: ImageView)
}

enum class ClickType{
   Delete,img,OnViewClick,AddSub
}