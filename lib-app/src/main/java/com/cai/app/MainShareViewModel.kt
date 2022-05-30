package com.cai.app

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cai.app.data.store.TestStore
import com.cai.base.livedata.UnPeekLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainShareViewModel @Inject constructor(
    private val testStore: TestStore
) : ViewModel() {

    val text = UnPeekLiveData<String>().apply {
        value = "Hello!!!!!!!!"
    }

    fun init() {
        Log.d("TAG", "testStore.getData() = ${testStore.getData()}")
    }
}