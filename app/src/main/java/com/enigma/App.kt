package com.enigma

import android.app.Application

class App : Application() {

    private var hkSP: SharedPref? = null




    override fun onCreate() {
        super.onCreate()

        mInstance = this

        hkSP = SharedPref()
        hkSP!!.SharedPref(this@App)



    }

    fun getSP(): SharedPref {
        return hkSP!!
    }

    companion object{
        private var mInstance: App? = null
        @Synchronized
        fun getInstance(): App {
            return mInstance!!
        }

    }

}