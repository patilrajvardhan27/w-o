package com.example.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.a7minuteworkout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private var binding: ActivityExerciseBinding? = null

    private var restTimer : CountDownTimer?=null
    private var restProgress =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setRestProgressBar(){
        binding?.progressBar?.progress =restProgress

        restTimer = object :CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding?.progressBar?.progress =10- restProgress
                binding?.tvTimer?.text = (10-restProgress).toString()

            }

            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                "Here we will start exercise",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    }
}