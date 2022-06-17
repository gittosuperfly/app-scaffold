package com.cai.app.domain

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class ProcessLifecycleObserver : DefaultLifecycleObserver {
    
    companion object{
        private const val TAG = "ProcessLifecycleObserve"
    }
    
    override fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, "onCreate: ")
    }
    
    override fun onStart(owner: LifecycleOwner) {
        Log.d(TAG, "onStart: ")
    }
    
    override fun onResume(owner: LifecycleOwner) {
        Log.d(TAG, "onResume: ")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d(TAG, "onPause: ")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "onStop: ")
    }
    
    override fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG, "onDestroy: ")
    }

}