package com.cai.app.data.store

import com.cai.app.data.api.TestApi
import javax.inject.Inject


class TestStore @Inject constructor(
    private val service: TestApi
) {
    fun getData():String = service.getApiData()
}