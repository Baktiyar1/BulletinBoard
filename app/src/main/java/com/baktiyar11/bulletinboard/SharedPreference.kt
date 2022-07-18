package com.baktiyar11.bulletinboard

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.baktiyar11.bulletinboard.domain.models.login.User
import com.baktiyar11.bulletinboard.utils.CURRENT_STUDENT_EDITOR_SAVE_KEY
import com.baktiyar11.bulletinboard.utils.CURRENT_STUDENT_SAVE_KEY
import com.google.gson.Gson

class SharedPreference {
    fun saveCurrentUser(user: User, activity: Activity) =
        activity.getSharedPreferences(CURRENT_STUDENT_EDITOR_SAVE_KEY, Context.MODE_PRIVATE)
            .edit().putString(CURRENT_STUDENT_SAVE_KEY, Gson().toJson(user)).apply()

    fun getCurrentUser(activity: Context): User? {
        val pref: SharedPreferences? =
            activity.getSharedPreferences(CURRENT_STUDENT_EDITOR_SAVE_KEY, Context.MODE_PRIVATE)
        return Gson().fromJson(pref?.getString(CURRENT_STUDENT_SAVE_KEY, null), User::class.java)
    }

    fun loginOut(activity: Activity) =
        activity.getSharedPreferences(CURRENT_STUDENT_EDITOR_SAVE_KEY, Context.MODE_PRIVATE).edit()
            .clear().commit()
}