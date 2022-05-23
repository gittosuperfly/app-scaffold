package com.cai.app.data

import com.cai.app.data.api.TestApi
import com.cai.architecture.data.Hosts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    fun provideTestApi(@Hosts.Host1 retrofit: Retrofit): TestApi {
//        return retrofit.create(TestApi::class.java)
        return TestApi()
    }
}