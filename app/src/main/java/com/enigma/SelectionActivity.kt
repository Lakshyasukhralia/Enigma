package com.enigma

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.enigma.databinding.ContentSelectionBinding
import com.enigma.posenet.CameraActivity
import com.enigma.posenet.PosenetActivity

import kotlinx.android.synthetic.main.activity_selection.*

class SelectionActivity : AppCompatActivity() {

    lateinit var binding: ContentSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val content = findViewById<View>(R.id.content)

        binding = DataBindingUtil.bind<ContentSelectionBinding>(content) ?: return

        val videoId = intent.extras?.getString("videoId")

        binding.start.setOnClickListener {
//            startActivity(Intent(SelectionActivity@this, ResultScreenActivity::class.java).apply {
//                putExtra("score", 12)
//            })

            startActivity(Intent(SelectionActivity@this, CameraActivity::class.java).apply {
                putExtra("forCali", false)
            })
        }


        binding.play.setOnClickListener {
            startActivity(Intent(SelectionActivity@this, YouTubeFullScreenActivity::class.java).apply {
                putExtra("videoId", videoId)
            })
        }


        binding.calibrationButton.setOnClickListener {
            startActivity(Intent(SelectionActivity@this, CalibrationActivity::class.java).apply {
            })
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
