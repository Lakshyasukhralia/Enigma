package com.enigma

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.enigma.databinding.ContentGoalBinding

import kotlinx.android.synthetic.main.activity_goal.*

class GoalActivity : AppCompatActivity() {

    lateinit var binding: ContentGoalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Select your goal"

        val content = findViewById<View>(R.id.content)
        binding = DataBindingUtil.bind<ContentGoalBinding>(content)!!

        binding.lean.imageView.background = VectorDrawableCompat.create(resources, R.drawable.ic_lean, null)
        binding.muscle.imageView.background = VectorDrawableCompat.create(resources, R.drawable.ic_muscle, null)


        binding.lean.textView3.text = "LEAN"
        binding.muscle.textView3.text = "MUSCLE"

        binding.lean.root.setOnClickListener {
            startActivity(Intent(GoalActivity@this, ExerciseList::class.java))
        }


        binding.muscle.root.setOnClickListener {
            startActivity(Intent(GoalActivity@this, ExerciseList::class.java))
        }
    }

}
