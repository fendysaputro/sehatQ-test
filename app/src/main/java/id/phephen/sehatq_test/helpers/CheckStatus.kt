package id.phephen.sehatq_test.helpers

/**
 * Created by phephen on 23,January,2021
 * https://github.com/fendysaputro
 */
sealed class CheckStatus<T>(
        val data: T? = null,
        val message: String? = null
) {
    class Success<T>(data: T) : CheckStatus<T>(data)
    class Error<T>(message: String, data: T? = null) : CheckStatus<T>(data, message)
    class Loading<T> : CheckStatus<T>()
}