package com.baktiyar11.bulletinboard.presentation.registration

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.baktiyar11.bulletinboard.databinding.FragmentLogInBinding
import com.baktiyar11.bulletinboard.presentation.main.ui.AnnouncementListsActivity
import com.baktiyar11.bulletinboard.utils.toast
import com.parse.ParseUser

class LogInFragment : Fragment() {

    private val bindingLogIn: FragmentLogInBinding by lazy {
        FragmentLogInBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return bindingLogIn.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingLogIn.apply {
            signInButton.setOnClickListener {
                val email = signInEmail.text.toString().trim()
                val password = signInPassword.text.toString().trim()
                login(email, password)
            }
            signInForgot.setOnClickListener {
            }
        }
    }

    private fun login(email: String, userPassword: String) {
        ParseUser.logInInBackground(email, userPassword) { parseUser, e ->
            if (parseUser != null) {
                toast("User is LOGGED in!")
                    startActivity(Intent(requireActivity(), AnnouncementListsActivity::class.java))
            } else {
                ParseUser.logOut()
                toast(e.message.toString())
            }
        }
    }
}