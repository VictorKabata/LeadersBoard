package com.vickikbt.leadersboard.util

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.log(message: String) {
    Log.e("VickiKbt", message)
}

fun ProgressBar.show(){
    visibility= View.VISIBLE
}

fun ProgressBar.hide(){
    visibility= View.GONE
}