package com.cai.app

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.cai.app.data.store.TestStore
import com.cai.base.livedata.UnPeekLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainShareViewModel @Inject constructor(
    private val testStore: TestStore
) : ViewModel() {

    val statusBarDark = UnPeekLiveData<Boolean>()
    val isDrawerOpened = ObservableBoolean()


}