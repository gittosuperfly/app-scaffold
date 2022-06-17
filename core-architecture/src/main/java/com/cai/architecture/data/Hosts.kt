package com.cai.architecture.data

import javax.inject.Qualifier

annotation class Hosts {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Host1 {
        companion object {
            const val value = "http://192.168.31.1"
        }
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Host2 {
        companion object {
            const val value = "http://192.168.31.1"
        }
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Host3 {
        companion object {
            const val value = "http://192.168.31.1"
        }
    }
}