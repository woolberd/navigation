package com.example.navigation.`interface`

import com.example.navigation.model.HomeModel

interface OnClickItem {
    fun onClick(model: HomeModel)

    fun onLongClick(model: HomeModel): Boolean
}