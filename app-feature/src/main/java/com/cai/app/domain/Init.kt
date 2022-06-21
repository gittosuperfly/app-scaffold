package com.cai.app.domain

import android.app.Application
import android.util.Log
import com.cai.lib.startup.InitTask
import com.cai.lib.startup.annotation.Init

const val TAG = "com.cai.lib.startup"

@Init(priority = 20)
class AlphaInit : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}


@Init(background = true, process = "main", priority = 20)
class BetaInit : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}


@Init(background = true, process = "main", priority = 10)
class GammaInit : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}


@Init(priority = 40)
class DeltaInit : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}

@Init(priority = 10, depends = ["core-architecture:DeltaInit2", "OneInit"])
class FourInit : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}
@Init(priority = 10)
class OneInit : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}


@Init(priority = 10, background = true)
class TwoInit : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}

@Init
class ThreeInit : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name}")
    }
}



@Init(background = true)
class Alone1 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}

@Init(background = true)
class Alone2 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}
@Init(background = true)
class Alone3 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}
@Init(background = true)
class Alone4 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}
@Init(background = true)
class Alone5 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}
@Init(background = true)
class Alone6 : InitTask {
    override fun execute(app: Application) {
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} started")
        Thread.sleep(5000)
        Log.e(TAG, "this is ${javaClass.simpleName} in ${Thread.currentThread().name} done")
    }
}