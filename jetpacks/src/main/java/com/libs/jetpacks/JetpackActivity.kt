package com.libs.jetpacks

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class JetpackActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Activity, finshSelf: Boolean) {
            val intent = Intent(context, JetpackActivity::class.java)
             context.startActivity(intent)
            if (finshSelf) context.finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack)


    }
}