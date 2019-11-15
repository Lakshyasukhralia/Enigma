package com.enigma

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : AppCompatActivity() {
    // Delayed removal of status and navigation bar

    // Note that some of these constants are new as of API 16 (Jelly Bean)
    // and API 19 (KitKat). It is safe to use them, as they are inlined
    // at compile-time and do nothing on earlier devices.

    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */

    var i: Int = 0
    val list = ArrayList<Int>()
    var len = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)


//        Handler().postDelayed({
//            startActivity(Intent(this@SplashActivity, ExerciseList::class.java))
//            finish()
//        }, 500)

        image.background =
            VectorDrawableCompat.create(resources, R.drawable.ic_weight_lifting, null)

        list.add(R.drawable.ic_fitness)
        list.add(R.drawable.ic_steps)
        list.add(R.drawable.ic_stretching)
        len = list.size

        changeImage()

    }


    fun changeImage() {
        Handler().postDelayed({
            if (i == len) {
                startActivity(Intent(this@SplashActivity, GoalActivity::class.java))
                finish()
            } else {
                image.background = VectorDrawableCompat.create(resources, list[i], null)
                i++
                changeImage()
            }


        }, 350)
    }


}
