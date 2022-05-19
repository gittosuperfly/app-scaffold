package com.cai.base.kvstore

interface IStore {
    fun apply() {
        KVStore.find(javaClass).apply()
    }

    fun commit() {
        KVStore.find(javaClass).commit()
    }
}