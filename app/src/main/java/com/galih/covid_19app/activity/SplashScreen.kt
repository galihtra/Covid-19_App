package com.galih.covid_19app.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.galih.covid_19app.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    private val binding by lazy { ActivitySplashScreenBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupView()
        setupListener()
    }

    private fun setupView() {
        supportActionBar!!.hide()
    }

    private fun setupListener() {
        binding.icArrow.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        binding.tvStart.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}