package com.gwolf.freshcart.util

sealed class UiResult<out R> {
    data class Success<out T>(val data: T) : UiResult<T>()
    data class Error(val exception: Exception) : UiResult<Nothing>()
}