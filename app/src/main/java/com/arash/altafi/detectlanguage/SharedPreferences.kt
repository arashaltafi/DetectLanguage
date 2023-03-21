package com.arash.altafi.detectlanguage

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences {

    companion object {
        private const val LANGUAGE = "language"
        private const val MY_PASS_CLASS = "my_pass_class"
    }

    private var preferences: SharedPreferences? = null

    fun sharedPrefLanguage(context: Context) {
        preferences = context.getSharedPreferences(MY_PASS_CLASS, Context.MODE_PRIVATE)
    }

    fun saveLanguage(theme: String?) {
        val editor: SharedPreferences.Editor = preferences!!.edit()
        editor.putString(LANGUAGE, theme)
        editor.apply()
    }

    fun getLanguage(): String = preferences?.getString(LANGUAGE, null) ?: "fa"

    fun clear() {
        val editor: SharedPreferences.Editor = preferences!!.edit()
        editor.clear()
        editor.apply()
    }

    fun remove() {
        val editor: SharedPreferences.Editor = preferences!!.edit()
        editor.remove(LANGUAGE)
        editor.apply()
    }

}