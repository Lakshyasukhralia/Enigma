package com.enigma

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPref {

    private lateinit var  mSharedPreferences: SharedPreferences
    private lateinit var e: SharedPreferences.Editor


     fun SharedPref(app: Application){
        mSharedPreferences = app.getSharedPreferences("Preference", MODE_PRIVATE)
        e = mSharedPreferences.edit()
    }


    fun dataFirst(diffLSE : Int, diffRSE : Int, diffS : Int, diffE : Int){
        e.putInt("diffLSE", diffLSE)
        e.putInt("diffRSE", diffRSE)
        e.putInt("diffS", diffS)
        e.putInt("diffE", diffE)
        e.apply()
    }


    fun dataSecond(LE : Int, LS : Int, RE : Int, RS : Int){
        e.putInt("LE", LE)
        e.putInt("LS", LS)
        e.putInt("RE", RE)
        e.putInt("RS", RS)
        e.apply()
    }

    fun diffLSE() : Int{
        return mSharedPreferences.getInt("diffLSE", 0)
    }

    fun diffRSE() : Int{
        return mSharedPreferences.getInt("diffRSE", 0)
    }

    fun diffS() : Int{
        return mSharedPreferences.getInt("diffS", 0)
    }

    fun diffE() : Int{
        return mSharedPreferences.getInt("diffE", 0)
    }

    fun LE() : Int{
        return mSharedPreferences.getInt("LE", 0)
    }

    fun LS() : Int{
        return mSharedPreferences.getInt("LS", 0)
    }

    fun RE() : Int{
        return mSharedPreferences.getInt("RE", 0)
    }

    fun RS() : Int{
        return mSharedPreferences.getInt("RS", 0)
    }

}