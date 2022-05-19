package com.cai.base.kvstore

/**
 * 忽略Store中的字段
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
annotation class FieldIgnore

/**
 * 重命名Store中的字段
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FIELD)
annotation class FieldRename(val value: String = "")

/**
 * 重命名Store
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FIELD)
annotation class StoreRename(val value: String = "")