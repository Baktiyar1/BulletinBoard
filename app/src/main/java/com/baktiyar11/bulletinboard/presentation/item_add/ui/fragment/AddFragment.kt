package com.baktiyar11.bulletinboard.presentation.item_add.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.baktiyar11.bulletinboard.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private val binding: FragmentAddBinding by lazy {
        FragmentAddBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

}