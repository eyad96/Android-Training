package com.training.app

import android.app.Application
import android.content.ContextWrapper
import com.google.firebase.FirebaseApp
import com.pixplicity.easyprefs.library.Prefs

class Applicationclass : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()

    }

}