package com.baktiyar11.bulletinboard.presentation.registration

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.baktiyar11.bulletinboard.domain.models.login.ServerResponse
import com.baktiyar11.bulletinboard.data.RetrofitBuilder
import com.baktiyar11.bulletinboard.databinding.FragmentRegistrationBinding
import com.baktiyar11.bulletinboard.domain.models.login.User
import com.baktiyar11.bulletinboard.presentation.App
import com.baktiyar11.bulletinboard.presentation.main.ui.AnnouncementListsActivity
import com.baktiyar11.bulletinboard.utils.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationFragment : Fragment() {

    private val binding: FragmentRegistrationBinding by lazy {
        FragmentRegistrationBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment\
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            signUpButton.setOnClickListener {
                val username = signUpUsername.text.toString().trim()
                val email = signUpEmail.text.toString().trim()
                val phone = signUpPhone.text.toString().trim()
                val password = signUpPassword.text.toString().trim()
                val confirm = signUpConfirm.text.toString().trim()
                signUp(username, email, phone, password, confirm)
                Log.i("QQQQQ", "sndcndsjk")
            }
        }
    }

    private fun signUp(username: String, email: String, phone: String, password: String, confirm: String) {
        binding.apply {
            if (username.isNotEmpty() || email.isNotEmpty() || phone.isNotEmpty() || password.isNotEmpty() || confirm.isNotEmpty()) {
                if (password == confirm) {
                    val user = User()
                    user.userEmail = email
                    user.userPhone = phone
                    user.username = username
                    user.userPassword = password
                    val api = RetrofitBuilder.api.createUser(user)
                    api.enqueue(object : Callback<ServerResponse> {
                        override fun onResponse(
                            call: Call<ServerResponse>,
                            response: Response<ServerResponse>,
                        ) {
                            if (response.isSuccessful) {
                                toast("New user ${user.username} is created!")
                                App.pref = requireActivity().getSharedPreferences("pref", MODE_PRIVATE)
                                val editor = App.pref?.edit()
                                editor?.putString("userName", user.username)
                                editor?.putString("phone", user.userPhone)
                                editor?.apply()
                                startActivity(Intent(requireActivity(), AnnouncementListsActivity::class.java))
                            }
                        }

                        override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                            Log.d("fail", t.message.toString())
                        }
                    })
                } else {
                    toast("Fill in a password or check if your passwords match!")
                }
            } else {
                toast("Fill in all the fields!")
            }
        }
    }
}