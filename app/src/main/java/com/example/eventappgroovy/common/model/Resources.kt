package com.example.eventappgroovy.common.model

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Resources<out T : Any> {

    data class Success<out T : Any>(val data: T) : Resources<T>()
    data class Error(val exception: String) : Resources<Nothing>()

    data class Failure(val messsage: String) : Resources<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Failure -> "Failure[Failure=$messsage]"
        }
    }

}