package com.anna.demeshko.millionaire

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ReadQuestionsService : Service() {

    private val binder = SimpleClientServerBinder()
    private val gson = Gson()

    override fun onBind(intent: Intent): IBinder? {
        return binder
    }

    fun readQuestions(): MutableList<Question> {
        val inputStream = assets.open("questions.txt")
        val json = inputStream.bufferedReader().use { it.readText() }
        val listType = object : TypeToken<MutableList<Question>>() {}.type
        return gson.fromJson(json, listType)
    }

    inner class SimpleClientServerBinder : Binder() {
        val service: ReadQuestionsService
            get() = this@ReadQuestionsService
    }
}