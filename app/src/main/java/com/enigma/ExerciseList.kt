package com.enigma

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.enigma.databinding.ContentExerciseListBinding

import kotlinx.android.synthetic.main.activity_exercise_list.*

class ExerciseList : AppCompatActivity() {
    private lateinit var binding: ContentExerciseListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_list)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Select Exercise"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val content = findViewById<View>(R.id.content)
        binding =  DataBindingUtil.bind<ContentExerciseListBinding>(content) ?: return


        binding.squats.imageView.background = VectorDrawableCompat.create(resources, R.drawable.ic_squat, null)
        binding.pushups.imageView.background = VectorDrawableCompat.create(resources, R.drawable.ic_push_ups, null)
        binding.lunges.imageView.background = VectorDrawableCompat.create(resources, R.drawable.ic_crunches, null)
        binding.shoulder.imageView.background = VectorDrawableCompat.create(resources, R.drawable.ic_shoulder, null)

        binding.pushups.textView3.text = getString(R.string.push_up)
        binding.squats.textView3.text = getString(R.string.squats)
        binding.lunges.textView3.text = getString(R.string.lunges)
        binding.shoulder.textView3.text = getString(R.string.shoulder)



        binding.squats.root.setOnClickListener {
         startActivity(Intent(SelectionActivity@this, SelectionActivity::class.java).apply {
             putExtra("videoId", "kGooAJM3294")
         })
        }


        binding.pushups.root.setOnClickListener {
            startActivity(Intent(SelectionActivity@this, SelectionActivity::class.java).apply {
                putExtra("videoId", "kGooAJM3294")
            })
        }

        binding.lunges.root.setOnClickListener {
            startActivity(Intent(SelectionActivity@this, SelectionActivity::class.java).apply {
                putExtra("videoId", "kGooAJM3294")
            })
        }

        binding.shoulder.root.setOnClickListener {
            startActivity(Intent(SelectionActivity@this, SelectionActivity::class.java).apply {
                putExtra("videoId", "kGooAJM3294")
            })
        }

    }



}
