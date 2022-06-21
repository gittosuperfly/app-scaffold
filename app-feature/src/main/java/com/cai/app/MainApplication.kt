package com.cai.app

import androidx.lifecycle.ProcessLifecycleOwner
import com.cai.app.domain.ProcessLifecycleObserver
import com.cai.architecture.BaseApplication
import com.cai.lib.startup.InitManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        InitManager.init(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(ProcessLifecycleObserver())
    }
}