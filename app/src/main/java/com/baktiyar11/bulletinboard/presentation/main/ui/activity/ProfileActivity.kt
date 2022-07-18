package com.baktiyar11.bulletinboard.presentation.main.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.baktiyar11.bulletinboard.R
import com.baktiyar11.bulletinboard.SharedPreference
import com.baktiyar11.bulletinboard.data.RetrofitBuilder
import com.baktiyar11.bulletinboard.databinding.ActivityProfileBinding
import com.baktiyar11.bulletinboard.domain.models.Image
import com.baktiyar11.bulletinboard.domain.models.login.SaveImageQuestionCloud
import com.baktiyar11.bulletinboard.domain.models.login.User
import com.baktiyar11.bulletinboard.utils.IMAGE_REQUEST
import com.baktiyar11.bulletinboard.utils.RESULT_LOAD_IMAGE
import com.baktiyar11.bulletinboard.utils.toast
import com.baktiyar11.bulletinboard.utils.uriToImage
import com.parse.ParseFile
import com.parse.SaveCallback
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    private val binding: ActivityProfileBinding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }
    private val user: User by lazy {
        SharedPreference().getCurrentUser(this@ProfileActivity) as User
    }
    private val posterImage: Image? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {

            detailsUsernameProfile.text = user.username
            detailsEmailProfile.text = user.userEmail
            detailsPhoneProfile.text = user.userPhone
            if (user.userIcon?.url != null) Picasso.get().load(user.userIcon?.url)
                .into(imageProfile)
            else Picasso.get().load(R.drawable.person).into(imageProfile)

            imageProfile.setOnClickListener { openGallery() }
        }
    }

    private fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, IMAGE_REQUEST)
    }

    private fun saveIcon() {
        val response = RetrofitBuilder.api.updateUser(id = user.objectId!!,
            saveIcon = SaveImageQuestionCloud(user.userIcon!!), sessionToken = user.sessionToken!!)
        response.enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    SharedPreference().loginOut(this@ProfileActivity)
                    SharedPreference().saveCurrentUser(user, this@ProfileActivity)
                    toast("Image is saved!")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    @Deprecated(message = "Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            posterImage?.url = data.data!!.toString()
            val poster = ParseFile("icon.png", uriToImage(data.data!!))
            poster.saveInBackground(SaveCallback {
                if (it == null) {
                    user.userIcon = Image(url = poster.url)
                    Picasso.get().load(posterImage?.url).into(binding.imageProfile)
                    saveIcon()
                } else {
                    toast("An error has occurred. Failed to save image!")
                    toast(it.message.toString())
                }
            })
        }
    }
}