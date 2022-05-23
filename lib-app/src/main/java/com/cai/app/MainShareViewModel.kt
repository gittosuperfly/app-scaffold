package com.cai.app

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cai.app.data.store.TestStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainShareViewModel @Inject constructor(
    private val testStore: TestStore
) : ViewModel() {

    fun init() {
        Log.d("TAG", "testStore.getData() = ${testStore.getData()}")
    }
}