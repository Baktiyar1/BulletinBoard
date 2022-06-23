package com.baktiyar11.bulletinboard.presentation.splash.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.baktiyar11.bulletinboard.presentation.registration.LogInFragment
import com.baktiyar11.bulletinboard.presentation.registration.RegistrationFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LogInFragment()
            1 -> RegistrationFragment()
            else -> Fragment()
        }
    }
}