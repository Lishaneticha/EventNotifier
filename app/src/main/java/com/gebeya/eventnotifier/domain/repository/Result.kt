package com.gebeya.eventnotifier.domain.repository

sealed class Result<T>(
    val data: T? = null,
    val errorMessage: String? = null
) {
    class Success<T>(data: T): Result<T>(data = data)
    class Fail<T>(errorMessage: String): Result<T>(errorMessage = errorMessage)
}