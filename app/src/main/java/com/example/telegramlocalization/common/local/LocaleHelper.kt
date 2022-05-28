package com.example.telegramlocalization.common.local

import android.content.Context
import android.content.res.Configuration
import com.example.telegramlocalization.di.PreferencesHelper
import java.util.*
import javax.inject.Inject

class LocaleHelper @Inject constructor(
    private val preferencesHelper: PreferencesHelper
) {
    fun loadLocale(context: Context): Context {
        val language = preferencesHelper.getLanguage()!!
        val locale = Locale(language)
        Locale.setDefault(locale)
        val newConfiguration = Configuration()
        newConfiguration.setLocale(locale)
        context.resources.updateConfiguration(newConfiguration, context.resources.displayMetrics)
        context.createConfigurationContext(newConfiguration)
        return context
    }
}