package app.vineshbuilds.githubtrending

sealed class Result<O>() {
    class Success<T>(val data: T) : Result<T>()
    class Failure<T>(val e: Throwable) : Result<T>()
    class Loading<T>() : Result<T>()
}
