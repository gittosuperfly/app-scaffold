package com.cai.app

import androidx.lifecycle.ProcessLifecycleOwner
import com.cai.app.domain.ProcessLifecycleObserver
import com.cai.architecture.BaseApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ProcessLifecycleObserver())
    }
}