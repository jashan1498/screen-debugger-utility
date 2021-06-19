package com.example.test

import android.os.Bundle
import android.os.Handler
import android.os.Looper


class MainActivity : BaseActivity() {

    var runnable = {
        log("exception", "Kotlin Null Pointer Exception")
        showDummy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCustomView(R.layout.activity_main)

        showDummy()
        log("exception", " Error",LOGTYPE.ERROR)

    }

    // forever loop
    private fun showDummy(){
        Handler(Looper.getMainLooper()).postDelayed(runnable, 1000)
    }
}