package com.anna.demeshko.millionaire

import android.content.Context
import android.content.SharedPreferences


class PreferencesHelper
constructor(context: Context) {

    private val pref: SharedPreferences

    var questionCount: Int
        get() = pref.getInt(Constants.QUESTION_COUNT, 5)
        set(count) = pref.edit().putInt(Constants.QUESTION_COUNT, count).apply()

    var isHintEnabled: Boolean
        get() = pref.getBoolean(Constants.IS_HINT_ENABLED, false)
        set(value) = pref.edit().putBoolean(Constants.IS_HINT_ENABLED, value).apply()

    init {
        this.pref = context.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    }

    companion object {

        private const val PREFERENCES_FILE_NAME = "millionaire_pref_file"
    }
}