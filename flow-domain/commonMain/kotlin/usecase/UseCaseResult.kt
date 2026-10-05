/**
 * Represents the result of a use case execution.
 */
sealed interface UseCaseResult<out T> {
    data class Success<T>(val data: T) : UseCaseResult<T>
    data class Error(val code: ErrorCode, val message: String) : UseCaseResult<T>
}