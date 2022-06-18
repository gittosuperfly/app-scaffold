package com.cai.architecture

import android.app.Application
import android.util.Log
import com.cai.lib.startup.InitTask
import com.cai.lib.startup.annotation.Init

const val TAG = "com.cai.lib.startup"

@Init(priority = 20)
class AlphaInit2 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}


@Init(background = true, process = "main", priority = 20)
class BetaInit2 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}


@Init(background = true, process = "main", priority = 10)
class GammaInit2 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}


@Init(priority = 40)
class DeltaInit2 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}

@Init(priority = 10, depends = ["app:DeltaInit", "app:OneInit"])
class FourInit2 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}
@Init(priority = 10)
class OneInit2 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}


@Init(priority = 10, background = true)
class TwoInit2 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}

@Init
class ThreeInit2 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}



@Init(background = true)
class A2lone1 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}

@Init(background = true)
class A2lone2 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}
@Init(background = true)
class A2lone3 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}
@Init(background = true)
class A2lone4 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}
@Init(background = true)
class A2lone5 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}
@Init(background = true)
class A2lone6 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}