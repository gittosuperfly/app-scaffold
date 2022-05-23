package com.cai.architecture.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object RetrofitHostModule {

    @Provides
    @Hosts.Host1
    fun provideHost1(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(Hosts.Host1.value).build()
    }

    @Provides
    @Hosts.Host2
    fun provideHost2(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(Hosts.Host2.value).build()
    }

    @Provides
    @Hosts.Host3
    fun provideHost3(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(Hosts.Host3.value).build()
    }
}