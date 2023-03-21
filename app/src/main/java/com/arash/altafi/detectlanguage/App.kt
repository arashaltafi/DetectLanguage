package com.arash.altafi.detectlanguage

import android.app.Application

class App: Application() {

    private val sharedPreferences = SharedPreferences()

    override fun onCreate() {
        super.onCreate()

        sharedPreferences.sharedPrefLanguage(this)

        LocaleUtils.setLocale(this, sharedPreferences.getLanguage())
    }

    override fun onConfigurationChanged(newConfig: android.content.res.Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleUtils.setLocale(this, sharedPreferences.getLanguage())
    }

}