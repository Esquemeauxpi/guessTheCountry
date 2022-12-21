package com.example.animalsboooooy.util

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import io.reactivex.internal.schedulers.SchedulerPoolFactory.start

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

