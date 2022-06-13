package com.cai.base.binding.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.reflect.Method


const val INFLATE_NAME = "inflate"
const val BIND_NAME = "bind"

fun <T> Class<T>.inflateMethod(): Method = getMethod(INFLATE_NAME, LayoutInflater::class.java)

fun <T> Class<T>.inflateMethodWithViewGroup(): Method =
    getMethod(INFLATE_NAME, LayoutInflater::class.java, ViewGroup::class.java)

fun <T> Class<T>.bindMethod(): Method = getMethod(BIND_NAME, View::class.java)