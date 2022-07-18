package com.baktiyar11.bulletinboard.presentation

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import com.baktiyar11.bulletinboard.utils.AUTO_LANGUAGE
import com.baktiyar11.bulletinboard.utils.KEY_DEFAULT_LANGUAGE
import com.baktiyar11.bulletinboard.utils.SETTING_LANGUAGE_AUTO_KEY
import com.baktiyar11.bulletinboard.utils.dataStore
import com.yariksoffice.lingver.Lingver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

object SettingManager {
    fun setAppSetting(scope: CoroutineScope, context: Context) {
        scope.launch {
            context.dataStore.data.collectLatest { pref ->
                val lang = pref[stringPreferencesKey(KEY_DEFAULT_LANGUAGE)]
                setAppLanguage(lang ?: SETTING_LANGUAGE_AUTO_KEY, context = context)
            }
        }
    }

    private fun setAppLanguage(lang: String, context: Context) {
        if (lang.equals(AUTO_LANGUAGE, true)) Lingver.getInstance().setFollowSystemLocale(context)
        else Lingver.getInstance().setLocale(context, lang)
    }
}