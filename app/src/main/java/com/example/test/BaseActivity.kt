package com.example.test

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.method.ScrollingMovementMethod
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_base.*

enum class LOGTYPE{
    ERROR,GENERAL
}

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun setCustomView(crView: Int) {
        val view = layoutInflater.inflate(crView, parent_view, false)
        parent_view.addView(view)
    }

    fun log(tag: String, value: String,type:LOGTYPE ?= LOGTYPE.GENERAL) {
        if (value.isNotEmpty()) {
            tv_logs.visibility = View.VISIBLE
            tv_logs.movementMethod = ScrollingMovementMethod()
        }

        val logText = tv_logs.text.toString().plus("\n $tag : $value")
        val startIndex = logText.lastIndexOf(value)
        val spannableString = SpannableString(logText)
        if (type == LOGTYPE.ERROR){
            val startIndex = logText.lastIndexOf(value)
            val spannableString = SpannableString(logText)
            spannableString.setSpan(ForegroundColorSpan(Color.RED), startIndex, startIndex + value.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        }

        tv_logs.setText(spannableString)

    }
}