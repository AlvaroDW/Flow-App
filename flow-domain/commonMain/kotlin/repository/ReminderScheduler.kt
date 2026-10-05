/**
 * Represents the scheduler interface for managing reminders in the system.
 */
interface ReminderScheduler {
    suspend fun schedule(reference: ReminderReference): Result<Unit>
    suspend fun cancel(id: String): Result<Unit>
    suspend fun cancelAllForTask(taskId: String): Result<Unit>
    suspend fun isSupported(): Boolean  // For graceful degradation
}