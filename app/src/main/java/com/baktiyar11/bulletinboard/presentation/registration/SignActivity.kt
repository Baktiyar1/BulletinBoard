package com.baktiyar11.bulletinboard.presentation.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.SharedPreference
import com.baktiyar11.bulletinboard.databinding.ActivitySignBinding
import com.baktiyar11.bulletinboard.presentation.main.ui.activity.AnnouncementListsActivity
import com.baktiyar11.bulletinboard.presentation.splash.adapter.ViewPagerAdapter
import com.baktiyar11.bulletinboard.utils.intentClearTask

class SignActivity : AppCompatActivity() {

    private val binding: ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    override fun onStart() {
        super.onStart()
        val user = SharedPreference().getCurrentUser(this)
        if (user != null) {
            intentClearTask(AnnouncementListsActivity())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.apply {
            viewPager.adapter = adapter
            bottomNavigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.logInFragment -> viewPager.currentItem = 0
                    R.id.registrationFragment -> viewPager.currentItem = 1
                }
                return@setOnItemSelectedListener true
            }

            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    when (position) {
                        0 -> bottomNavigationView.selectedItemId = R.id.logInFragment
                        1 -> bottomNavigationView.selectedItemId = R.id.registrationFragment
                    }
                    super.onPageSelected(position)
                }
            })
        }
    }
}