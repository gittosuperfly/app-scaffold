package com.cai.base.kvstore

interface IKV {
    fun apply() {
        KVStore.find(javaClass).apply()
    }

    fun commit() {
        KVStore.find(javaClass).commit()
    }
}