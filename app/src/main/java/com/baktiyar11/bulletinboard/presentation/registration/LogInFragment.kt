package com.baktiyar11.bulletinboard.presentation.registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.baktiyar11.bulletinboard.SharedPreference
import com.baktiyar11.bulletinboard.data.RetrofitBuilder
import com.baktiyar11.bulletinboard.databinding.FragmentLogInBinding
import com.baktiyar11.bulletinboard.domain.models.login.SignInResponse
import com.baktiyar11.bulletinboard.domain.models.login.User
import com.baktiyar11.bulletinboard.presentation.main.ui.activity.AnnouncementListsActivity
import com.baktiyar11.bulletinboard.utils.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInFragment : Fragment() {

    private val binding: FragmentLogInBinding by lazy {
        FragmentLogInBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loginButton.setOnClickListener {
                val email = signInEmail.text.toString().trim()
                val password = signInPassword.text.toString().trim()
                login(email, password)
            }
        }
    }

    private fun login(email: String, password: String) {
        binding.apply {
            if (email.isNotEmpty() || password.isNotEmpty() && password.length < 8) {
                loginButton.isClickable = false
                binding.loginProgress.visibility = View.VISIBLE
                val api = RetrofitBuilder.api.signIn(email, password)
                api.enqueue(object : Callback<SignInResponse> {
                    override fun onResponse(
                        call: Call<SignInResponse>, response: Response<SignInResponse>,
                    ) {
                        if (response.isSuccessful) {
                            val user = User(objectId = response.body()!!.objectId,
                                username = response.body()!!.username,
                                userEmail = response.body()!!.email,
                                userPassword = response.body()!!.password,
                                userPhone = response.body()!!.phone,
//                                userIcon = response.body()?.icon,
                            sessionToken = response.body()?.sessionToken)
                            toast("User ${user.username} is login!")
                            SharedPreference().saveCurrentUser(user, requireActivity())
                            startActivity(Intent(requireActivity(),
                                AnnouncementListsActivity::class.java))
                        } else loginButton.isClickable = true
                    }

                    override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                        Log.d("fail", t.message.toString())
                    }
                })
            } else {
                toast("Fill in a password or check if your passwords match!")
            }
        }
    }
}