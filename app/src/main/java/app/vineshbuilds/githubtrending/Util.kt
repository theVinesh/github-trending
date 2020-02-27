package app.vineshbuilds.githubtrending

import app.vineshbuilds.githubtrending.Result.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException

const val MAX_RETRIES = 3
@ExperimentalCoroutinesApi
fun <O> fetch(fn: suspend () -> O) =
    flow { emit(Success(fn())) }
        .applyCommonSideEffects()
        .catch { e -> emit(Failure(e)) }

@ExperimentalCoroutinesApi
fun <T> Flow<Result<T>>.applyCommonSideEffects() =
    retryWhen { cause, attempt ->
        when {
            (cause is IOException && attempt < MAX_RETRIES) -> {
                delay(getBackoffDelay(attempt))
                true
            }
            cause is HttpException -> {
                emit(Failure(cause))
                false
            }
            else -> {
                false
            }
        }
    }
        .onStart { emit(Loading()) }

fun getBackoffDelay(attempt: Long): Long = attempt * 100
