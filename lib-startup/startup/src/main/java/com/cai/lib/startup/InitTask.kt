package com.cai.lib.startup

import android.app.Application

interface InitTask {
    fun execute(app: Application)
}