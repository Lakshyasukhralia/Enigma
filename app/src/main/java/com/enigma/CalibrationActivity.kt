package com.enigma

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.enigma.databinding.ContentCalibrationBinding
import com.enigma.posenet.CameraActivity
import com.enigma.posenet.PosenetActivity

import kotlinx.android.synthetic.main.activity_calibration.*

class CalibrationActivity : AppCompatActivity() {

    lateinit var binding: ContentCalibrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calibration)
        setSupportActionBar(toolbar)


        val content = findViewById<View>(R.id.content)
        binding = DataBindingUtil.bind<ContentCalibrationBinding>(content)!!

        binding.add.setOnClickListener {
            startActivity(Intent(CalibrationActivity@this, CameraActivity::class.java)
                .apply {
                    putExtra("forCali", true)
                })
        }

        binding.clearData.setOnClickListener {
            App.getInstance().getSP().dataFirst(0,0,0,0)
            App.getInstance().getSP().dataSecond(0,0,0,0)
        }


        if(App.getInstance().getSP().diffLSE() != 0){
            binding.textView2.setText(App.getInstance().getSP().diffLSE().toString() +  ", " + App.getInstance().getSP().diffRSE().toString() + ", " + App.getInstance().getSP().diffE().toString() + ", " + App.getInstance().getSP().diffS().toString())
        }



        if(App.getInstance().getSP().LS() != 0){
            binding.textView4.setText(App.getInstance().getSP().LS().toString() +  ", " + App.getInstance().getSP().LE().toString() + ", " + App.getInstance().getSP().RE().toString() + ", " + App.getInstance().getSP().RS().toString())
        }

    }

}
