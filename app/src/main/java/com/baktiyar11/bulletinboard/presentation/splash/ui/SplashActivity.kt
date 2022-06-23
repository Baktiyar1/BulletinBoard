package com.baktiyar11.bulletinboard.presentation.splash.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.baktiyar11.bulletinboard.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private val splashBinding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(splashBinding.root)

    }
}