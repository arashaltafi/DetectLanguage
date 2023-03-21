package com.arash.altafi.detectlanguage

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import java.util.*

class LocaleUtils {
    companion object {

        @JvmStatic
        fun setLocale(c: Context, language: String): Context = updateResources(c, language)

        fun setNewLocale(c: Context, language: String): Context {
            return updateResources(
                c,
                language
            )
        }

        fun getLanguage(): String = Locale.getDefault().displayLanguage


        fun getLocale(res: Resources): Locale {
            val config = res.configuration
            return if (Build.VERSION.SDK_INT >= 24)
                config.locales.get(0)
            else config.locale
        }

        @JvmStatic
        private fun updateResources(
            context: Context, language: String
        ): Context {
            val locale = Locale(language)
            Locale.setDefault(locale)

            val res = context.resources
            val config = Configuration()
            config.setLocale(locale)

            config.locale = locale
            context.createConfigurationContext(config)
            res.updateConfiguration(config, res.displayMetrics)

            return context.createConfigurationContext(config)
        }
    }
}