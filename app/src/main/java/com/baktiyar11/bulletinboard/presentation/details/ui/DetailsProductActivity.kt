package com.baktiyar11.bulletinboard.presentation.details.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baktiyar11.bulletinboard.databinding.ActivityDetailsProductBinding

class DetailsProductActivity : AppCompatActivity() {

    private val binding: ActivityDetailsProductBinding by lazy {
        ActivityDetailsProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}