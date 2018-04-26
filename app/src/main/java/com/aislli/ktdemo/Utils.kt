package com.aislli.ktdemo

import android.content.Context
import android.widget.Toast

/**
 * Created by Aislli on 2018/4/9 0009.
 */
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}